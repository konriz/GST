package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsElement;

public interface Element extends WebElement, WrapsElement {
    boolean elementWired();
}
