package tests;

import driver.DriverFactory;
import models.pages.LoginPageModel02;
import org.openqa.selenium.WebDriver;

public class POMModel02Tests {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get("https://");
        LoginPageModel02 loginPage = new LoginPageModel02(driver);
        loginPage.inputUsername("cbe@gmail.com");
        loginPage.inputPassword("2345678901");
        loginPage.clickOnLoginBtn();
    }

    /*
    * SSO
    * 1. Data Driven | YES
    * 2. Base on email value | setting somewhere that decide this user login type
    * 3. From API > login type > give we can get this one (for example using RestAssured)
    *
     */
}
