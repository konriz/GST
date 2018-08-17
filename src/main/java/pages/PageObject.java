package pages;

import org.openqa.selenium.WebDriver;
import pageBuilder.ElementFinder;

public class PageObject {

    protected WebDriver driver;
    private String url;

    public PageObject(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        if (!driver.getCurrentUrl().contains(url)) {
            driver.get(url);
        }
        ElementFinder.findElements(this);
    }


}
