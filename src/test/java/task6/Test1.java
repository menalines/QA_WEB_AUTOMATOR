package task6;

import org.junit.Test;

public class Test1 extends SeleniumFixture {

    @Test
    public void test1() {
        driver.get("https://selenium.dev/");
    }

    @Test
    public void test2() {
        driver.get("https://webdriver.ru/");
    }
}
