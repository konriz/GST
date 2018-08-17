package pages;

import entities.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationPageTest extends PageTest {

    private RegistrationPage registrationPage;

    @BeforeMethod
    public void getPage() {
        registrationPage = new RegistrationPage();
    }

    @Test
    public void registerUser() {
        User user = User.builder().name("Adam").email("adam@padam.pl").password("adampadam").build();
        registrationPage.register(user);
    }

}
