package pages;

import driver.Driver;
import elements.HTMLLink;
import pageBuilder.FindElement;

public class HomePage extends PageObject {

    @FindElement(id = "registration-button")
    private HTMLLink registrationButton;

    @FindElement(id = "login-button")
    private HTMLLink loginButton;

    public HomePage() {
        super(Driver.getInstance(), URLs.HOME);
    }

    public void goToLogin() {
        loginButton.click();
    }

    public void goToRegistration() {
        registrationButton.click();
    }
}
