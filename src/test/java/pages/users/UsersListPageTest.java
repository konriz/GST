package pages.users;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PageTest;

import static org.testng.Assert.assertTrue;

public class UsersListPageTest extends PageTest {

    private UsersListPage usersListPage;

    @BeforeClass
    public void openUsersPage() {
        loginAdmin();
        usersListPage = new UsersListPage();
    }

    @Test
    public void adminExistsTest() {
        assertTrue(usersListPage.userExists("admin"));
    }

}
