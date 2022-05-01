package pages

import base.AbstractPage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class CarSelectionPage(webDriver: WebDriver) : AbstractPage(webDriver) {

    fun clickOnCorrectCar(car: String) {
        val element = webDriver.findElement(By.xpath("//*[text()='$car']"))
        element.click()
    }

    override val pageUrl = "https://hello.friday.de/quote/selectEngine"
}