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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import org.openqa.selenium.By

object AuthActions extends BrowserDriver {

  def loginUsingScpStub(affinityGroup: String, vrn: String): Unit = {

    driver.findElement(By.partialLinkText("Register SCP User")).click()
    val select = new Select(driver.findElement(By.id("accountType")))
    select.selectByValue(affinityGroup)

    driver.findElement(By.id("isAdmin-true")).click()
    driver.findElement(By.id("groupProfile")).sendKeys("123")

    driver.findElement(By.id("enrolment[0].name")).sendKeys("HMRC-MTD-VAT")
    driver.findElement(By.id("enrolment[0].identifier")).sendKeys("VRN")
    driver.findElement(By.id("enrolment[0].value")).sendKeys(vrn)

    driver.findElement(By.className("submit")).click()
  }

  def selectMfaSuccess(): Unit = {
    driver.findElement(By.id("mfaOutcome-success")).click()
    driver.findElement(By.className("submit")).click()
  }
}
