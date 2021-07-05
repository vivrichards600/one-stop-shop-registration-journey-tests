package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.pages.CommonPage.selectAnswer

object DeregistrationPage {

  def addDeregisteredCountryDetails(): DeregistrationPage.type = {
    CommonPage.checkUrl("check-deregistered")
    CommonPage.selectAnswer("yes")
    CommonPage.selectValueAutocomplete("Austria")
    CommonPage.enterData("AT123")
    DeregistrationPage
  }

  def continuesToCheckYourAnswersPage(): CheckYourAnswersPage.type = {
    selectAnswer("no")
    CheckYourAnswersPage
  }

  def businessNotDeregistered() : DeregistrationPage.type = {
    selectAnswer("no")
    DeregistrationPage
  }

  def doesNotHaveAnOnlineMarketPlace() : WebsiteAddressesPage.type = {
    selectAnswer("no")
    WebsiteAddressesPage
  }
}
