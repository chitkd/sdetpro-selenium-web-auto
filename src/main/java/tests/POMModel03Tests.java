package tests;

import driver.DriverFactory;
import models.pages.LoginPageModel03;
import org.openqa.selenium.WebDriver;

public class POMModel03Tests {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get("https://");
        LoginPageModel03 loginPage = new LoginPageModel03(driver);
        loginPage
                .inputUsername("cbe@gmail.com");
                //.inputPassword("2345678901")
               // .clickOnLoginBtn();
    }

    /*
    * SSO
    * 1. Data Driven | YES
    * 2. Base on email value | setting somewhere that decide this user login type
    * 3. From API > login type > give we can get this one (for example using RestAssured)
    *
     */
}
