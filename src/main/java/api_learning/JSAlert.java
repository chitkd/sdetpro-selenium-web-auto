package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JSAlert {

    private static final String TARGET_URL = "https://the-internet.herokuapp.com/javascript_alerts";
    private static final By JS_ALERT_SEL = By.cssSelector("[onclick='jsAlert()']");
    private static final By JS_ALERT_CONFIRM_SEL = By.cssSelector("[onclick='jsConfirm()']");
    private static final By JS_ALERT_PROMPT_SEL = By.cssSelector("[onclick='jsPrompt()']");
    private static final By RESULT_SEL = By.id("result");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);

        try {
            WebElement resultEle = driver.findElement(RESULT_SEL);

            // IS ALERT interactions
            handleAlert(driver, JS_ALERT_SEL, true);
            System.out.println(resultEle.getText());
            Thread.sleep(2000);

            // IS ALERT CONFIRM interactions
            handleAlert(driver, JS_ALERT_CONFIRM_SEL, false);
            System.out.println(resultEle.getText());
            Thread.sleep(2000);

            // IS ALERT PROMPT interactions
            handleAlert(driver, JS_ALERT_PROMPT_SEL, true, "Hello, Only check input text");
            System.out.println(resultEle.getText());
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void handleAlert(WebDriver driver, By triggerBtn, boolean isAccepting, String... messages) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(triggerBtn).click();
        Alert jsAlert = wait.until(ExpectedConditions.alertIsPresent());
        if (messages.length > 0) {
            jsAlert.sendKeys(messages[0]);
            makeJsAlertDecision(jsAlert, isAccepting);
        } else {
            makeJsAlertDecision(jsAlert, isAccepting);
        }
    }

    private static void makeJsAlertDecision(Alert jsAlert, boolean isAccepting) {
        if (isAccepting) {
            jsAlert.accept();
        } else {
            jsAlert.dismiss();
        }
    }
}
