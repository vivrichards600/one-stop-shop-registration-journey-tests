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

import io.cucumber.datatable.DataTable
import org.scalatestplus.selenium.Chrome.textField
import uk.gov.hmrc.test.ui.pages._

import scala.jdk.CollectionConverters.asScalaBufferConverter

class RegistrationStepDef extends BaseStepDef {

  Given("^the user accesses the service$") { () =>
    CommonPage.goToStartOfJourney()
  }

  Given("a user is signed in") { () =>
    AuthPage.signIn()
  }

  Given("^the user signs in as an Organisation Admin with VAT enrolment (.*) and strong credentials$") {
    (vrn: String) =>
      AuthActions.loginUsingScpStub("Organisation", vrn)
      AuthActions.selectMfaSuccess()
  }

  When("""^the user enters (.*) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.enterData(data)
  }

  When("""^the user adds (.*) on the (first|second) (.*) page$""") { (data: String, index: String, url: String) =>
    index match {
      case "first"  => CommonPage.checkUrl(url + "/1")
      case "second" => CommonPage.checkUrl(url + "/2")
      case _        => throw new Exception("Index doesn't exist")
    }
    CommonPage.enterData(data)
  }

  When("""^the user selects (.*) on the (first|second) (.*) page$""") { (data: String, index: String, url: String) =>
    index match {
      case "first"  => CommonPage.checkUrl(url + "/1")
      case "second" => CommonPage.checkUrl(url + "/2")
      case _        => throw new Exception("Index doesn't exist")
    }
    CommonPage.selectValueAutocomplete(data)
  }

  When("""^the user chooses (yes|no) on the (first|second) (.*) page$""") {
    (data: String, index: String, url: String) =>
      index match {
        case "first"  => CommonPage.checkUrl(url + "/1")
        case "second" => CommonPage.checkUrl(url + "/2")
        case _        => throw new Exception("Index doesn't exist")
      }
      CommonPage.selectAnswer(data)
  }

  When("""^the user clicks continue on the (first|second) (.*) page$""") { (index: String, url: String) =>
    index match {
      case "first"  => CommonPage.checkUrl(url + "/1")
      case "second" => CommonPage.checkUrl(url + "/2")
      case _        => throw new Exception("Index doesn't exist")
    }
    CommonPage.clickContinue()
  }

  When("^the user clicks through the (.*) page$") { (url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.clickContinue()
  }

  And("the business is responsible for reporting and paying VAT for all sales to consumers in EU countries") { () =>
    CommonPage.businessResponsibleReportingPayingVATEUCountries()
  }

  When("""^the user answers (yes|no) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.selectAnswer(data)
  }

  And("the user removes website address {int}") { (index: Int) =>
    CommonPage.checkUrl("check-add-website-address")
    CheckYourAnswersPage.selectLink(s"check-remove-website-address\\/$index")

    CommonPage.checkUrl(s"check-remove-website-address/$index")
    CommonPage.selectAnswer("yes")

    CommonPage.checkUrl("check-add-website-address")
    CommonPage.selectAnswer("no")

    CommonPage.checkUrl("check-answers")
  }

  And("the user adds {int} website addresses") { (numberOfWebsites: Int) =>
    CommonPage.checkUrl("check-answers")
    CheckYourAnswersPage.giveWebsiteAddress()

    CommonPage.checkUrl("check-give-website-address")
    WebsiteAddressesPage.addWebsiteAddress("www.example1.com")

    CommonPage.selectAnswer("yes")

    WebsiteAddressesPage.addWebsiteAddress("www.example2.com")
    CommonPage.checkUrl("check-add-website-address")
  }

  And("the user adds de-registration details from check your answers page") { () =>
    CommonPage.checkUrl("check-answers")
    CheckYourAnswersPage.selectLink("check-deregistered")

    CommonPage.checkUrl("check-deregistered")
    CommonPage.selectAnswer("yes")

    CommonPage.checkUrl("check-deregistered-country/1")
    CommonPage.selectValueAutocomplete("Austria")

    CommonPage.checkUrl("check-deregistered-eu-vat-number/1")
    CommonPage.enterData("AT123")

    CommonPage.checkUrl("check-add-deregistration")
    CommonPage.selectAnswer("no")

    CommonPage.checkUrl("check-answers")
  }

