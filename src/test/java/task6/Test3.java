package task6;

import org.junit.Assume;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class Test3 extends SeleniumFixture {

    @Rule
    public TestRule retryRule = new RetryRule();

    private static int attempt = 1;

    @Test
    @UnstableTest(value=10)
    public void Test3() {
        attempt++;
        Assume.assumeFalse(Boolean.parseBoolean("Failed on " + (attempt++) + " attempt"));
    }
}
