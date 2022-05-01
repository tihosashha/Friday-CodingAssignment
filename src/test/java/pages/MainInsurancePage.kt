package pages

import base.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class MainInsurancePage(webDriver: WebDriver) : AbstractPage(webDriver) {

    @FindBy(xpath = "//*[@data-testid=\"button\"]")
    lateinit var continueButton: WebElement

    fun clickOnTheContinueButton() {
        continueButton.click()
    }

    override val pageUrl = "https://hello.friday.de/quote/selectPrecondition"
}