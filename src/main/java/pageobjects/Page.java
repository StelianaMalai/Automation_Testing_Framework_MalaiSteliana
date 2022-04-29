package pageobjects;

import managers.PropertiesManager;
import managers.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/i")
    protected WebElement myAccountIcon;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    protected WebElement registerButton;

    @FindBy(xpath = "/html/body/footer/div/div/div[2]/ul/li[1]/a")
    protected WebElement contactUs;

    protected final String BASE_URL = PropertiesManager.getBaseUrl();

    public void navigateToRegisterPage() {
        myAccountIcon.click();
        registerButton.click();
    }

    public void navigateToContactPage() {
        contactUs.click();
    }

    public static void navigateToPage(String pageName, WebDriver driver) {
        Method definedMethod;

        try {
            definedMethod = Class.forName("pageobjects." + pageName).getMethod("goToPage");
            definedMethod.invoke(Class.forName("pageobjects." + pageName).getConstructor(WebDriver.class).newInstance(driver));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        }
