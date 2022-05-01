package base

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

abstract class AbstractPage(webDriver: WebDriver) {

    protected val webDriver: WebDriver
    protected abstract val pageUrl: String

    init {
        this.webDriver = webDriver
        PageFactory.initElements(webDriver, this)
    }

    fun openPage() {
        webDriver.get(pageUrl)
    }
}