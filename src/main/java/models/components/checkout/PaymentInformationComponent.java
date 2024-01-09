package models.components.checkout;

import models.components.Component;
import models.components.ComponentCSSSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import test_data.CreditCardType;

import static test_data.CreditCardType.VISA;

@ComponentCSSSelector("#opc-payment_info")
public class PaymentInformationComponent extends Component {
    private static final By creditCardDropdownSel = By.id("CreditCardType");
    private static final By cardHolderNameSel = By.id("CardholderName");
    private static final By cardNumberSel = By.id("CardNumber");
    private static final By cardExpiredMonthDropdownSel = By.id("ExpireMonth");
    private static final By cardExpiredYearDropdownSel = By.id("ExpireYear");
    private static final By cardCodeSel = By.id("CardCode");
    private static final By purchaseOrderNumberSel = By.id("PurchaseOrderNumber");
    private static final By continueBtnSel = By.cssSelector("input[class*='payment-info-next-step-button']");
    public PaymentInformationComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void selectCardType(CreditCardType creditCardType){
        Assert.assertNotNull(creditCardType, "[ERR] Credit card type can't be null");
        Select select = new Select(findElement(creditCardDropdownSel));
        switch (creditCardType){
            case VISA:
                select.selectByVisibleText("Visa");
                break;
            case MASTER_CARD:
                select.selectByVisibleText("Master card");
                break;
            case DISCOVER:
                select.selectByVisibleText("Discover");
                break;
            case AMEX:
                select.selectByVisibleText("Amex");
                break;
        }
    }

    public void inputCardHolderName(String name){
        findElement(cardHolderNameSel).sendKeys(name);
    }
    public void inputCardNumber(String cardNumber){
        findElement(cardNumberSel).sendKeys(cardNumber);
    }

    public void selectExpiredMonth(String month){
        Select select = new Select(findElement(cardExpiredMonthDropdownSel));
        select.selectByValue(month);
    }
    public void selectExpiredYear(String year){
        Select select = new Select(findElement(cardExpiredYearDropdownSel));
        select.selectByValue(year);
    }

    public void inputCardCode(String cardCode){
        findElement(cardCodeSel).sendKeys(cardCode);
    }

    public void inputPurchaseNumber(String purchaseOrderNumber){
        findElement(purchaseOrderNumberSel).sendKeys(purchaseOrderNumber);
    }

    public void clickOnContinueBtn(){
        findElement(continueBtnSel).click();
    }
}
