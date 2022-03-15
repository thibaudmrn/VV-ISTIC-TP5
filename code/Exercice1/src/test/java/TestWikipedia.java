import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;

public class TestWikipedia {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new SafariDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void navigateThroughWikipedia() {
        // Home page of Wikipedia
        driver.get("https://www.wikipedia.org/");

        // Screenshot of the last page
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
