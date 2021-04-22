package uk.gov.hmrc.test.ui.cucumber.stepdefs

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.pages.{LoginPage, RegisteredCompanyNamePage}

class RegistrationStepDef extends BaseStepDef {

  Given("a user is signed in") { () =>
    driver.navigate().to(LoginPage.url)

    driver.findElement(By.name("redirectionUrl")).clear()
    driver.findElement(By.name("redirectionUrl")).sendKeys(RegisteredCompanyNamePage.url)
    driver.findElement(By.cssSelector("Input[value='Submit']")).click()

    eventually {
      driver.getCurrentUrl should be(RegisteredCompanyNamePage.url)
    }
  }

  When("the user enters (.+) on the (.+)) page") { (data: String, url: String) =>
    val inputId = "value"
    driver.findElement(By.id(inputId)).sendKeys(data)
    driver.findElement(By.cssSelector("Button[value='Continue']")).click()
  }
}
