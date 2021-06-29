package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.pages.WebsiteAddressesPage.driver

import scala.jdk.CollectionConverters.asScalaBufferConverter

object TradingNamesPage {

  def tradingNameCount: Int = driver.findElements(By.className("hmrc-add-to-a-list__identifier")).asScala.toList.size

  def addAnotherTradingName(): TradingNamesPage.type = {
    CommonPage.selectAnswer("yes")
    this
  }

  def chooseToNotAddAnotherTradingName(): CheckYourAnswersPage.type = {
    CommonPage.selectAnswer("no")
    CommonPage.checkUrl("check-answers")
    CheckYourAnswersPage
  }

  def addTradingName(tradingName: String): TradingNamesPage.type = {
    CommonPage.enterData(tradingName)
    this
  }

  def hasDifferentTradingName: TradingNamesPage.type = {
    CommonPage.checkUrl("check-have-uk-trading-name")
    CommonPage.selectAnswer("yes")
    this
  }

}
