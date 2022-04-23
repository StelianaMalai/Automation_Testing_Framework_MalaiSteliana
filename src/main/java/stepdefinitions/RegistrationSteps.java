package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageobjects.RegisterPage;
import utils.TestContext;

public class RegistrationSteps {
    private TestContext context;

    private RegisterPage registerPage;


    public RegistrationSteps(TestContext testContext) {
        context = testContext;
        registerPage = new RegisterPage(context.getWebDriverManager().getWebDriver());
    }

    /*@Then("^registration page is displayed$")
    public void registrationPageIsDisplayed() {
        boolean urlIsValid = context.getWebDriverManager().getWebDriver().getCurrentUrl().contains("index.php?route=account/register");
        Assertions.assertTrue(urlIsValid, "The url is not valid");

    }*/
}
