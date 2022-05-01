package pages

import base.AbstractPage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class SelectEnginePowerPage(webDriver: WebDriver) : AbstractPage(webDriver) {

    fun clickOnEnginePower(enginePower: String) {
        val element = webDriver.findElement(By.xpath("//*[text()='$enginePower']"))
        element.click()
    }

    override val pageUrl = "https://hello.friday.de/quote/selectEnginePower"

}