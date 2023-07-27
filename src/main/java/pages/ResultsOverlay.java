package pages;

import locators.ResultsOverlayElements;
import utils.GetElements;
import utils.SeleniumUtils;

import static utils.BaseTest.driver;

public class ResultsOverlay {
    GetElements getElements = new GetElements();

    public void waitForResultsOverlay(){
        SeleniumUtils.waitForVisibilityOfElement(
                driver,
                getElements.findWebElement(driver,"xpath",ResultsOverlayElements.resultsOverlay));
    }

    public void submitTotalScore(){
        getElements.findWebElement(driver, "xpath", ResultsOverlayElements.submitTotalScoreButton).click();
    }


}
