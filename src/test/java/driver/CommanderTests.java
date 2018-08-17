package driver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CommanderTests {

    private Commander commander;

    @BeforeClass
    public void setUp() {
        this.commander = new Commander();
    }

    @Test
    public void connectGoogle() {
        commander.openUrl("https://www.google.com/");
        assertEquals("https://www.google.com/", commander.getCurrentUrl());
    }

    @AfterClass
    public void tearUp() {
        commander.closeBrowser();
    }

}
