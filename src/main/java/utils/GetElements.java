package utils;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetElements {
    public By get(String locatorType, String locatorValue) {

        return switch (locatorType) {
            case "id" -> By.id(locatorValue);
            case "name" -> By.name(locatorValue);
            case "class", "class name" -> By.className(locatorValue);
            case "tag", "tag name" -> By.tagName(locatorValue);
            case "link", "link text" -> By.linkText(locatorValue);
            case "partial link", "partial link text" -> By.partialLinkText(locatorValue);
            case "css", "css selector" -> By.cssSelector(locatorValue);
            case "xpath" -> By.xpath(locatorValue);
            default -> throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        };
    }

    public WebElement findWebElement(WebDriver driver, String locatorType, String locatorValue) {
        By locator = get(locatorType, locatorValue);
        return driver.findElement(locator);
    }

    public List<WebElement> findListOfWebElements(WebDriver driver, String locatorType, String locatorValue) {
        By locator = get(locatorType, locatorValue);
        return driver.findElements(locator);
    }

}
