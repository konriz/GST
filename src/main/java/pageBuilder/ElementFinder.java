package pageBuilder;

import driver.Driver;
import elements.Element;
import elements.ElementImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.PageObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class ElementFinder {

    public static void findElements(PageObject page) {
        Field[] pageFields = page.getClass().getDeclaredFields();
        for (Field field : pageFields) {
            if (field.isAnnotationPresent(FindElement.class)) {
                if (isList(field)) {
                    setListContent(page, field);
                } else {
                    setContent(page, field);
                }
            }
        }
    }

    private static boolean isList(Field field) {
        return List.class.isAssignableFrom(field.getType());
    }

    private static void setListContent(PageObject page, Field field) {
        By searchBy = searchBy(field.getAnnotation(FindElement.class));
        ParameterizedType elementListType = (ParameterizedType) field.getGenericType();
        Class<?> elementsClass = (Class<?>) elementListType.getActualTypeArguments()[0];
        List<Element> elements = createElementsList(elementsClass, searchBy);
        try {
            field.setAccessible(true);
            field.set(page, elements);
        } catch (NoSuchElementException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static List<Element> createElementsList(Class<?> elementsType, By searchBy) {
        WebDriver driver = Driver.getInstance();
        List<Element> elements = new ArrayList<>();
        List<WebElement> webElements = driver.findElements(searchBy);

        for (WebElement webElement : webElements) {
            Element element = createElement(elementsType, webElement);
            elements.add(element);
        }
        return elements;
    }

    private static void setContent(PageObject page, Field field) {
        By searchBy = searchBy(field.getAnnotation(FindElement.class));
        WebElement webElement = Driver.getInstance().findElement(searchBy);
        Element element = createElement(field.getType(), webElement);
        try {
            field.setAccessible(true);
            field.set(page, element);
        } catch (NoSuchElementException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static By searchBy(FindElement annotation) {
        By by = null;

        if (!annotation.id().equals("")) {
            by = By.id(annotation.id());
        } else if (!annotation.css().equals("")) {
            by = By.cssSelector(annotation.css());
        }

        return by;
    }

    private static <T extends ElementImpl> T createElement(Class<?> elementType, WebElement webElement) {
        T element = null;
        try {
            Constructor constructor = elementType.getDeclaredConstructor(WebElement.class);
            element = (T) constructor.newInstance(webElement);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return element;
    }

}
