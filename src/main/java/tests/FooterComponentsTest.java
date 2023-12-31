package tests;

import driver.DriverFactory;
import models.components.global.footer.*;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterComponentsTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get("https://demowebshop.tricentis.com/");

        try {
            HomePage homePage = new HomePage(driver);
            FooterComponent footerComponent = homePage.footerComp();
            //InformationColumnComponent informationColumnComp = footerComponent.informationColumnComp();
            //testFooterComp(informationColumnComp);

            //CustomerServiceColumnComponent customerServiceColumnComp = footerComponent.customerServiceColumnComp();
            //testFooterComp(customerServiceColumnComp);

            FollowUsColumnComponent followUsColumnComp = footerComponent.followUsColumnComp();
            testFooterComp(followUsColumnComp);
        } catch (Exception ignored){

        } finally {
            driver.quit();
        }
    }

    private static void testFooterComp(FooterColumnComponent footerColumnComponent) {
        System.out.println("Footer Col Comp" + footerColumnComponent.headerEle().getText());
        for (WebElement linkEle : footerColumnComponent.linksEle()) {
            System.out.println(linkEle.getText() + ": " + linkEle.getAttribute("href"));
        }

        System.out.println("=====");
    }
}
