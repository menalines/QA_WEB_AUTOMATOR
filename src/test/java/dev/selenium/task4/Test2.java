package dev.selenium.task4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class Test2 {

    private final String URL = "https://en.wikipedia.org/";
    private ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty(URL, "D:\\projects\\automated\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("test start");
        driver.get(URL);
    }

    @Test
    public void test1() {
        driver.get(URL);
        WebElement source = driver.findElement(By.xpath("//li[@id='pt-anontalk']/a[@href='/wiki/Special:MyTalk']"));
        WebElement target = driver.findElement(By.xpath("//li[@id='pt-anoncontribs']/a[@href='/wiki/Special:MyContributions']"));

        Actions builder = new Actions(driver);
        builder.dragAndDrop(source, target).perform();
        assertEquals("Contributions", target.getText());
    }

    @Test
    public void test2() {
        driver.get(URL);
        WebElement source = driver.findElement(By.xpath("//li[@id='pt-anontalk']/a[@href='/wiki/Special:MyTalk']"));

        Actions builder = new Actions(driver);
        builder.contextClick(source).build().perform();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void close() {
        System.out.println("test close");
        driver.quit();
    }
}
