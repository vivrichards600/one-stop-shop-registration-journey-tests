package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.driver.BrowserDriver

import scala.jdk.CollectionConverters.asScalaBufferConverter

object WebsiteAddressesPage extends BrowserDriver{

  def addressCount: Int = driver.findElements(By.className("hmrc-add-to-a-list__identifier")).asScala.toList.size

  def addAnotherAddress(): WebsiteAddressesPage.type = {
    CommonPage.selectAnswer("yes")
    this
  }

  def addWebsiteAddress(url: String): WebsiteAddressesPage.type = {
    CommonPage.selectAnswer("yes")
    CommonPage.enterData(url)
    CommonPage.checkUrl("check-add-website-address")
    this
  }

}
