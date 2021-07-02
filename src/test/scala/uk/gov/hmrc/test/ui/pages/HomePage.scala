package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import uk.gov.hmrc.test.ui.pages.CommonPage.{checkUrl, clickContinue, selectAnswer}

object HomePage extends BrowserDriver {

  val oneStopShopUrl: String = TestConfiguration.url("one-stop-shop-registration-frontend")

  def sellsFromNorthernIrelandToEu(): HomePage.type = {
    selectAnswer("yes")
    HomePage
  }

  def goToOneStopShopRegistrationPage(): HomePage.type = {
    driver.navigate().to(oneStopShopUrl)
    checkUrl("already-eu-registered")
    HomePage
  }

  def businessNotRegisteredInEuForOneStopShop(): HomePage.type = {
    selectAnswer("no")
    HomePage
  }

  def businessInNorthernIreland(): HomePage.type = {
    selectAnswer("yes")
    HomePage
  }

  def continueToReportAndPayVatOnSales(): HomePage.type = {
    clickContinue()
    HomePage
  }

  def alreadyMadeSales(): HomePage.type =  {
    selectAnswer("yes")
    HomePage
  }

}
