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
import org.scalatest.exceptions.TestFailedException
import uk.gov.hmrc.test.ui.pages.{AuthPage, CommonPage, RegisteredCompanyNamePage}

class RegistrationStepDef extends BaseStepDef {

  Given("a user is signed in") { () =>
    AuthPage.signIn("/registeredCompanyName")
  }

  When("""^the user enters (.*) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.enterData(data)
  }

  When("""^the user adds (first|second) (member state|VAT number) (.*) on the (.*) page$""") {
    (index: String, input: String, data: String, url: String) =>
      index match {
        case "first"  => CommonPage.checkIndexUrl(url + "/1")
        case "second" => CommonPage.checkIndexUrl(url + "/2")
        case _        => throw new Exception("Index doesn't exist")
      }
      CommonPage.enterData(data)
  }

  When("""^the user answers (yes|no) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.selectAnswer(data)
  }

  Then("""^the user should be on the (.*) page$""") { (url: String) =>
    CommonPage.checkUrl(url)
  }

  When("""^the user provides date (.*) on the (.*) page$""") { (date: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.provideDate(date)
  }
}
