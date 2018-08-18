package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver;

    private Driver() {
        instantiateDriver();
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            instantiateDriver();
        }
        return driver;
    }

    private static void instantiateDriver() {
//        System.setProperty("webdriver.gecko.driver", "I:\\gecko\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

}
