import Steps.MainPageSteps;
import Steps.PopUpSteps;
import Steps.SettingsSteps;
import Steps.WelcomeSteps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


/**
 * Created by mlanina on 24/04/17.
 */

public class BaseTests  {
    protected Configuration configuration = new Configuration();
    protected AndroidDriver driver;
    protected static Logger LOG = Logger.getLogger(BaseTests.class.getName());
    protected MainPageSteps mainPageSteps;
    protected WelcomeSteps welcomeSteps;
    protected PopUpSteps popUpSteps;
    protected SettingsSteps settingsSteps;

    private static final String newWorkDuration = "35";
    private static final String newBreakDuration = "10";

    @BeforeSuite
    public void setConfiguration() {
        configuration.startAppiumServer();
        driver = configuration.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOG.info("Driver was configured");
        mainPageSteps = new MainPageSteps(driver);
        welcomeSteps = new WelcomeSteps(driver);
        popUpSteps = new PopUpSteps(driver);
        settingsSteps = new SettingsSteps(driver);
        LOG.info("MainPageSteps instance was successfully created");
    }

    @Test
    public void launchAppFirstTime() {
        LOG.info("App is launching");

        welcomeSteps.checkFirstSlideElementsArePresent();
        welcomeSteps.clickOnForwardButton();
        welcomeSteps.checkSecondSlideElementsArePresent();
        welcomeSteps.clickOnForwardButton();
        welcomeSteps.checkThirdSlideElementsArePresent();
        welcomeSteps.clickOnForwardButton();
        welcomeSteps.checkFourthSlideElementsArePresent();
        welcomeSteps.clickOnForwardButton();
        welcomeSteps.checkFifthSlideElementsArePresent();
        welcomeSteps.clickOnForwardButton();
        welcomeSteps.checlLastSlideElementsArePresent();
        welcomeSteps.clickOnBackwardButton();
        welcomeSteps.checkFifthSlideElementsArePresent();
        welcomeSteps.clickOnForwardButton();
        welcomeSteps.checlLastSlideElementsArePresent();
        welcomeSteps.clickOnDoneButton();

        LOG.info("App was launched");
    }

    @Test(dependsOnMethods = "launchAppFirstTime")
    public void checkMainPage() {
        mainPageSteps.checkMainPageEementsAreDisplayed();

    }

    @Test(dependsOnMethods = {"checkMainPage"})
    public void performWorkSession() {
        mainPageSteps.clickOnStartButton();
        mainPageSteps.checkElementsArePresentAfterSessionStarts();
        mainPageSteps.checkWorkSessionStarted();
        mainPageSteps.clickOnPauseButton();
        mainPageSteps.checkElementsAfterClickingOnPause();
        mainPageSteps.clickOnResumeButton();
        mainPageSteps.checkElementsArePresentAfterSessionStarts();
        mainPageSteps.checkWorkSessionStarted();
    }


    @Test(dependsOnMethods = "performWorkSession")
    public void moveFromWorkSessionToBreak() {
        mainPageSteps.clickOnSkipBreakButton();
        mainPageSteps.checkElementsArePresentAfterSessionStarts();
        mainPageSteps.checkBreakStarted();
    }

    @Test(dependsOnMethods = "moveFromWorkSessionToBreak")
    public void moveFromBreakToWorkSession() {
        mainPageSteps.clickOnSkipBreakButton();
        mainPageSteps.checkElementsArePresentAfterSessionStarts();
        mainPageSteps.checkWorkSessionStarted();
    }

    @Test(dependsOnMethods = "moveFromBreakToWorkSession")
    public void increaseSessionDuration(){
       mainPageSteps.checkMinutesNumberIncreased();
    }

    @Test(dependsOnMethods = "increaseSessionDuration")
    public void skipWorkSession() {
        mainPageSteps.clickOnStopButton();
        popUpSteps.verifyElementsInPopUp();
        popUpSteps.clickOnCancelButton();
        mainPageSteps.clickOnStopButton();
        popUpSteps.verifyElementsInPopUp();
        popUpSteps.clickOnOKButton();
        mainPageSteps.checkMainPageEementsAreDisplayed();
    }

    @Test(dependsOnMethods = "skipWorkSession")
    public void takeBreak() {
        mainPageSteps.clickOnBreakButton();
        mainPageSteps.checkElementsArePresentAfterSessionStarts();
        mainPageSteps.checkBreakStarted();
        mainPageSteps.clickOnPauseButton();
        mainPageSteps.checkElementsAfterClickingOnPause();
        mainPageSteps.clickOnResumeButton();
        mainPageSteps.checkElementsArePresentAfterSessionStarts();
    }

    @Test(dependsOnMethods = "takeBreak")
    public void checkSettingsExist() {
        settingsSteps.clickOnSettings();
        settingsSteps.checkSettingListDisplay();
        LOG.info("Settings are opened");
    }

    @Test(dependsOnMethods = "checkSettingsExist")
    public void adjustSettings() {
        settingsSteps.clickOnSettingsOption();
        settingsSteps.checkDurationSettingsAreDisplayed();
    }

    @Test(dependsOnMethods = "adjustSettings")
    public void changeWorkDuration() {
        settingsSteps.changeWorkDuration(newWorkDuration);
    }

    @Test (dependsOnMethods = "changeWorkDuration")
    public void changeBreakDuration(){
        settingsSteps.changeBreakDuration(newBreakDuration);
    }


    @AfterSuite
    public void stopAppiumServer() {
        driver.pressKeyCode(AndroidKeyCode.HOME);
        configuration.stopAppiumServer();
    }
}
