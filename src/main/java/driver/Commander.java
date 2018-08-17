package driver;

import org.openqa.selenium.WebDriver;
import pages.URLs;

public class Commander {

    private WebDriver driver;

    public Commander() {
//        TODO various browser instances
        this.driver = Driver.getInstance();
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        driver.close();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void logout() {
        driver.get(URLs.LOGOUT);
    }

}
