package pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginPageTest extends PageTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void openLoginPage() {
        loginPage = new LoginPage();
    }

    @Test
    public void loginAsAdmin() {
        loginPage.login("admin", "admin");
        assertTrue(commander.getCurrentUrl().contains(URLs.HOME));
    }

    @AfterMethod
    public void logout() {
        commander.logout();
    }
}
