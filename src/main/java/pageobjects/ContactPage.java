package pageobjects;

import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends Page {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-name")
    private WebElement yourNameField;

    @FindBy(id = "input-email")
    private WebElement emailAddressField;


    @FindBy(id = "input-enquiry")
    private WebElement enquiry;

    @FindBy(css = "#content > form > div > div > input")
    private WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/a")
    private WebElement continueBtn;


    public void fillInTheContactForm(String name, String email, String enquiery) {
        yourNameField.sendKeys(name);
        emailAddressField.sendKeys(email);
        enquiry.sendKeys(enquiery);
        submitBtn.click();
        continueBtn.click();
    }
}
