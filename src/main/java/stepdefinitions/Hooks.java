package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.TestContext;

public class Hooks {
    private TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setUpBeforeEachTest() {
        testContext.getWebDriverManager().getWebDriver();
    }

    @After
    public void tearDownActionsAfterEachTest() {
        testContext.getWebDriverManager().getWebDriver().close();
        testContext.getWebDriverManager().getWebDriver().quit();
    }
}
