package models.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Component {
    protected WebDriver driver;
    protected WebElement component;
    protected WebDriverWait wait;

    public Component(WebDriver driver, WebElement component) {
        this.driver = driver;
        this.component = component;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
    }

    // Narrow down searching scope
    public WebElement findElement(By by){
        return this.component.findElement(by);
    }

    public List<WebElement> findElements(By by){
        return this.component.findElements(by);
    }

    public <T extends Component> T findComponent(Class<T> componentClass){
        return this.findComponents(componentClass).get(0);
    }
    public <T extends Component> List<T> findComponents(Class<T> componentClass){
        return null;
    }

    private By getComponentSelector(Class<? extends Component> componentClass){
        /*
        if (componentClass.isAnnotationPresent(ComponentCSSSelector.class)){

        }
*/
        return By.cssSelector(componentClass.getAnnotation(ComponentCSSSelector.class).value());

       // else if (componentClass)
    }
}
