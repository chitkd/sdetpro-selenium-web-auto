package models.components.global;

import models.components.Component;
import models.components.ComponentCSSSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

@ComponentCSSSelector(".top-menu > li")
public class CatogeryItemComponent extends Component {
    public CatogeryItemComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public WebElement catItemLink(){
        return component.findElement(By.tagName("a"));
    }
    public List<WebElement> sublistItems(){
        Actions actions = new Actions(driver);
        actions.moveToElement(component).perform();
        return findElements(By.cssSelector(".sublist li a"));
    }
}
