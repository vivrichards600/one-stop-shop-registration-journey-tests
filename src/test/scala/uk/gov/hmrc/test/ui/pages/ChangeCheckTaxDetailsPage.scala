package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import uk.gov.hmrc.test.ui.pages.CommonPage.clickContinue

import scala.jdk.CollectionConverters.asScalaBufferConverter

object ChangeCheckTaxDetailsPage extends BrowserDriver {

  def continueToCheckAddTaxDetailsPage(): CheckAddTaxDetailsPage.type = {
    clickContinue()
    CheckAddTaxDetailsPage
  }

  def headingText: String = driver.findElement(By.tagName("h1")).getText

  def changeVatRegistered(): CheckTaxInEUPage.type = {
    val summaryRows = driver.findElements(By.className("govuk-summary-list__row")).asScala.toList
    summaryRows.find(row =>
      row.findElement(By.className("govuk-summary-list__key")).getText == "VAT registered"
    ) match {
      case Some(element) => element.findElement(By.className("govuk-link")).click()
      case None          => throw new NoSuchElementException("No row with value 'VAT registered' in Summary List")
    }
    CheckTaxInEUPage
  }
}
