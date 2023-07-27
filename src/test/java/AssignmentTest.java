import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.DateTimeUtils;
import utils.SeleniumUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AssignmentTest extends BaseTest {

   @Test
    public void playTodayGame() throws Exception {
        homePage.searchAndSelectGame("Best Daily Quick Crossword");
        gamePage.startTheGameForToday();

        String expectedDate = DateTimeUtils.getTodaysDate("dd MMM");
        String actualDate = gamePage.getDateInformation();

       Assert.assertTrue(
               actualDate.contains(expectedDate),
               "Expected: "+expectedDate+" Actual: "+actualDate);

        gamePage.solveTheGameUsingRevealPuzzleOption();
        resultsOverlay.waitForResultsOverlay();
       SeleniumUtils.takeSnapShot(driver,"/src/test/resources/Screenshots/test.png");
       resultsOverlay.submitTotalScore();
       gamePage.clickPlayButton();

    }

}
