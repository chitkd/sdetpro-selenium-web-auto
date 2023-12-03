package support.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class ExpectedConditionEx {
    public static ExpectedCondition<List<WebElement>> presenceOfAllElementsLocatedBy(final WebElement patentComp, final By locator) {
        return new ExpectedCondition<List<WebElement>>() {
            @Override
            public List<WebElement> apply(WebDriver driver) {
                List<WebElement> elements = patentComp.findElements(locator);
                return elements.size() > 0 ? elements : null;
            }

            @Override
            public String toString() {
                return "presence of any elements located by " + locator;
            }
        };
    }
}