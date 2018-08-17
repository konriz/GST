package pageBuilder;

import driver.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ElementFinderTest {

    private TestPage page;

    @BeforeClass
    public void setUp() {
        page = new TestPage();
    }

    @Test
    public void elementFinderTest() {
        ElementFinder.findElements(page);
        page.useElement();
    }

    @AfterClass
    public void tearUp() {
        Driver.getInstance().close();
    }

}
