package models.components.global.footer;

import models.components.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterComponent extends Component {
    public FooterComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public InformationColumnComponent informationColumnComp(){
        return findComponent(InformationColumnComponent.class);
    }

    public CustomerServiceColumnComponent customerServiceColumnComp(){
        return findComponent(CustomerServiceColumnComponent.class);
    }
}
