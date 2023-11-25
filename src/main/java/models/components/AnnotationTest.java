package models.components;

public class AnnotationTest {
    public <T> String getComponentCssSelector(Class<T> componentClass){
        return componentClass.getAnnotation(ComponentCSSSelector.class).value();
    }
}
