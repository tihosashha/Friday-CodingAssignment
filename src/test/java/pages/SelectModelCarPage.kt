package pages

import base.AbstractPage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class SelectModelCarPage(webDriver: WebDriver) : AbstractPage(webDriver) {

    fun clickOnCarModel(carModel: String) {
        val element = webDriver.findElement(By.xpath("//*[text()='$carModel']"))
        element.click()
    }

    override val pageUrl = "https://hello.friday.de/quote/selectModel"
}