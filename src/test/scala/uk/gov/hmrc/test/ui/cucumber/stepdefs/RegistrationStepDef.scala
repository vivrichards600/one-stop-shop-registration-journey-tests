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
import uk.gov.hmrc.test.ui.pages.{LoginPage, RegisteredCompanyNamePage}

class RegistrationStepDef extends BaseStepDef {

  private def constructUrl(prettyUrl: String): String =
    prettyUrl.replace(" ", "")

  Given("a user is signed in") { () =>
    driver.navigate().to(LoginPage.url)

    driver.findElement(By.name("redirectionUrl")).clear()
    driver.findElement(By.name("redirectionUrl")).sendKeys(RegisteredCompanyNamePage.url)
    driver.findElement(By.cssSelector("Input[value='Submit']")).click()

    eventually {
      driver.getCurrentUrl should be(RegisteredCompanyNamePage.url)
    }
  }

  When("""^the user enters (.*) on the (.*) page$""") { (data: String, url: String) =>
    driver.getCurrentUrl should endWith(constructUrl(url))

    val inputId = "value"
    driver.findElement(By.id(inputId)).sendKeys(data)
    driver.findElement(By.cssSelector("Button[value='Continue']")).click()
  }

  Then("""^the user should be on the (.*) page$""") { (url: String) =>
    driver.getCurrentUrl should endWith(constructUrl(url))
  }
}
