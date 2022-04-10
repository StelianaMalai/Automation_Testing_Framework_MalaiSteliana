import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    public static void main(String[] args) {
        WebDriverManager webDriverManagerChrome = new WebDriverManager("CHROME");
        webDriverManagerChrome.getWebDriver().get("https://www.google.com/");
        webDriverManagerChrome.getWebDriver().close();

        WebDriverManager webDriverManagerFirefox = new WebDriverManager("FIREFOX");
        webDriverManagerFirefox.getWebDriver().get("https://www.google.com/");
        webDriverManagerFirefox.getWebDriver().close();
    }

}
