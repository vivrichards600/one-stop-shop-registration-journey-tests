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

import org.openqa.selenium.{By, WebElement}
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import io.cucumber.datatable.DataTable
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.JavaConverters._

object CommonPage extends BrowserDriver with Matchers {

  def checkUrl(url: String): Unit =
    driver.getCurrentUrl should endWith(url)

  val url: String                = TestConfiguration.url("one-stop-shop-registration-frontend")
  def goToStartOfJourney(): Unit =
    driver.navigate().to(url)

  def enterData(data: String): Unit = {
    val inputId = "value"
    driver.findElement(By.id(inputId)).sendKeys(data)
    driver.findElement(By.xpath("//*[@id='main-content']/div/div/form/button")).click()
  }

  def waitForElement(by: By): WebElement =
    new WebDriverWait(driver, 3).until {
      ExpectedConditions.presenceOfElementLocated(by)
    }

  def selectValueAutocomplete(data: String): Unit = {
    val inputId = "value"
    driver.findElement(By.id(inputId)).sendKeys(data)
    waitForElement(By.id(inputId))
    driver.findElement(By.cssSelector("li#value__option--0")).click()
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
      case _     => throw new Exception("Option doesn't exist")
    }
    driver.findElement(By.xpath("//*[@id='main-content']/div/div/form/button")).click()
  }

  def completeForm(dataTable: DataTable): Unit = {
    dataTable.asMaps[String, String](classOf[String], classOf[String]).asScala.foreach { row =>
      driver.findElement(By.id(row.get("fieldId"))).sendKeys(row.get("data"))
    }
    driver.findElement(By.cssSelector(".govuk-button")).click()
  }

  def submitRegistration(): Unit =
    driver.findElement(continueButton).click()

  def clickContinue(): Unit =
    driver.findElement(continueButton).click()

  def continueButton: By = By.cssSelector(".govuk-button")

  def businessResponsibleReportingPayingVATEUCountries(): Unit = {
    checkUrl("already-eu-registered")
    selectAnswer("no")

    checkUrl("sell-from-northern-ireland")
    selectAnswer("yes")

    checkUrl("northern-ireland-business")
    selectAnswer("yes")

    checkUrl("business-pay")
    clickContinue()
  }

}
