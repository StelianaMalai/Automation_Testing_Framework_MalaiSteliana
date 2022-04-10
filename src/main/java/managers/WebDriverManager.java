package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
    public WebDriverManager(String webDriverType) {
        this.webDriverType = webDriverType;
    }

    private String webDriverType;
    private WebDriver webDriver;

    private WebDriver initializeWebDriver() {
        switch (webDriverType) {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
                webDriver = new FirefoxDriver();
                break;
            default:
                System.out.println("Indicated web driver is not available.Please try the correct one.");

        }
        return webDriver;
    }

    public WebDriver getWebDriver() {
        if (webDriver == null) {
            System.out.println("The browser is initializing");
            initializeWebDriver();
        }
        return webDriver;
    }
}


