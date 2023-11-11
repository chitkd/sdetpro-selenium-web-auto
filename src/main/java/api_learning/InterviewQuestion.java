package api_learning;

import dev.failsafe.internal.util.Assert;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InterviewQuestion {
    private static final By USERNAME_SEL = By.id("username");
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/login";

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();

        /* Method 1:
        Exception exception = null;
        try {
            // launch the page
            driver.get(TARGET_URL);
            WebElement usernameEle = driver.findElement(USERNAME_SEL);
        } catch (NoSuchElementException e){
            exception = e;
        }
        finally {
            driver.quit();
        }
        if (exception == null){
            System.out.println("The element ABC is on the page");
        }
         */

        // Method 2
        List<WebElement> usernameEles = driver.findElements(USERNAME_SEL);
        if (!usernameEles.isEmpty()){
            System.out.println("The element ABC is on the page");
        }
        else{
            System.out.println("The element ABC is NOT on the page");
        }
        driver.quit();
    }
}