  And("the user changes the second business to VAT not registered") { () =>
    CheckYourAnswersPage.selectLink("check-eu-vat\\/2")

    CommonPage.checkUrl("check-eu-vat/2")
    CommonPage.selectAnswer("no")

    CommonPage.checkUrl("check-eu-tax-number/2")
    CommonPage.enterData("ABC123")

    CommonPage.checkUrl("change-check-tax-details/2")
    CommonPage.clickContinue()

    CommonPage.checkUrl("check-add-tax-details")
    CommonPage.selectAnswer("no")

    CommonPage.checkUrl("check-answers")
  }

  And("the user adds {int} trading names") { (numberOfTradingNames: Int) =>
    CommonPage.checkUrl("check-have-uk-trading-name")
    CommonPage.selectAnswer("yes")

    for (i <- 1 to numberOfTradingNames) {
      CommonPage.checkUrl(s"check-uk-trading-name/$i")
      CommonPage.enterData(s"Foo $i")

      if (i != numberOfTradingNames) {
        CommonPage.selectAnswer("yes")
      } else {
        CommonPage.selectAnswer("no")
      }
    }
  }

  When("""^the user provides the business details$""") { (dataTable: DataTable) =>
    dataTable.asMaps[String, String](classOf[String], classOf[String]).asScala.foreach { row =>
      val url    = row.get("url")
      val choice = row.get("choice")

      CommonPage.checkUrl(url)
      choice match {
        case "continue" => CommonPage.clickContinue()
        case _          => CommonPage.selectAnswer(choice)
      }
    }
  }

  Then("""^the user should be on the (.*) page$""") { (url: String) =>
    CommonPage.checkUrl(url)
  }

  When("""^the user provides date (.*) on the (.*) page$""") { (date: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.provideDate(date)
  }

  When("""^the user completes details on the (.*) page$""") { (url: String, dataTable: DataTable) =>
    CommonPage.checkUrl(url)
    CommonPage.completeForm(dataTable)
  }

  Then("""^the user is at the (.*) page$""") { (url: String) =>
    CommonPage.checkUrl(url)
  }

  Then("the user adds a {string} business {string} in {string} registered for tax in the EU") {
    (index: String, withEstablishment: String, country: String) =>
      val i = index match {
        case "first"  => 1
        case "second" => 2
        case _        => throw new Exception("Index doesn't exist")
      }
      CommonPage.checkUrl(s"check-eu-tax/$i")

      CommonPage.selectValueAutocomplete(country)

      CommonPage.checkUrl(s"check-eu-vat/$i")
      CommonPage.selectAnswer("yes")

      CommonPage.checkUrl(s"check-eu-vat-number/$i")
      CommonPage.enterData("FR123456789")

      CommonPage.checkUrl(s"check-eu-fixed-establishment/$i")
      withEstablishment match {
        case "with an establishment" =>
          CommonPage.selectAnswer("yes")

          CommonPage.checkUrl(s"check-eu-trading-name/$i")
          CommonPage.enterData("EU trading name")

          CommonPage.checkUrl("check-eu-fixed-establishment-address/2")

          textField("line1").value = "1 Address"
          textField("townOrCity").value = "A town"
          CommonPage.clickContinue()
        case _                       => CommonPage.selectAnswer("no")
      }
  }

  Then("""^the user submits their registration$""") { () =>
    CommonPage.submitRegistration()
    CommonPage.checkUrl("successful")
  }

  When("^the user chooses No on the Already Made Sales page$") { () =>
    CommonPage.checkUrl("alreadyMadeSales")
    AlreadyMadeSalesPage.selectNo()
  }

  When("""^the user chooses (Yes|No, details incorrect|No, wrong account) on the (.*) page$""") {
    (data: String, url: String) =>
      CommonPage.checkUrl(url)
      CheckVatDetailsPage.selectChoice(data)
      CommonPage.clickContinue()
  }

  And("the user chooses to register for the one stop shop scheme") { () =>
    CommonPage.checkUrl("confirm-vat-details")
    CheckVatDetailsPage.selectChoice("Yes")
    CommonPage.clickContinue()
  }

  When("""^the user picks (Online Marketplace|Mixed|Not Online Marketplace) on the how-do-you-sell page$""") {
    answer: String =>
      CommonPage.checkUrl("how-do-you-sell")
      SalesChannelsPage.selectChoice(answer)
      CommonPage.clickContinue()
  }
}
