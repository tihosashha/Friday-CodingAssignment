package pages

import base.AbstractPage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class SelectFuelTypePage(webDriver: WebDriver) : AbstractPage(webDriver) {

    fun clickOnFuelType(fuelType: String) {
        val element = webDriver.findElement(By.xpath("//*[text() = '$fuelType']"))
        element.click()
    }

    override val pageUrl = "https://hello.friday.de/quote/selectFuelType"
}