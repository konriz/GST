package pageBuilder;

import driver.Driver;
import elements.HTMLInput;
import pages.PageObject;


public class TestPage extends PageObject {

    @FindElement(id = "lst-ib")
    private HTMLInput typer;

    public TestPage() {
        super(Driver.getInstance(), "http://www.google.com");
    }

    public void useElement() {
        typer.sendKeys("Reflection roxx!");
    }


}
