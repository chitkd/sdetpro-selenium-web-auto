package tests;

import driver.DriverFactory;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class ProductComponentTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get("https://demowebshop.tricentis.com/");

        try {
            HomePage homePage = new HomePage(driver);
            homePage.productItemCompList().forEach(productItemComponent -> {
                System.out.println(productItemComponent.productiTitleEle().getText());
            });
        } catch (Exception ignored){

        } finally {
            driver.quit();
        }
    }
}
