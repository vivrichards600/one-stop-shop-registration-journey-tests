package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.driver.BrowserDriver

object BusinessContactDetailsPage extends BrowserDriver {

  def addBusinessContactDetails(): BankDetailsPage.type = {
    CommonPage.checkUrl("business-contact-details")
    driver.findElement(By.id("fullName")).sendKeys("Joe Bloggs")
    driver.findElement(By.id("telephoneNumber")).sendKeys("01234567890")
    driver.findElement(By.id("emailAddress")).sendKeys("email@test.com")
    driver.findElement(By.cssSelector(".govuk-button")).click()
    CommonPage.checkUrl("bank-details")
    BankDetailsPage
  }

}
