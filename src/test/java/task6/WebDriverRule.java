package task6;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import ru.stqa.selenium.factory.WebDriverFactory;

public class WebDriverRule extends ExternalResource {

    private Capabilities capabilities;

    WebDriverRule(Capabilities capabilities) { this.capabilities = capabilities; }

    private WebDriver driver;

    public WebDriver getDriver() { return driver; }

    @Override
    protected void before() {
        System.out.println("Starting a browser");
        System.setProperty("webdriver.chrome.driver", "D:\\projects\\automated\\chromedriver.exe");
        driver = WebDriverFactory.getDriver(capabilities);
}
    @Override
    protected void after() {
        System.out.println("Stopping the browser");
        if (driver != null) {
            driver.quit();
        }
    }
}
