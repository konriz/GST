package elements;

import org.openqa.selenium.WebElement;

public class HTMLLink extends HTMLElement implements Link {

    public HTMLLink(WebElement element) {
        super(element);
    }

    public void follow() {
        element.click();
    }

}
