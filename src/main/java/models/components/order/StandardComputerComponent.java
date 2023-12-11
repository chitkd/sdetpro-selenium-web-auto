package models.components.order;

import models.components.ComponentCSSSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import support.ui.SelectEx;

import java.util.List;

@ComponentCSSSelector(".product-essential")
public class StandardComputerComponent extends ComputerEssentialComponent{
    private static final By productAttributeSel = By.cssSelector("select[name^='product_attribute']");
    public StandardComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    public String selectProcessorType(String type) {
        final int PROCESS_DROPDOWN_INDEX = 0;
        WebElement processorDropdownEle = component.findElements(productAttributeSel).get(PROCESS_DROPDOWN_INDEX);
        return selectOption(processorDropdownEle, type);
    }

    @Override
    public String selectRAMType(String type) {
        final int RAM_DROPDOWN_INDEX = 1;
        WebElement ramDropdownEle = component.findElements(productAttributeSel).get(RAM_DROPDOWN_INDEX);
        return selectOption(ramDropdownEle, type);
    }

    private String selectOption(WebElement dropdownEle, String type){
        SelectEx select = new SelectEx(dropdownEle);
        List<WebElement> allOptionEles = select.getOptions();
        String fullStrOption = null;

        // Logic

        // If null -> Exception

        for (WebElement optionEle : allOptionEles) {
            String currentOptionText = optionEle.getText();
            String optionTextWithoutSpaces = currentOptionText.trim().replace(" ", "");
            if (optionTextWithoutSpaces.startsWith(type)){
                fullStrOption = currentOptionText;
                break;
            }
        }

        if (fullStrOption == null){
            throw new RuntimeException("[ERR] The option " + type + "is not existing to select");
        }


        select.selectByVisibleText(fullStrOption);
        return fullStrOption;
    }
}
