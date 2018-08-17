package pages;

import driver.Commander;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class PageTest {

    protected Commander commander;

    @BeforeTest
    public void setUp() {
        this.commander = new Commander();
    }

    @AfterTest
    public void tearUp() {
        this.logout();
        this.commander.closeBrowser();
    }

    protected void loginAdmin() {
        new LoginPage().login("admin", "admin");
    }

    protected void logout() {
        commander.logout();
    }
}
