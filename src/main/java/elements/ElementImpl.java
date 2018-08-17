package elements;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;

import java.util.List;

public abstract class ElementImpl implements Element {

    WebElement element;

    ElementImpl(WebElement element) {
        this.element = element;
    }

    public boolean elementWired() {
        return (this.element != null);
    }

    public void click() {
        element.click();
    }

    public void submit() {
        element.submit();
    }

    public void sendKeys(CharSequence... charSequences) {
        element.sendKeys(charSequences);
    }

    public void clear() {
        element.clear();
    }

    public String getTagName() {
        return element.getTagName();
    }

    public String getAttribute(String s) {
        return element.getTagName();
    }

    public boolean isSelected() {
        return element.isSelected();
    }

    public boolean isEnabled() {
        return element.isEnabled();
    }

    public String getText() {
        return element.getText();
    }

    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    public Point getLocation() {
        return element.getLocation();
    }

    public Dimension getSize() {
        return element.getSize();
    }

    public Rectangle getRect() {
        return element.getRect();
    }

    public String getCssValue(String s) {
        return element.getCssValue(s);
    }

    //    TODO beta function in main library
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }

    public Coordinates getCoordinates() {
        return ((Locatable) element).getCoordinates();
    }

    public WebElement getWrappedElement() {
        return element;
    }
}
