/**
 */

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;


public class TestCase {

    public String testScore = "unset";
    private RemoteWebDriver driver;
    boolean doMaximize = false;

    @Parameters(value = {"browser_api_name", "os_api_name", "screen_resolution"})
    @BeforeMethod
    public void beforeMethod(String browser_api_name, String os_api_name, String screen_resolution) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("name", "Selenium Test Example");
        caps.setCapability("build", "1.0");
        caps.setCapability("browser_api_name", browser_api_name);
        caps.setCapability("os_api_name", os_api_name);
        caps.setCapability("screen_resolution", screen_resolution);
        caps.setCapability("record_video", "true");
        caps.setCapability("record_network", "true");

        if (!browser_api_name.contains("Mbl")){
            doMaximize = true;
        }

        driver = new RemoteWebDriver(
                new URL("http://" + Helper.username + ":" + Helper.authkey + "@hub.crossbrowsertesting.com:80/wd/hub"), caps);
//        driver = new FirefoxDriver();

    }

    @Test
    public void testOne() throws Exception {

        System.out.println(driver.getSessionId());
        // we wrap the test in a try catch loop so we can log assert failures in our system
        try {
            // load the page url
            System.out.println("Loading Url");
            driver.get("http://crossbrowsertesting.github.io/selenium_example_page.html");
            if (doMaximize){
                // maximize the window - DESKTOPS ONLY
                System.out.println("Maximizing window");
                driver.manage().window().maximize();
            }
            // Check the page title (try changing to make the assertion fail!)
            assertEquals(driver.getTitle(), "Selenium Test Example Page");
            // if we get to this point, then all the assertions have passed
            // that means that we can set the score to pass in our system
            testScore = "pass";
        } catch (AssertionError ae) {
            // if we have an assertion error, take a snapshot of where the test fails
            // and set the score to "fail"
            String snapshotHash = Helper.takeSnapshot(driver.getSessionId().toString());
            Helper.setDescription(driver.getSessionId().toString(), snapshotHash, ae.toString());
            testScore = "fail";
        } finally {
            // here we make an api call to actually send the score
            Helper.setScore(driver.getSessionId().toString(), testScore);
            // and quit the driver
            driver.quit();
        }

    }

    @Test(dependsOnMethods = "testOne")
    public void testTwo() throws Exception {

        System.out.println(driver.getSessionId());
        // we wrap the test in a try catch loop so we can log assert failures in our system
        try {
            // load the page url
            System.out.println("Loading Url");
            driver.get("https://www.wikipedia.org");
            if (doMaximize){
                // maximize the window - DESKTOPS ONLY
                System.out.println("Maximizing window");
                driver.manage().window().maximize();
            }
            // Check the page title (try changing to make the assertion fail!)
            assertEquals(driver.getTitle(), "Wikipedia");
            // if we get to this point, then all the assertions have passed
            // that means that we can set the score to pass in our system
            testScore = "pass";
        } catch (AssertionError ae) {
            // if we have an assertion error, take a snapshot of where the test fails
            // and set the score to "fail"
            String snapshotHash = Helper.takeSnapshot(driver.getSessionId().toString());
            Helper.setDescription(driver.getSessionId().toString(), snapshotHash, ae.toString());
            testScore = "fail";
        } finally {
            // here we make an api call to actually send the score
            Helper.setScore(driver.getSessionId().toString(), testScore);
            // and quit the driver
            driver.quit();
        }

    }
}