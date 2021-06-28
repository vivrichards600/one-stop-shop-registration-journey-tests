package uk.gov.hmrc.test.ui.pages

object WebsiteAddressesPage {
  def addWebsiteAddress(url: String): Unit = {
    CommonPage.selectAnswer("yes")
    CommonPage.enterData(url)
    CommonPage.checkUrl("check-add-website-address")
  }

}