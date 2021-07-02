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
import uk.gov.hmrc.test.ui.pages.BusinessContactDetailsPage.addBusinessContactDetails
import uk.gov.hmrc.test.ui.pages.CheckAddTaxDetailsPage.anotherBusinessRegisteredForTaxInEu
import uk.gov.hmrc.test.ui.pages.CheckTaxInEUPage.businessRegisteredForTaxInEu
import uk.gov.hmrc.test.ui.pages.{AlreadyMadeSalesPage, AuthPage, CheckVatDetailsPage, CommonPage, SalesChannelsPage, _}

import scala.jdk.CollectionConverters.asScalaBufferConverter

class RegistrationStepDef extends BaseStepDef {

  Given("^the user accesses the service$") { () =>
    HomePage.goToOneStopShopRegistrationPage()
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
    ChangeCheckTaxDetailsPage.continueToCheckAddTaxDetailsPage()
  }

  When("^the user clicks through the (.*) page$") { (url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.clickContinue()
  }

  And("the business is responsible for reporting and paying VAT for all sales in EU") { () =>
    HomePage
      .goToOneStopShopRegistrationPage()
      .businessNotRegisteredInEuForOneStopShop()
      .sellsFromNorthernIrelandToEu()
      .businessInNorthernIreland()
      .continueToReportAndPayVatOnSales()
      .alreadyMadeSales()
  }

  When("^the user adds the day (.*) the month (.*) and the year (.*) on the (.*) date page$") {
    (day: String, month: String, year: String, url: String) =>
      CommonPage.checkUrl(url)
      CommonPage.enterDate(day, month, year)
      CommonPage.clickContinue()
  }

  When("""^the user answers (yes|no) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.selectAnswer(data)
  }

  And("the user removes website address {int} and continues to check your answers page") { (index: Int) =>
    WebsiteAddressesPage
      .removeWebsiteAddress(index)
      .chooseToNotAddAnotherWebsiteAddress()
  }

  And("the user adds 2 website addresses") { () =>
    CheckYourAnswersPage
      .giveWebsiteAddress()
      .addWebsiteAddress("www.example1.com")
      .addAnotherWebsiteAddress()
      .addWebsiteAddress("www.example2.com")
      .websiteAddressCount shouldBe 2
  }

  And("the user adds de-registration details from check your answers page") { () =>
    CheckYourAnswersPage
      .changeDeregistrationDetails()
      .addDeregisteredCountryDetails()

  }

  And("continues to check your answers page from change check add deregistration page") { () =>
    DeregistrationPage
      .continuesToCheckYourAnswersPage()
  }

  And("the user changes the second business to VAT not registered") { () =>
    ChangeCheckTaxDetailsPage.changeVatRegistered()
      .notRegisteredForVat()
      .addTaxIdentificationNumber()
  }

  And("continues to check your answers page from change check tax details page") { () =>
    ChangeCheckTaxDetailsPage
      .continueToCheckAddTaxDetailsPage()
      .continuesToCheckYourAnswersPage()
  }

  And("the user adds 2 trading names and continues to check-answers page") { () =>
    TradingNamesPage.hasDifferentTradingName
      .addTradingName("Foo One")
      .addAnotherTradingName()
      .addTradingName("Foo Two")
      .tradingNameCount shouldBe 2
    TradingNamesPage.chooseToNotAddAnotherTradingName()
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

  When("""^the user provides business-contact-details$""") { () =>
    addBusinessContactDetails()
  }

  When("""^the user provides bank-details and continues to check-answers page$""") { () =>
    BankDetailsPage.addBankDetails()
  }

  Then("""^the user is at the (.*) page$""") { (url: String) =>
    CommonPage.checkUrl(url)
  }

  Then("the user adds France as country for business registered for tax in the EU") { () =>
    businessRegisteredForTaxInEu()
      .addCountryRegisteredForTaxInEu("France")
      .registeredForVat("FR123456789")
      .withoutFixedEstablishment()
      .headingText should include regex "France"
  }

  Then("adds Germany as another business registered with an establishment for tax in the EU from check-add-tax-details page") { () =>
    anotherBusinessRegisteredForTaxInEu()
      .addCountryRegisteredForTaxInEu("Germany")
      .registeredForVat("DE123456789")
      .withFixedEstablishment()
      .addTradingName("EU Trading Name")
      .addFixedEstablishmentAddress()
      .headingText should include regex "Germany"
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
      CommonPage.checkUrl("sales-on-marketplaces")
      SalesChannelsPage.selectChoice(answer)
      CommonPage.clickContinue()
  }
}
