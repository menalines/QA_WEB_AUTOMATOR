package Test_demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_suite {

        private ChromeDriver driver;
        @Before
        public void setUp() {
            System.setProperty("http://open-eshop.stqa.ru/oc-panel/auth/login/", "D:\\projects\\automated\\chromedriver.exe");
            driver =  new ChromeDriver();
            System.out.println("test start");
        }

        @Test
        public void test1 () {
            driver.get("http://open-eshop.stqa.ru/oc-panel/auth/login/");
            WebDriverWait wait = new WebDriverWait(driver, 15, 100);
            WebElement logElement = driver.findElement(By.xpath("//input[@name='email']"));
            logElement.sendKeys("demo@open-eshop.com");
            WebElement passwordElement = driver.findElement(By.xpath("//input[@name='password']"));
            passwordElement.sendKeys("demo");
            passwordElement.submit();
        }
        @Test
        public void  test2() throws InterruptedException {
            driver.get("http://open-eshop.stqa.ru/search.html?search");
            WebDriverWait wait = new WebDriverWait(driver, 15, 100);
            WebElement nameElement = driver.findElement(By.id("search"));
            nameElement.clear();
            nameElement.sendKeys("Cupon1");
            WebElement priceMinElement = driver.findElement(By.xpath("//input[@name='price-min']"));
            priceMinElement.sendKeys("1");
            WebElement priceMaxElement = driver.findElement(By.xpath("//input[@name='price-max']"));
            priceMaxElement.sendKeys("2");
            WebElement submitElement = driver.findElement(By.xpath("//button[@name='submit']"));
            priceMinElement.click();
            Thread.sleep(1000);
        }
        @After
        public void close() {
            System.out.println("test close");
            driver.quit();
        }
    }


