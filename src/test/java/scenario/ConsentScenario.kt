package scenario

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver

class ConsentScenario(private val webDriver: WebDriver) {

    private val privacyButton: WebElement by lazy {
        val acceptAllElement = (webDriver as RemoteWebDriver).executeScript(
            "return document" +
                    ".querySelector('#usercentrics-root')" +
                    ".shadowRoot" +
                    ".querySelector(\"[data-testid='uc-accept-all-button']\")"
        )
        return@lazy acceptAllElement as WebElement
    }

    fun acceptAllCookies() {
        Thread.sleep(3000)
        privacyButton.click()
    }
}