package pages.conversations;

import driver.Driver;
import elements.HTMLLink;
import pageBuilder.FindElement;
import pages.PageObject;
import pages.URLs;

import java.util.List;

public class ConversationsListPage extends PageObject {

    @FindElement(css = ".conversations-list a")
    private List<HTMLLink> conversations;

    @FindElement(css = ".button")
    private HTMLLink newConversationButton;

    public ConversationsListPage() {
        super(Driver.getInstance(), URLs.CONVERSATIONS);
    }

    public int countConversations() {
        return conversations.size();
    }

    public void createNew() {
        newConversationButton.follow();
    }

    public void goTo(String name) {
        findConversationLink(name).follow();
    }

    private HTMLLink findConversationLink(String name) {
        for (HTMLLink conversation : this.conversations) {
            if (conversation.getText().contains(name)) {
                return conversation;
            }
        }
        return null;
    }
}
