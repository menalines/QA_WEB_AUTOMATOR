package task5;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

public class Tests {
    private static final String URL = "https://github.com/";
    private ChromeDriver driver;
    By userName = By.name("user[login]");
    By email = By.id("user[email]");
    By search = By.name("q");

    @Before
    public void setUp() {
        System.setProperty(URL, "D:\\projects\\automated\\chromedriver.exe");
        driver =  new ChromeDriver();
        System.out.println("test start");
        driver.get(URL);
        driver.manage().window().maximize();
    }
    @Test
    public void test1 () throws InterruptedException {
        WebElement searchElement = driver.findElement(search);
        searchElement.sendKeys("Example");
        searchElement.submit();
    }
    @Test
    public void test2 () throws InterruptedException {
        WebElement userNameElement = driver.findElement(userName);
        userNameElement.sendKeys("Example");
        Thread.sleep(10000);

        String classes = userNameElement.getAttribute("class");
        assertTrue(classes.contains("is-autocheck-errored"));
    }
    @Test
    public void test3 () throws InterruptedException {

        WebElement emailElement = driver.findElement(email);
        emailElement.sendKeys("EXAMPLE@mail.ru");
        Thread.sleep(10000);

        String classes = emailElement.getAttribute("class");
        assertTrue(classes.contains("is-autocheck-errored"));
    }
    @After
    public void close() {
        System.out.println("test close");
        driver.quit();
    }
}
