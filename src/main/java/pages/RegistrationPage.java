package pages;

import driver.Driver;
import elements.HTMLButton;
import elements.HTMLInput;
import entities.User;
import pageBuilder.FindElement;

public class RegistrationPage extends PageObject {

    @FindElement(css = "form #name")
    private HTMLInput name;

    @FindElement(css = "form #email")
    private HTMLInput email;

    @FindElement(css = "form #password")
    private HTMLInput password;

    @FindElement(css = "form #confirmPassword")
    private HTMLInput confirmPassword;

    @FindElement(css = "form #submit-register")
    private HTMLButton submit;

    public RegistrationPage() {
        super(Driver.getInstance(), URLs.REGISTRATION);
    }

    public void register(User user) {
        name.sendKeys(user.getName());
        email.sendKeys(user.getEmail());
        password.sendKeys(user.getPassword());
        confirmPassword.sendKeys(user.getPassword());
        submit.click();
    }
}
