package stepdefinitions;

import cucumber.api.java.en.When;
import pageobjects.HomePage;
import utils.TestContext;

public class HomeSteps {
    private TestContext context;
    private HomePage homePage;

    public HomeSteps(TestContext testContext){
        context = testContext;
        homePage = new HomePage(context.getWebDriverManager().getWebDriver());

    }
    @When("^User clicks on register button from navigation bar$")
    public void userClicksOnRegisterButtonFromNavigationBar() {
        homePage.navigateToRegisterPage();

    }
}
