package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class SeleniumUtils {

    public WebDriver switchToLastTab(WebDriver driver){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
        return driver;
    }

    public WebDriver openNewTab(WebDriver driver ){
        ((JavascriptExecutor) driver).executeScript("window.open()");// launching a new tab
        return driver;
    }

    public String pasteCopiedClipboardText(){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);
        String copiedText;
        try {
            copiedText = (String) contents.getTransferData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Copied Text: "+copiedText);
        return copiedText;
    }

    public WebElement switchToActiveElement(WebDriver driver){
        return driver.switchTo().activeElement();
    }

    public void waitForVisibilityOfElement(WebDriver driver, WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void clickAndWait(WebDriver driver, WebElement element){
        element.click();
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

}
