package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.pages.CommonPage._

object CheckTaxInEUPage {

  def registeredForVat(vatNumber: String): CheckTaxInEUPage.type = {
    selectAnswer("yes")
    enterData(vatNumber)
    CheckTaxInEUPage
  }

  def notRegisteredForVat(): CheckTaxInEUPage.type = {
    selectAnswer("no")
    CheckTaxInEUPage
  }

  def addTaxIdentificationNumber(): ChangeCheckTaxDetailsPage.type = {
    enterData("ABC123")
    ChangeCheckTaxDetailsPage
  }

  def withoutFixedEstablishment(): ChangeCheckTaxDetailsPage.type = {
    selectAnswer("no")
    ChangeCheckTaxDetailsPage
  }

  def withFixedEstablishment(): TradingNamesPage.type = {
    selectAnswer("yes")
    TradingNamesPage
  }

  def addCountryRegisteredForTaxInEu(country: String): CheckTaxInEUPage.type = {
    selectValueAutocomplete(country)
    CheckTaxInEUPage
  }

  def businessRegisteredForTaxInEu(): CheckTaxInEUPage.type = {
    selectAnswer("yes")
    CheckTaxInEUPage
  }

  def businessNotRegisteredForTaxInEu(): DeregistrationPage.type = {
    selectAnswer("no")
    DeregistrationPage
  }
}
