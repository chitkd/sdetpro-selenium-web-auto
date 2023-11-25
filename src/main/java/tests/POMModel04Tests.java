package tests;

import driver.DriverFactory;
import models.pages.HomePage;
import models.pages.LoginPageModel03;
import org.openqa.selenium.WebDriver;

public class POMModel04Tests {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        HomePage homePage = new HomePage(driver);

        homePage.footerComp().doSomething();

    }

    /*
    * SSO
    * 1. Data Driven | YES
    * 2. Base on email value | setting somewhere that decide this user login type
    * 3. From API > login type > give we can get this one (for example using RestAssured)
    *
     */
}
