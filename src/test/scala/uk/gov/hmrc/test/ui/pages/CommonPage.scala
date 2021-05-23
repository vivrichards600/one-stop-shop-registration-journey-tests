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

import org.openqa.selenium.By
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import io.cucumber.datatable.DataTable
import scala.collection.JavaConverters._

object CommonPage extends BrowserDriver with Matchers {

  def constructUrl(prettyUrl: String): String =
    (prettyUrl.head.toLower + prettyUrl.tail).replace(" ", "")

  def constructCYAUrl(prettyUrl: String): String =
    prettyUrl.toLowerCase.replace(" ", "-")

  def checkUrl(url: String): Unit =
    driver.getCurrentUrl should endWith(constructUrl(url))

  def checkCYAUrl(url: String): Unit =
    driver.getCurrentUrl should endWith(constructCYAUrl(url))

  def getNonAuthUrl(url: String): Unit = {
    driver.manage().deleteAllCookies()
    driver.navigate().to("http://localhost:10200/one-stop-shop-registration/" + constructUrl(url))
  }

  def enterData(data: String): Unit = {
    val inputId = "value"
    driver.findElement(By.id(inputId)).sendKeys(data)
    driver.findElement(By.xpath("//*[@id='main-content']/div/div/form/button")).click()
  }

  def provideDate(date: String): Unit = {
    driver.findElement(By.id("value.day")).sendKeys(date.substring(0, 2))
    driver.findElement(By.id("value.month")).sendKeys(date.substring(3, 5))
    driver.findElement(By.id("value.year")).sendKeys(date.substring(6, 10))
    driver.findElement(By.xpath("//*[@id='main-content']/div/div/form/button")).click()
  }

  def selectAnswer(data: String): Unit = {
    data match {
      case "yes" => driver.findElement(By.id("value")).click()
      case "no"  => driver.findElement(By.id("value-no")).click()
      case id    => driver.findElement(By.id(id)).click()
    }
    driver.findElement(By.xpath("//*[@id='main-content']/div/div/form/button")).click()
  }

  def completeForm(dataTable: DataTable): Unit = {
    dataTable.asMaps[String, String](classOf[String], classOf[String]).asScala.foreach { row =>
      driver.findElement(By.id(row.get("fieldId"))).sendKeys(row.get("data"))
    }
    driver.findElement(By.xpath("//*[@id='main-content']/div/div/form/button")).click()
  }

  def submitRegistration(): Unit =
    driver.findElement(By.xpath("//*[@id='main-content']/div/div/form/button")).click()
}
