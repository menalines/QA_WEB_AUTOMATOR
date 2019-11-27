package dev.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Optional;

public class Test1 {

    private final String URL = "https://selenium.dev/";
    private final String DOWNLOAD = "downloads";
    private ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty(URL, "D:\\projects\\automated\\chromedriver.exe");
        driver =  new ChromeDriver();
        System.out.println("test start");
        driver.get(URL);
    }

    @Test
    public void test1() throws InterruptedException {
        List<WebElement> navItems = driver.findElements(By.className("nav-item"));
        Optional<WebElement> download = getDownloadElement(navItems);
        download.ifPresent(WebElement::click);

        Thread.sleep(10000);
    }

    @Test
    public void test2() throws InterruptedException {
        WebElement downloadByXpath = driver.findElement(
                By.xpath("//a[contains(@href,'/" + DOWNLOAD + "')]")
        );
        downloadByXpath.click();

        Thread.sleep(10000);
    }

    @Test
    public void test3() throws InterruptedException {
        WebElement downloadByCss = driver.findElement(
                By.cssSelector("a.nav-item[href*='/" + DOWNLOAD + "']")
        );
        downloadByCss.click();

        Thread.sleep(10000);
    }

    private Optional<WebElement> getDownloadElement(List<WebElement> webElements) {
        return webElements.stream().filter(elem -> {
            String value = elem.getAttribute("href");
            return value != null && value.equals(URL + DOWNLOAD);
        }).findFirst();
    }

    @After
    public void close() {
        System.out.println("test close");
        driver.quit();
    }
}
