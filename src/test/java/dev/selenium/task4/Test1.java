package dev.selenium.task4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Test1 {

    private ChromeDriver driver;

    @Before
    public void setUp() {
        String URL = "http://www.w3schools.com/html/html_tables.asp";
        System.setProperty(URL, "D:\\projects\\automated\\chromedriver.exe");
        driver =  new ChromeDriver();
        System.out.println("test start");
        driver.get(URL);
    }

    @Test
    public void test1()  {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));

        for (int i = 0; i < headers.size(); i++) {
            System.out.println((i + 1) + " header: " + headers.get(i).getText());
        }

        System.out.println("count rows: " + (rows.size() - 1));
        for (WebElement header : headers) {
            if (header.getText().equals("Company")) {
                System.out.println("(4, \"Company\"): " + rows.get(4).getText());
            }

            if (header.getText().equals("Country")) {
                System.out.println("(1, \"Country\"): " + rows.get(1).getText());
            }

            if (header.getText().equals("Contact")) {
                System.out.println("(2, \"Contact\"): " + rows.get(2).getText());
            }
        }
    }

    @After
    public void close() {
        System.out.println("test close");
        driver.quit();
    }
}


