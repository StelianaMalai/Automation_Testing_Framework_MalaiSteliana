import managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.ContactPage;
import pageobjects.HomePage;
import pageobjects.RegisterPage;

public class TestRunner {
    public static void main(String[] args) {
        WebDriverManager webDriverManagerChrome = new WebDriverManager("CHROME");
        webDriverManagerChrome.getWebDriver().get("https://demo.opencart.com/");

        /*Test registration flow*/

        HomePage homePage = new HomePage(webDriverManagerChrome.getWebDriver());
        homePage.navigateToRegisterPage();


        RegisterPage registerPage = new RegisterPage(webDriverManagerChrome.getWebDriver());
        registerPage.fillInRegisterForm("Tested", "Customer", "til@gmail.com", "06845799", "testedpass", "testedpass");

        /*Test log out flow*/

        WebElement logOutButton = webDriverManagerChrome.getWebDriver().findElement(By.xpath("//*[@id=\"column-right\"]/div/a[13]"));
        logOutButton.click();

        /*Test Contact us flow*/

        ContactPage contactPage = new ContactPage(webDriverManagerChrome.getWebDriver());



        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webDriverManagerChrome.getWebDriver().close();
        webDriverManagerChrome.getWebDriver().quit();
    }
}
