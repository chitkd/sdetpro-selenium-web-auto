package driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    private WebDriver driver;

    public static WebDriver getWebDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        // This is a good workaround to not enable password manager popup from chrome
        chromeOptions.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(chromeOptions);

        /*
         * Global waiting strategy for the whole session when finding an element/elements
         * Interval time: 500ms
         */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15L));
        return driver;
    }

//    public WebDriver getDriver(){
//        if (driver == null){
//            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--incognito");
//            this.driver = new ChromeDriver(chromeOptions);
//        }
//        return this.driver;
//    }

    public WebDriver getDriver(String browserName) {
        // Send request into HUB
        String hub = "http://localhost:4444";
        if (driver == null) {
            // Validate the browserName is valid
            BrowserType browserType;
            try {
                browserType = BrowserType.valueOf(browserName);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("[ERR] The browser type " + browserName + " is not supported!");
            }

            switch (browserType) {
                case chrome:
                    requestChromeSession(hub);
                    break;
                case firefox:
                    requestFirefoxSession(hub);
                    break;
                case safari:
                    requestSafariSession(hub);
                    break;
            }
        }
        return this.driver;
    }

    private void requestChromeSession(String hub) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        sendSessionRequestIntoHub(hub, chromeOptions);
    }
    private void requestFirefoxSession(String hub) {
        // Create default DesiredCaps
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANY);
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.firefox.getName());
        sendSessionRequestIntoHub(hub, desiredCapabilities);
    }

    private void requestSafariSession(String hub) {
        // Create default DesiredCaps
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANY);
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.safari.getName());
        sendSessionRequestIntoHub(hub, desiredCapabilities);
    }

    private void sendSessionRequestIntoHub(String hub, Capabilities capabilities){
        try {
            this.driver = new RemoteWebDriver(new URL(hub), capabilities);
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15L));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void closeBrowserSession() {
        if (driver != null) {
            driver.quit();
        }
    }
}
