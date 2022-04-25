package pageobjects;

import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/i")
    protected WebElement myAccountIcon;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    protected WebElement registerButton;

    @FindBy(xpath = "/html/body/footer/div/div/div[2]/ul/li[1]/a")
    protected WebElement contactUs;


    public void navigateToRegisterPage() {
        myAccountIcon.click();
        registerButton.click();
    }

    public void navigateToContactPage() {
        contactUs.click();
    }
       }
