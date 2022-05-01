package pages

import base.AbstractPage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class SelectBodyCarTypePage(webDriver: WebDriver) : AbstractPage(webDriver) {

    fun clickOnBodyType(bodyType: String) {
        val element = webDriver.findElement(By.xpath("//*[text()='$bodyType']"))
        element.click()
    }

    override val pageUrl = "https://hello.friday.de/quote/selectBodyType"
}