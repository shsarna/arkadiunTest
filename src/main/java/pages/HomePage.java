package pages;

import locators.HomePageElements;
import utils.GetElements;
import utils.SeleniumUtils;

import static utils.BaseTest.driver;

public class HomePage {
    GetElements getElements = new GetElements();

    public void searchAndSelectGame(String gameName){
        getElements.findWebElement(driver,"xpath", HomePageElements.searchButton).click();
        getElements.findWebElement(driver,"css", HomePageElements.searchTextBox).sendKeys(gameName);
        SeleniumUtils.clickAndWait(driver,getElements.findWebElement(driver,"xpath", "//h3[text()='"+gameName+"']"));
    }
}
