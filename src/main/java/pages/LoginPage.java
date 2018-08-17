package pages;

import driver.Driver;
import elements.HTMLButton;
import elements.HTMLInput;
import pageBuilder.FindElement;

public class LoginPage extends PageObject {

    @FindElement(id = "name-login")
    private HTMLInput loginInput;

    @FindElement(id = "password-login")
    private HTMLInput passwordInput;

    @FindElement(id = "submit-login")
    private HTMLButton submitButton;


    public LoginPage() {
        super(Driver.getInstance(), URLs.LOGIN);
    }

    public void login(String login, String password) {
        inputLogin(login);
        inputPassword(password);
        submit();
    }

    private void inputLogin(String login) {
        loginInput.sendKeys(login);
    }

    private void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    private void submit() {
        submitButton.click();
    }


}
