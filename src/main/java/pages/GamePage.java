package pages;

import locators.GamePageElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.DateTimeUtils;
import utils.GetElements;
import utils.SeleniumUtils;

import static utils.BaseTest.driver;

public class GamePage {
    GetElements getElements = new GetElements();

    public void startTheGameForToday() throws InterruptedException {
       clickPlayNowButton();

        String todayDate = DateTimeUtils.getTodaysDate("dd");
        SeleniumUtils.waitForVisibilityOfElement(
                    driver,
                    getElements.findWebElement(driver, "xpath", "//span[text()='"+todayDate+"']/..//button"),
                    5);
        SeleniumUtils.clickWithActions(getElements.findWebElement(driver, "xpath", "//span[text()='"+todayDate+"']/..//button"));
    }

    public void clickPlayNowButton() throws InterruptedException {
        SeleniumUtils.waitForVisibilityOfElement(
                driver,
                getElements.findWebElement(driver, "xpath", GamePageElements.playNowButton),
                1800);
        getElements.findWebElement(driver, "xpath", GamePageElements.playNowButton).click();
        Thread.sleep(3600);
    }

    public void clickPlayButton(){
        SeleniumUtils.waitForVisibilityOfElement(
                driver,
                getElements.findWebElement(driver, "xpath", "//button[contains(text(),'PLAY')]"),
                5);
        SeleniumUtils.clickWithActions(getElements.findWebElement(driver, "xpath", "//button/span[contains(text(),'Play')]"));
    }

    public String getDateInformation(){
        return getElements.findWebElement(driver, "xpath", GamePageElements.gameDateInfo).getText();
    }

    public void solveTheGameUsingRevealPuzzleOption(){
        getElements.findWebElement(driver, "xpath", GamePageElements.revealButton).click();
        getElements.findWebElement(driver, "xpath", GamePageElements.revealPuzzlueOption).click();
    }
}
