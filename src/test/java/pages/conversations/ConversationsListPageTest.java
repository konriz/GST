package pages.conversations;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PageTest;

import static org.testng.Assert.assertEquals;

public class ConversationsListPageTest extends PageTest {

    private ConversationsListPage conversationsListPage;

    @BeforeClass
    public void openConversationsListPage() {
        loginAdmin();
        conversationsListPage = new ConversationsListPage();
    }

    @Test
    public void countConversations() {
        assertEquals(conversationsListPage.countConversations(), 2);
    }

    @Test
    public void goToCreateNew() {
        conversationsListPage.createNew();
    }


}
