package locators;

public interface GamePageElements {
    String playNowButton = "//button/div[text()='Play Now']";
    String playButtonForToday = "//button[contains(text(),'PLAY')]";
    String gameDateInfo = "//span[contains(@class,'game_inlinePuzzleInfo')]";
    String revealButton = "//section[contains(@class,'game_container')]/section/button[3]";
    String revealPuzzlueOption = "//ul/li[text()='Reveal puzzle']";

}
