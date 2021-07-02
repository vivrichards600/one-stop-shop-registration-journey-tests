package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.pages.CommonPage.selectAnswer

object CheckAddTaxDetailsPage {

  def anotherBusinessRegisteredForTaxInEu(): CheckTaxInEUPage.type = {
    selectAnswer("yes")
    CheckTaxInEUPage
  }

  def continuesToCheckYourAnswersPage(): CheckYourAnswersPage.type = {
    selectAnswer("no")
    CheckYourAnswersPage
  }
}
