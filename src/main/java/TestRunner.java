import managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    public static void main(String[] args) {
        WebDriverManager webDriverManagerChrome = new WebDriverManager("CHROME");
        webDriverManagerChrome.getWebDriver().get("https://demo.opencart.com/");

        /*Test registration flow*/

        WebElement myAccountIcon = webDriverManagerChrome.getWebDriver().findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i"));
        myAccountIcon.click();

        WebElement registerButton = webDriverManagerChrome.getWebDriver().findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
        registerButton.click();

        WebElement firstNameField = webDriverManagerChrome.getWebDriver().findElement(By.id("input-firstname"));
        WebElement lastNameField = webDriverManagerChrome.getWebDriver().findElement(By.id("input-lastname"));
        WebElement emailField = webDriverManagerChrome.getWebDriver().findElement(By.id("input-email"));
        WebElement telephoneField = webDriverManagerChrome.getWebDriver().findElement(By.id("input-telephone"));
        WebElement passwordField = webDriverManagerChrome.getWebDriver().findElement(By.id("input-password"));
        WebElement passwordConfirmField = webDriverManagerChrome.getWebDriver().findElement(By.id("input-confirm"));
        WebElement privacyPolicyField = webDriverManagerChrome.getWebDriver().findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
        WebElement continueButton = webDriverManagerChrome.getWebDriver().findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));

        firstNameField.sendKeys("Tested");
        lastNameField.sendKeys("Customer");
        emailField.sendKeys("testemail@gmail.com");
        telephoneField.sendKeys("123456789");
        passwordField.sendKeys("passtest1289");
        passwordConfirmField.sendKeys("passtest1289");
        privacyPolicyField.click();
        continueButton.click();

        /*Test log out flow*/

        WebElement logOutButton = webDriverManagerChrome.getWebDriver().findElement(By.xpath("//*[@id=\"column-right\"]/div/a[13]"));
        logOutButton.click();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webDriverManagerChrome.getWebDriver().close();
        webDriverManagerChrome.getWebDriver().quit();

    }
}
