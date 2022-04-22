import managers.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import pageobjects.ContactPage;
import pageobjects.HomePage;
import pageobjects.RegisterPage;

import java.util.List;
import java.util.function.BooleanSupplier;

public class TestJunitRunner {
    WebDriverManager webDriverManagerChrome = new WebDriverManager("CHROME");

    @BeforeEach
    public void configureTestPreconditions() {
        webDriverManagerChrome.getWebDriver().get("https://demo-opencart.com/");
    }

    @AfterEach
    public void tearDownActivities() {
        webDriverManagerChrome.getWebDriver().close();
        webDriverManagerChrome.getWebDriver().quit();
    }

    @Test
    @DisplayName("The url address for Register page is accessible from the Home page ")

    public void registerPageIsAccessible() {
        HomePage homePage = new HomePage(webDriverManagerChrome.getWebDriver());
        homePage.navigateToRegisterPage();

        boolean urlIsValid = webDriverManagerChrome.getWebDriver().getCurrentUrl().contains("index.php?route=account/register");
        Assertions.assertTrue(urlIsValid, "The url is not valid");
    }

    @Test
    @DisplayName("A warning message is displayed when not filling in the enquiry field properly")
    public void warningMessageIsDisplayed() {
        HomePage homePage = new HomePage(webDriverManagerChrome.getWebDriver());
        homePage.navigateToContactPage();
        ContactPage contactPage = new ContactPage(webDriverManagerChrome.getWebDriver());
        contactPage.fillInTheContactForm("Customer", "email@g.com", "     ");

        WebElement errorMessage = webDriverManagerChrome.getWebDriver().findElement(By.xpath("//*[@id=\"content\"]/form/fieldset/div[3]/div/div"));

        String expectedErrorMessage = "Enquiry must be between 10 and 3000 characters!";
        String actualErrorMessage = errorMessage.getText();
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage, "The warning message is not displayed");
    }

    @Test
    @DisplayName("The enquiry on contact us page was sent successfully")
    public void successfullySentEnquiryMessage() {
        HomePage homePage = new HomePage(webDriverManagerChrome.getWebDriver());
        homePage.navigateToContactPage();
        ContactPage contactPage = new ContactPage(webDriverManagerChrome.getWebDriver());
        contactPage.fillInTheContactForm("Customer", "email@g.com", "Please let me know some details about the following product");

        Boolean pageOfConfirmationSuccessfullySentMessageIsDisplayed = webDriverManagerChrome.getWebDriver().getCurrentUrl().contains("/index.php?route=information/contact/success");
        Assertions.assertTrue(pageOfConfirmationSuccessfullySentMessageIsDisplayed, "The message was not sent");
    }
}
