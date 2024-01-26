package test_flows.global;

import models.components.global.footer.*;
import models.pages.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import models.components.global.CatogeryItemComponent;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow {
    private final WebDriver driver;
    private BasePage basePage;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent() {
        Assert.fail("I like it that way!");
        BasePage basePage = new BasePage(this.driver);
        InformationColumnComponent informationColumnComp = basePage.footerComp().informationColumnComp();
        CustomerServiceColumnComponent customerServiceColumnComp = basePage.footerComp().customerServiceColumnComp();
        MyAccountColumnComponent myAccountColumnComp = basePage.footerComp().myAccountColumnComp();
        FollowUsColumnComponent followUsColumnComp = basePage.footerComp().followUsColumnComp();
        verifyInformationColumn(informationColumnComp);
        verifyCustomerServiceColumn(customerServiceColumnComp);
        verifyMyAccountColumn(myAccountColumnComp);
        verifyFollowUsColumn(followUsColumnComp);
    }

    public void verifyProductCatFooterComponent() {
        // Randomly pickup MainItem from TopMenuComponent
        BasePage basePage = new BasePage(driver);
        List<CatogeryItemComponent> categoryItemComponents = basePage.categoryItemComponents();
        Assert.assertFalse(categoryItemComponents.isEmpty(), "[ERR] There is no item on top menu");
        int randomCategoryComponentIndex = new SecureRandom().nextInt(categoryItemComponents.size());
        CatogeryItemComponent randomCategoryComponent = categoryItemComponents.get(randomCategoryComponentIndex);
        String randomCatHref = randomCategoryComponent.catItemLink().getAttribute("href");

        // Get sublist (if any) then click on a random sub-item / MainItem (if has no sublist)
        List<WebElement> sublistItems = randomCategoryComponent.sublistItems();
        if (sublistItems.isEmpty()){
            randomCategoryComponent.catItemLink().click();
        } else {
            int randomSubItemIndex = new SecureRandom().nextInt(sublistItems.size());
            WebElement randomSubItem = sublistItems.get(randomSubItemIndex);
            randomCatHref = randomSubItem.getAttribute("href");
            randomSubItem.click();
        }


        // Make sure we are on the right page | Wait until navigation is done
        try{
            WebDriverWait wait = randomCategoryComponent.componentWait();
            wait.until(ExpectedConditions.urlContains(randomCatHref));
        } catch(TimeoutException ignored){
            Assert.fail("[ERR] Target page is not matched");
        }

        // Call common verify method
        verifyFooterComponent();
    }

    private void verifyInformationColumn(FooterColumnComponent informationColumnComp) {
        List<String> expectedLinkTexts = Arrays.asList("Sitemap", "Shipping & Returns", "Privacy Notice", "Conditions of Use", "About us", "Contact us");
        List<String> expectedLinkHrefs = Arrays.asList("/sitemap", "/shipping-returns", "/privacy-policy", "/conditions-of-use", "/about-us", "/contactus");
        testFooterColumn(informationColumnComp, expectedLinkTexts, expectedLinkHrefs, "https://demowebshop.tricentis.com");
    }

    private void verifyCustomerServiceColumn(FooterColumnComponent customerServiceColumnComp) {
        List<String> expectedLinkTexts = Arrays.asList("Search", "News", "Blog", "Recently viewed products", "Compare products list", "New products");
        List<String> expectedLinkHrefs = Arrays.asList("/search", "/news", "/blog", "/recentlyviewedproducts", "/compareproducts", "/newproducts");
        String prefixUrl = "https://demowebshop.tricentis.com";
        testFooterColumn(customerServiceColumnComp, expectedLinkTexts, expectedLinkHrefs, "https://demowebshop.tricentis.com");
    }

    private void verifyMyAccountColumn(FooterColumnComponent myAccountColumnComp) {
        List<String> expectedLinkTexts = Arrays.asList("My account", "Orders", "Addresses", "Shopping cart", "Wishlist");
        List<String> expectedLinkHrefs = Arrays.asList("/customer/info", "/customer/orders", "/customer/addresses", "/cart", "/wishlist");
        String prefixUrl = "https://demowebshop.tricentis.com";
        testFooterColumn(myAccountColumnComp, expectedLinkTexts, expectedLinkHrefs, "https://demowebshop.tricentis.com");
    }

    private void verifyFollowUsColumn(FooterColumnComponent followUsColumnComp) {
        List<String> expectedLinkTexts = Arrays.asList("Facebook", "Twitter", "RSS", "YouTube", "Google+");
        List<String> expectedLinkHrefs = Arrays.asList("http://www.facebook.com/nopCommerce", "https://twitter.com/nopCommerce", "https://demowebshop.tricentis.com/news/rss/1", "http://www.youtube.com/user/nopCommerce", "https://plus.google.com/+nopcommerce");
        testFooterColumn(followUsColumnComp, expectedLinkTexts, expectedLinkHrefs, "");
    }

    private void testFooterColumn(FooterColumnComponent footerColumnComp, List<String> expectedLinkTexts, List<String> expectedHrefs, String prefixUrl) {
        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualHrefs = new ArrayList<>();
        expectedHrefs.replaceAll(originHref -> prefixUrl + originHref);
        footerColumnComp.linksEle().forEach(columnItem -> {
            actualLinkTexts.add(columnItem.getText());
            actualHrefs.add(columnItem.getAttribute("href"));
        });

        if (actualLinkTexts.isEmpty() || actualHrefs.isEmpty()) {
            Assert.fail("Footer column texts OR hyperlinks are empty!");
        }

        Assert.assertEquals(actualLinkTexts, expectedLinkTexts, "[ERR] Footer column link texts are different");
        Assert.assertEquals(actualHrefs, expectedHrefs, "[ERR] Footer column hrefs are different");
    }
}
