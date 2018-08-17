package pages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomePageTest extends PageTest {

    private HomePage homePage;

    @BeforeMethod
    public void openHomePage() {
        homePage = new HomePage();
    }

    @Test
    public void goToLoginPage() {
        homePage.goToLogin();
        assertTrue(commander.getCurrentUrl().contains(URLs.LOGIN));
    }

    @Test
    public void goToRegistrationPage() {
        homePage.goToRegistration();
        assertTrue(commander.getCurrentUrl().contains(URLs.REGISTRATION));
    }

}
