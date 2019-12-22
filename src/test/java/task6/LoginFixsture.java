package task6;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class LoginFixsture extends SeleniumFixture {

    @Before
    public void login() throws InterruptedException {
        System.out.println("Вход");
        driver.get("https://en.wikipedia.org/");
        WebElement source = driver.findElement(By.xpath("//li[@id='pt-anontalk']/a[@href='/wiki/Special:MyTalk']"));
        WebElement target = driver.findElement(By.xpath("//li[@id='pt-anoncontribs']/a[@href='/wiki/Special:MyContributions']"));

        Actions builder = new Actions(driver);
        builder.dragAndDrop(source, target).perform();
        assertEquals("Contributions", target.getText());
    }

    @After
    public void logout() {
        System.out.println("Возвращение");
    }
}

