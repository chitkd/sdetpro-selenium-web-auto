package models.components.order;

import io.qameta.allure.Step;
import models.components.ComponentCSSSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCSSSelector(".product-essential")
public class CheapComputerComponent extends ComputerEssentialComponent{
    public CheapComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Step("Select processor type: {type}")
    @Override
    public String selectProcessorType(String type) {
        return selectCompOption(type);
    }

    @Step("Select RAM type: {type}")
    @Override
    public String selectRAMType(String type) {
        return selectCompOption(type);
    }
}
