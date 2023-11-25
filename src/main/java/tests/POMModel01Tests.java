package tests;

import driver.DriverFactory;
import models.pages.LoginPageModel01;
import org.openqa.selenium.WebDriver;

public class POMModel01Tests {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get("https://");
        LoginPageModel01 loginPage = new LoginPageModel01(driver);
        loginPage.username().sendKeys("abc@gmail.com");
        loginPage.password().sendKeys("1234567890");
        loginPage.loginBtn().click();
    }

    /*
    * SSO
    * 1. Data Driven | YES
    * 2. Base on email value | setting somewhere that decide this user login type
    * 3. From API > login type > give we can get this one (for example using RestAssured)
    *
     */
}
