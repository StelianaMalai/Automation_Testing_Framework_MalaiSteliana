package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pageobjects.Page;
import utils.TestContext;

public class GeneralSteps {
    private TestContext context;


    public GeneralSteps(TestContext testContext) {
        this.context = testContext;
    }

    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String adresaUrl) throws Throwable {
        context.getWebDriverManager().getWebDriver().get(adresaUrl);
    }

    @Then("^\"([^\"]*)\" is present within the current url$")
    public void isPresentWithinTheCurrentUrl(String keyWord) throws Throwable {
        boolean urlIsValid = context.getWebDriverManager().getWebDriver().getCurrentUrl().contains(keyWord);
        Assertions.assertTrue(urlIsValid, "The url is not valid");
          }

    @Given("^\"([^\"]*)\" is opened$")
    public void isOpened(String pageName){
        Page.navigateToPage(pageName,context.getWebDriverManager().getWebDriver());

    }
}
