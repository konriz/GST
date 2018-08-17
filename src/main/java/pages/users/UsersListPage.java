package pages.users;

import driver.Driver;
import elements.HTMLLink;
import org.openqa.selenium.support.PageFactory;
import pageBuilder.FindElement;
import pages.PageObject;
import pages.URLs;

import java.util.List;

public class UsersListPage extends PageObject {

    @FindElement(css = "ul[id=users-list] li a")
    private List<HTMLLink> users;

    public UsersListPage() {
        super(Driver.getInstance(), URLs.USERS);
        PageFactory.initElements(Driver.getInstance(), this);
    }

    public boolean userExists(String name) {
        return this.users.stream().anyMatch(link -> link.getText().equals(name));
    }

    public void listUsers() {
        users.forEach(user -> System.out.println(user.getText()));
    }

}
