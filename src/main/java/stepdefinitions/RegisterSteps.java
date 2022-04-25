package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.jodah.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import pageobjects.RegisterPage;
import utils.TestContext;

import java.util.List;
import java.util.Map;

public class RegisterSteps {
private RegisterPage registerPage;
private TestContext context;

public RegisterSteps(TestContext testContext){
    context = testContext;
    registerPage = new RegisterPage(context.getWebDriverManager().getWebDriver());
}
    @When("^the register field are populated with the following data:$")
    public void theRegisterFieldArePopulatedWithTheFollowingData(Map<String, String> collectedRegisterDataMap) {
        String collectedFirstName = collectedRegisterDataMap.get("firstName");
        String collectedLastName = collectedRegisterDataMap.get("lastName");
        String collectedEmail = collectedRegisterDataMap.get("email");
        String collectedPhone = collectedRegisterDataMap.get("phone");
        String collectedPassword = collectedRegisterDataMap.get("password");
        String collectedConfirmPassword = collectedRegisterDataMap.get("confirmPassword");

        registerPage.fillInRegisterForm(collectedFirstName, collectedLastName, collectedEmail, collectedPhone, collectedPassword, collectedConfirmPassword);
    }

    @And("^privacy checkbox is clicked$")
    public void privacyCheckboxIsClicked() {
    registerPage.tickCheckBox();
    }

    @And("^continue button is clicked$")
    public void continueButtonIsClicked() {
    registerPage.clickContinueButton();

    }

    @Then("^the following key words are present within the error message$")
    public void theFollowingKeyWordsArePresentWithinTheErrorMessage(List<String> keyWordList) {
    String displayedErrorMessage = registerPage.getErrorMessageText();

    for (int i = 0; i<keyWordList.size(); i++){
boolean keywordIsPresentWithinTheDisplayedMessage = displayedErrorMessage.contains(keyWordList.get(i));

Assertions.assertTrue(keywordIsPresentWithinTheDisplayedMessage, "The keyword is not present within the error message");
    }

}
}