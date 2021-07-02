package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import uk.gov.hmrc.test.ui.pages.CommonPage.clickContinue

object ChangeCheckTaxDetailsPage extends BrowserDriver {

  def continueToCheckAddTaxDetailsPage(): CheckAddTaxDetailsPage.type = {
    clickContinue()
    CheckAddTaxDetailsPage
  }

  def headingText: String = driver.findElement(By.tagName("h1")).getText

  def changeVatRegistered(): CheckTaxInEUPage.type = {
    CommonPage.selectLink("check-eu-vat\\/2")
    CheckTaxInEUPage
  }
}
