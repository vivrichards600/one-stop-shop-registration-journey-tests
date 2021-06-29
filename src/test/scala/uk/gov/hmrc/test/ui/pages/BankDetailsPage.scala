package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.driver.BrowserDriver

object BankDetailsPage extends BrowserDriver {

  def addBankDetails(): CheckYourAnswersPage.type = {
    CommonPage.checkUrl("bank-details")
    driver.findElement(By.id("accountName")).sendKeys("Account Name")
    driver.findElement(By.id("bic")).sendKeys("ABCDEF2A")
    driver.findElement(By.id("iban")).sendKeys("GB33BUKB20201555555555")
    driver.findElement(By.cssSelector(".govuk-button")).click()
    CommonPage.checkUrl("check-answers")
    CheckYourAnswersPage
  }
}
