package base

import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.time.Duration

@RunWith(Parameterized::class)
abstract class AbstractChromeWebDriverTest {

    protected lateinit var driver: WebDriver

    @Before
    fun beforeTest() {
        WebDriverManager.chromedriver().setup()
        driver = ChromeDriver()

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
    }


    @After
    fun afterTest() {
        driver.quit()
    }
}