package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitForElementEnabled;

import java.time.Duration;

public class ExplicitWait {

    private static final String TARGET_URL = "https://the-internet.herokuapp.com/login";
    private static final By USERNAME_SEL = By.id("username");

    public static void main(String[] args) {

        // Init Webdriver instance
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);
        try{
            // Implicit wait: Applied globally for the whole session when finding element(s) | Interval time 500 miliseconds
            // Explicit wait:  Applied locally/ for a specific element

            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // This one returns TimeoutException if condition is not matched
            // webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taolao")));
            // webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("taolao")));

            // This one returns NoSuchElementException if condition is not matched
            //webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("taolao"))));


            /*
            // Trigger action and verify another element disappears
            try{
                webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("taolao")));
            } catch(TimeoutException timeoutException){
                // Assert.faile('...')
            }
             */

            // Using customized explicit wait class
            webDriverWait.until(new WaitForElementEnabled(By.cssSelector("#sth")));
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}
