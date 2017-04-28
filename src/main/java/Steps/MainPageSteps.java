package Steps;

import Elements.MainPageElements;
import io.appium.java_client.android.AndroidDriver;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mlanina on 27/04/17.
 */
public class MainPageSteps {

    MainPageElements mainPageElements;
    AndroidDriver driver;

    public static Logger LOG = Logger.getLogger(MainPageSteps.class.getName());

    public MainPageSteps(AndroidDriver driver) {
        this.mainPageElements = new MainPageElements(driver);
        this.driver = driver;
    }


    @Step(value = "Verify all the elements are displayed on the main page")
    public void checkMainPageEementsAreDisplayed(){
        assertThat("BrainFocus label is not displayed", mainPageElements.getLabel().isDisplayed());
        assertThat("StartButton is not displayed", mainPageElements.getStartButton().isDisplayed());
        assertThat("BreakButton is not displayed", mainPageElements.getBreakButton().isDisplayed());
        assertThat("ProgressView is not displayed", mainPageElements.getProgressCircle().isDisplayed());
        assertThat("Minutes count is not 25", mainPageElements.getMinutes().getText().equals("25"));
        assertThat("Seconds count is not 00", mainPageElements.getSeconds().getText().equals("00"));
        assertThat("BrainViews are not displayed", mainPageElements.getBrainView().isDisplayed());
    }

    @Step(value = "Click on Start button")
    public void clickOnStartButton(){
        mainPageElements.getStartButton().click();
    }

    @Step(value = "Click on Break button")
    public void clickOnBreakButton(){
        mainPageElements.getBreakButton().click();
    }

    @Step(value = "Click on Pause button")
    public void clickOnPauseButton(){
        mainPageElements.getPauseButton().click();
    }

    @Step(value = "Click on Resume button")
    public void clickOnResumeButton(){
        mainPageElements.getResumeButton().click();
    }

    @Step(value = "Click on SkipBreak button")
    public void clickOnSkipBreakButton(){
        mainPageElements.getSkipBreakButton().click();
    }

    @Step(value = "Click on Stop button")
    public void clickOnStopButton(){
        mainPageElements.getStopButton().click();
    }

    @Step (value = "Verify number of minutes has increased after clicking PlusOne button")
    public void checkMinutesNumberIncreased(){
        int currentMinuteValue = Integer.valueOf(mainPageElements.getMinutes().getText());
        mainPageElements.getPlusOneButton().click();
        int minuteValueAfterClick = Integer.valueOf(mainPageElements.getMinutes().getText());
        int dif = minuteValueAfterClick - currentMinuteValue;
        assertThat("Number of minutes hasn't increased", dif == 1);
    }

    @Step(value = "Verify all the elements are displayed after the session starts")
    public void checkElementsArePresentAfterSessionStarts(){
        assertThat("SkipBreak button is not displayed", mainPageElements.getSkipBreakButton().isDisplayed());
        assertThat("Pause button is not displayed", mainPageElements.getPauseButton().isDisplayed());
        assertThat("Stop button is not displayed", mainPageElements.getStopButton().isDisplayed());
        assertThat("PlusOne button is not displayed", mainPageElements.getPlusOneButton().isDisplayed());
        assertThat("ProgressView is not displayed", mainPageElements.getProgressCircle().isDisplayed());
    }

    @Step(value = "Verify work session started")
      public void checkWorkSessionStarted(){
        assertThat("The countdown has not started", Integer.valueOf(mainPageElements.getMinutes().getText()) < 25);
    }

    @Step(value = "Verify break started")
    public void checkBreakStarted(){
        assertThat("The countdown has not started", Integer.valueOf(mainPageElements.getMinutes().getText()) < 5);
    }

    @Step(value = "Verify all the elements are displayed after clicking on Pause Button")
    public void checkElementsAfterClickingOnPause(){
        assertThat("Resume button is not displayed", mainPageElements.getResumeButton().isDisplayed());
        assertThat("SkipBreak button is not displayed", mainPageElements.getSkipBreakButton().isDisplayed());
        assertThat("Stop button is not displayed", mainPageElements.getStopButton().isDisplayed());
    }
}
