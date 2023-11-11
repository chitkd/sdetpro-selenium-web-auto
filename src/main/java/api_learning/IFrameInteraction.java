package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.ui.SelectEx;

public class IFrameInteraction {
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/iframe";
    private static final By IFRAME_SEL = By.cssSelector("frame[id^=\"mce\"]");
    private static WebDriver driver;

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);

        try {
           WebElement iframe = driver.findElement(IFRAME_SEL);

           // Switch to the target iframe
           driver.switchTo().frame(iframe);

           // Interact with iframe's elems
            WebElement inputFieldEle = driver.findElement(By.id("tinymce"));
            inputFieldEle.click();
            inputFieldEle.clear();
            inputFieldEle.sendKeys("Hello, Check input text");
            Thread.sleep(2000);

            // Switch back to the parent frame
            driver.switchTo().defaultContent();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
