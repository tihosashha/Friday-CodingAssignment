package pages

import base.AbstractPage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class SelectCarPage(webDriver: WebDriver) : AbstractPage(webDriver) {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div/form/div[2]/div[1]/button[2]")
    lateinit var findByBrandButton: WebElement

    fun clickOnTheFindByBrandButton() {
        findByBrandButton.click()
    }

    fun clickOnCarBrand(carBrand: String) {
        val element = webDriver.findElement(By.xpath("//*[text()='$carBrand']"))
        element.click()
    }

    override val pageUrl = "https://hello.friday.de/quote/selectVehicle"
}