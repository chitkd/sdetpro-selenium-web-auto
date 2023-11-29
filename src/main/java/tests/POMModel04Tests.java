package tests;

import driver.DriverFactory;
import models.pages.HomePage;
import models.pages.LoginPageModel03;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POMModel04Tests extends BaseTest{
    @Test
    public void testPOMModel04 (){
        driver.get("https://demowebshop.tricentis.com/");
        HomePage homePage = new HomePage(driver);
        Assert.fail("I check the fail case");
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
