package utils;

import locators.GamePageElements;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import static utils.BaseTest.driver;

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

    public static void waitForVisibilityOfElement(WebDriver driver, WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public static void waitForVisibilityOfElement(WebDriver driver, WebElement webElement, int minutes){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(minutes));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void clickAndWait(WebDriver driver, WebElement element){
        element.click();
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
    }
    public static void takeSnapShot(WebDriver webdriver,String filePath) throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(System.getProperty("user.dir")+filePath);
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public static void clickWithActions(WebElement element){
        Actions action =new Actions(driver);
        action.moveToElement(element).click().build().perform();

    }


}
