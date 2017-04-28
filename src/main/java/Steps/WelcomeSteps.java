package Steps;

import Elements.WelcomeSlidesElements;
import io.appium.java_client.android.AndroidDriver;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mlanina on 27/04/17.
 */
public class WelcomeSteps {

    WelcomeSlidesElements welcomeSlidesElements;
    AndroidDriver driver;

    public static Logger LOG = Logger.getLogger(WelcomeSteps.class.getName());

    public WelcomeSteps(AndroidDriver driver) {
        this.welcomeSlidesElements = new WelcomeSlidesElements(driver);
        this.driver = driver;
    }

    @Step(value = "Check all the elements are present on the first slide")
    public void checkFirstSlideElementsArePresent(){
        assertThat("Logo element is not displayed on first slide", welcomeSlidesElements.getLogo().isDisplayed());
        assertThat("Major greeting line has incorrect text", welcomeSlidesElements.getMessages().get(0).getText().equals("Work Smarter"));
        assertThat("First greeting line has incorrect text on first slide", welcomeSlidesElements.getMessages().get(1).getText().equals("Stop procrastinating! Do more faster!"));
        assertThat("Second greeting line has incorrect text on first slide", welcomeSlidesElements.getMessages().get(2).getText().equals("This application will help you improve your productivity."));
        assertThat("Forward circle button is not displayed on first slide", welcomeSlidesElements.getForwardButtonCircle().isDisplayed());
    }

    @Step(value = "Check all the elements are present on the second slide")
    public void checkSecondSlideElementsArePresent(){
        assertThat("Logo element is not displayed on second slide", welcomeSlidesElements.getLogo().isDisplayed());
        assertThat("First greeting line has incorrect text on second slide", welcomeSlidesElements.getMessages().get(0).getText().equals("First step : Start a work session"));
        assertThat("Second greeting line has incorrect text on second slide", welcomeSlidesElements.getMessages().get(1).getText().equals("Work on a project, study, do whatever work you want."));
        assertThat("Forward circle button is not displayed on second slide", welcomeSlidesElements.getForwardButtonCircle().isDisplayed());
        assertThat("Backward circle button is not displayed on second slide", welcomeSlidesElements.getBackwardButtonCircle().isDisplayed());
    }

    @Step(value = "Check all the elements are present on the third slide")
    public void checkThirdSlideElementsArePresent(){
        assertThat("Logo element is not displayed on third slide", welcomeSlidesElements.getLogo().isDisplayed());
        assertThat("First line has incorrect text on third slide", welcomeSlidesElements.getMessages().get(0).getText().equals("Second step : Take a break"));
        assertThat("Second line has incorrect text on third slide", welcomeSlidesElements.getMessages().get(1).getText().equals("Relax, stand up, walk, go grab water, do whatever you want. Then start a new work session."));
        assertThat("Forward circle button is not displayed on third slide", welcomeSlidesElements.getForwardButtonCircle().isDisplayed());
        assertThat("Backward circle button is not displayed on third slide", welcomeSlidesElements.getBackwardButtonCircle().isDisplayed());
    }

    @Step(value = "Check all the elements are present on the fourth slide")
    public void checkFourthSlideElementsArePresent(){
        assertThat("Logo element is not displayed on fourth slide", welcomeSlidesElements.getLogo().isDisplayed());
        assertThat("First line has incorrect text on fourth slide", welcomeSlidesElements.getMessages().get(0).getText().equals("After 4 work sessions, it is time for a longer break!"));
        assertThat("Second line has incorrect text on fourth slide", welcomeSlidesElements.getMessages().get(1).getText().equals("Go walk outside, grab something to eat or take a nap."));
        assertThat("Forward circle button is not displayed on fourth slide", welcomeSlidesElements.getForwardButtonCircle().isDisplayed());
        assertThat("Backward circle button is not displayed on fourth slide", welcomeSlidesElements.getBackwardButtonCircle().isDisplayed());
    }

    @Step(value = "Check all the elements are present on the fifth slide")
    public void checkFifthSlideElementsArePresent(){
        assertThat("Logo element is not displayed on fifth slide", welcomeSlidesElements.getLogo().isDisplayed());
        assertThat("First line has incorrect text on fifth slide", welcomeSlidesElements.getMessages().get(0).getText().equals("Customizable"));
        assertThat("Second line has incorrect text on fifth slide", welcomeSlidesElements.getMessages().get(1).getText().equals("Tweak the application until you reach the best work vs break ratio for you."));
        assertThat("Forward circle button is not displayed on fifth slide", welcomeSlidesElements.getForwardButtonCircle().isDisplayed());
        assertThat("Backward circle button is not displayed on fifth slide", welcomeSlidesElements.getBackwardButtonCircle().isDisplayed());
    }

    @Step(value = "Check all the elements are present on the last slide")
    public void checlLastSlideElementsArePresent(){
        assertThat("Options number is not equal to 7", welcomeSlidesElements.getMessages().size() == 7);
        assertThat("Headline has unexpected text", welcomeSlidesElements.getMessages().get(0).getText().equals("Timer Controls"));
        assertThat("First line has incorrect option", welcomeSlidesElements.getMessages().get(1).getText().equals("Start a work session"));
        assertThat("Second line has incorrect option", welcomeSlidesElements.getMessages().get(2).getText().equals("Start a break session"));
        assertThat("Third line has incorrect option", welcomeSlidesElements.getMessages().get(3).getText().equals("Stop session"));
        assertThat("Fourth line has incorrect option", welcomeSlidesElements.getMessages().get(4).getText().equals("Pause a session"));
        assertThat("Fifth line has incorrect option", welcomeSlidesElements.getMessages().get(5).getText().equals("Resume a session"));
        assertThat("Sixth line has incorrect option", welcomeSlidesElements.getMessages().get(6).getText().equals("Skip a session"));
        assertThat("DoneButton is not displayed", welcomeSlidesElements.getDoneButton().isDisplayed());
        assertThat("Backward circle button is not displayed on sixth slide", welcomeSlidesElements.getBackwardButtonCircle().isDisplayed());
    }

    @Step(value = "Click on forward button")
    public void clickOnForwardButton(){
        welcomeSlidesElements.getForwardButtonCircle().click();
    }

    @Step(value = "Click on backward button")
    public void clickOnBackwardButton(){
        welcomeSlidesElements.getBackwardButtonCircle().click();
    }

    @Step(value = "Click on Done button")
    public void clickOnDoneButton(){
        welcomeSlidesElements.getDoneButton().click();
    }

}
