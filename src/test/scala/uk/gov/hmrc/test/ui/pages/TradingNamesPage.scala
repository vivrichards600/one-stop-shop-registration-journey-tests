package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.By
import org.scalatestplus.selenium.Chrome.textField
import uk.gov.hmrc.test.ui.driver.BrowserDriver

import scala.jdk.CollectionConverters.asScalaBufferConverter

object TradingNamesPage extends BrowserDriver {

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

  def addFixedEstablishmentAddress(): ChangeCheckTaxDetailsPage.type = {
    textField("line1").value = "1 Address"
    textField("townOrCity").value = "A town"
    CommonPage.clickContinue()
    ChangeCheckTaxDetailsPage
  }

  def hasDifferentTradingName: TradingNamesPage.type = {
    CommonPage.checkUrl("check-have-uk-trading-name")
    CommonPage.selectAnswer("yes")
    this
  }

  def doesNotHaveDifferentTradingName:TradingNamesPage.type = {
    CommonPage.selectAnswer("no")
    this
  }

  def withFirstSaleDate(day:String, month: String, year: String): TradingNamesPage.type = {
    CommonPage.enterDate(day, month, year)
    CommonPage.clickContinue()
    this
  }

  def confirmsSaleStartDate(): CheckTaxInEUPage.type = {
    CommonPage.clickContinue()
    CheckTaxInEUPage
  }
}
