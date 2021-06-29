package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import uk.gov.hmrc.test.ui.pages.CommonPage._

import scala.jdk.CollectionConverters.asScalaBufferConverter

object WebsiteAddressesPage extends BrowserDriver{

  def addressCount: Int = driver.findElements(By.className("hmrc-add-to-a-list__identifier")).asScala.toList.size

  def addAnotherWebsiteAddress(): WebsiteAddressesPage.type = {
    CommonPage.selectAnswer("yes")
    this
  }

  def chooseToNotAddAnotherWebsiteAddress(): CheckYourAnswersPage.type = {
    CommonPage.selectAnswer("no")
    CommonPage.checkUrl("check-answers")
    CheckYourAnswersPage
  }

  def addWebsiteAddress(url: String): WebsiteAddressesPage.type = {
    CommonPage.selectAnswer("yes")
    CommonPage.enterData(url)
    CommonPage.checkUrl("check-add-website-address")
    this
  }

  def removeWebsiteAddress(index: Int) : WebsiteAddressesPage.type  = {
    checkUrl("check-add-website-address")
    selectLink(s"check-remove-website-address\\/$index")
    checkUrl(s"check-remove-website-address/$index")
    selectAnswer("yes")
    checkUrl("check-add-website-address")
    this
  }

}
