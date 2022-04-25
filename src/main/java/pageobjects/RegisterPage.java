package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameField;

    @FindBy(id = "input-lastname")
    private WebElement lastNameField;

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id = "input-telephone")
    private WebElement telephoneField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(id = "input-confirm")
    private WebElement passwordConfirmField;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
    private WebElement privacyPolicyCheckbox;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class=\"text-danger\"]")
    private WebElement errorMessage;



    public void fillInRegisterForm(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        telephoneField.sendKeys(telephone);
        passwordField.sendKeys(password);
        passwordConfirmField.sendKeys(confirmPassword);
        privacyPolicyCheckbox.click();
        continueButton.click();
    }

    public void tickCheckBox(){
        privacyPolicyCheckbox.click();
    }
    public void clickContinueButton(){
        continueButton.click();
    }

    public String getErrorMessageText(){
       return errorMessage.getText();
    }
}
