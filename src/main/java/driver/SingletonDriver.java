package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static constants.Constants.IMPLICITLY_WAIT_TIMEOUT;
import static driver.CapabilitiesHelper.getChromeOptions;

public class SingletonDriver {

    private static WebDriver driver;

   // private static String browser = "browser";

    public static WebDriver getDriver() {
        switch (System.getProperty("browser")) {
            case "Chrome":
                if (driver == null) {
                    //System.getProperty("browser");
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                }
                break;

            case "Firefox":
                if (driver == null) {
                   // System.getProperty("browser");
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                    driver = new FirefoxDriver();
                }
                break;

            default:
                throw new IllegalStateException("This driver is not supported");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
