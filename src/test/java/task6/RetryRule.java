package task6;

import org.junit.Assert;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

    public class RetryRule implements TestRule {

        @Override
        public Statement apply(Statement base, Description desc) {

            return new RunTwiceStatement(base, desc);
        }

        public class RunTwiceStatement extends Statement {

            private Statement base;
            private Description desc;

            public RunTwiceStatement(Statement base, Description desc) {
                this.base = base;
                this.desc = desc;
            }

            @Override
            public void evaluate() throws Throwable {
                UnstableTest unstable = desc.getAnnotation(UnstableTest.class);
                System.out.println("unstable");
                if (unstable != null) {
                    for (int attempt = 1; attempt <= unstable.value(); attempt++) {
                        try {
                            base.evaluate();
                            System.out.println("Testing Good");
                            break;
                        } catch (Exception error) {
                            if (attempt == unstable.value()) {
                                Assert.fail("test fail");
                            }
                            System.out.println("attempt: " + attempt);
                        }
                    }
                }
            }
        }
    }

