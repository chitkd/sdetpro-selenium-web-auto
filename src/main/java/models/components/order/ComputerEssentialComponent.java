package models.components.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class ComputerEssentialComponent extends BaseItemComponent {

    private final static By allOptionSel = By.cssSelector(".option-list input");
    public ComputerEssentialComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    public abstract String selectProcessorType(String type);
    public abstract String selectRAMType(String type);

    public String selectHDD(String type){
        return selectCompOption(type);
    }

    public String selectOS(String type){
        return selectCompOption(type);
    }

    public String selectSoftware(String type){
        return selectCompOption(type);
    }

    public void unselectDefaultOption(){
        // lambda expression
        component.findElements(allOptionSel).forEach(option -> {
            if (option.getAttribute("checked") != null){
                option.click();
            }
        });
    }

    protected String selectCompOption(String type){
        String selectorStr = "//label[contains(text(),'" + type + "')]";
        By optionSelector = By.xpath(selectorStr);
        List<WebElement> optionEl = component.findElements(optionSelector);
        // If we don't find that element we throw an exception to tell that the option value is not existing on the page
        if (optionEl.isEmpty()){
            throw new RuntimeException("[ERR] The option " + type + "is not existing to select!");
        }
        return optionEl.get(0).getText().trim();
    }
}
