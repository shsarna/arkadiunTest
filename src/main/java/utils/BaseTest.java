package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;


import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public SeleniumUtils seleniumUtils;

    static String gridEndPoint="";

    //pageClasses
    public LandingPage landingPage;
    public HomePage homePage;
    public SignInPage signInPage;
    public TemplatesPage templatesPage;
    public RetweetsTrackerPage retweetsTrackerPage;
    public ShareOverlayPage shareOverlayPage;
    public SpreadsheetPage spreadsheetPage;

    public String username;
    public String password;



    @BeforeMethod
    @Parameters({"browser"})
    public void beforeMethod(String browser){
        driverSetUp(browser);
        driver.get(ConfigUtils.applicationUrl);
        username = ConfigUtils.username;
        password = ConfigUtils.password;
        initialisePageClasses();
    }

    @AfterMethod
    public void afterMethod(ITestResult itestResult){
        driver.quit();
    }

    public WebDriver driverSetUp(String browser){
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                if (System.getProperty("webdriver.mode", "STANDALONE").equalsIgnoreCase("STANDALONE")) {
                    driver = new ChromeDriver(getChromeOptions());
                } else if (System.getProperty("webdriver.mode", "STANDALONE").equalsIgnoreCase("GRID")) {
                    driver = new RemoteWebDriver(new URL(gridEndPoint), getChromeOptions());
                }
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
                return driver;
            } else {
                throw new Exception("Following " + browser + " is not supported with this framework");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return driver;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions desiredChromeOptions = new ChromeOptions();
        desiredChromeOptions.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
        desiredChromeOptions.addArguments("--remote-allow-origins=*");
        if(System.getProperty("webdriver.mode","STANDALONE").equalsIgnoreCase("STANDALONE")) {
            WebDriverManager.chromedriver().setup();
        }
        return desiredChromeOptions;
    }

    private void initialisePageClasses(){
        seleniumUtils = new SeleniumUtils();
        homePage = new HomePage();
        landingPage = new LandingPage();
        signInPage = new SignInPage();
        templatesPage = new TemplatesPage();
        retweetsTrackerPage = new RetweetsTrackerPage();
        shareOverlayPage = new ShareOverlayPage();
        spreadsheetPage = new SpreadsheetPage();
    }
}
