package elements;

import org.openqa.selenium.WebElement;

public class HTMLInput extends HTMLElement implements Input {

    private WebElement element;

    public HTMLInput(WebElement element) {
        super(element);
    }

    public void input(String keys) {
        element.clear();
        element.sendKeys(keys);
    }

}
