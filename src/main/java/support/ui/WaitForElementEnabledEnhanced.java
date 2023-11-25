package support.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitForElementEnabledEnhanced implements ExpectedCondition<Boolean> {
    private final WebElement element;

    public WaitForElementEnabledEnhanced(WebElement element) {
        this.element = element;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        return this.element.isEnabled();
    }

    @Override
    public String toString() {
        return "Element{" +
                "ELEMENT=" + element +
                '}';
    }
}
