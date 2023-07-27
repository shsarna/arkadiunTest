package locators;

public interface HomePageElements {

    String signInButton = "//button/span[text()='Sign in']";
    String searchButton = "//nav[contains(@class,'NewHeader')]//button[@data-element-description='nav-search-button']";
    String searchTextBox = "[class*='GamesSearchTab'] input[placeholder='Search']";
    String crosswordGameLink = "//h3[text()='Best Daily Quick Crossword']";
}