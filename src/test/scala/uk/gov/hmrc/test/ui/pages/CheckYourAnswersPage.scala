/*
 * Copyright 2021 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.pages

import io.cucumber.datatable.DataTable
import org.openqa.selenium.By
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import uk.gov.hmrc.test.ui.pages.CommonPage.selectLink

import scala.collection.JavaConverters._

object CheckYourAnswersPage extends BrowserDriver with Matchers {

  def changeAnswers(dataTable: DataTable): Unit =
    dataTable.asMaps[String, String](classOf[String], classOf[String]).asScala.foreach { row =>
      val link = "change" + row.get("page").replace(" ", "")
      driver.findElement(By.cssSelector(s"a[href*=$link]")).click()
      CommonPage.checkUrl(link)
      driver.findElement(By.id("value")).clear()
      driver.findElement(By.id("value")).sendKeys(row.get("data"))
      driver.findElement(By.xpath("//*[@id='main-content']/div/div/form/button")).click()
    }

  def changeUkTradingName(): Unit = selectLink("check-have-uk-trading-name")

  def changeTaxInEu(): Unit = selectLink("check-tax-in-eu")

  def giveWebsiteAddress(): WebsiteAddressesPage.type = {
    CommonPage.checkUrl("check-answers")
    selectLink("check-give-website-address")
    CommonPage.checkUrl("check-give-website-address")
    WebsiteAddressesPage
  }
}
