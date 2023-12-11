package models.pages;

import models.components.Component;
import models.components.global.footer.FooterComponent;
import models.components.global.footer.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import models.components.global.CatogeryItemComponent;

import java.util.List;

public class BasePage extends Component {
    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        super(driver, driver.findElement(By.tagName("html")));
        this.driver = driver;
    }

    public FooterComponent footerComp(){
        return findComponent(FooterComponent.class);
    }

    public HeaderComponent headerComp(){
        return findComponent(HeaderComponent.class);
    }

    public List<CatogeryItemComponent> categoryItemComponents(){
        return findComponents(CatogeryItemComponent.class);
    }
}
