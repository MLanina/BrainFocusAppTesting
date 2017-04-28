package Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mlanina on 27/04/17.
 */
public class MainPageElements {
    WebDriver webDriver;

    public MainPageElements(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.AT.PomodoroTimer:id/StartButton")
    private WebElement startButton;

    @FindBy(id = "com.AT.PomodoroTimer:id/BreakButton")
    private WebElement breakButton;

    @FindBy(id = "com.AT.PomodoroTimer:id/progressView")
    private WebElement progressView;

    @FindBy(id = "com.AT.PomodoroTimer:id/progressView")
    private WebElement progressCircle;

    @FindBy(id = "com.AT.PomodoroTimer:id/CounterMinTextView")
    private WebElement minutes;

    @FindBy(id = "com.AT.PomodoroTimer:id/CounterSecondsTextView")
    private WebElement seconds;

    @FindBy(id = "com.AT.PomodoroTimer:id/pomodoroCountProgressLinearLayout")
    private WebElement brainView;

    @FindBy(id = "com.AT.PomodoroTimer:id/SkipBreakButton")
    private WebElement skipBreakButton;

    @FindBy(id = "com.AT.PomodoroTimer:id/PauseButton")
    private WebElement pauseButton;

    @FindBy(id = "com.AT.PomodoroTimer:id/StopButton")
    private WebElement stopButton;

    @FindBy(id = "com.AT.PomodoroTimer:id/PlusOneButton")
    private  WebElement plusOneButton;

    @FindBy(id = "com.AT.PomodoroTimer:id/ResumeButton")
    private  WebElement resumeButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Brain Focus']")
    private WebElement label;

    public WebElement getStartButton(){
        return startButton;
    }

    public WebElement getBreakButton(){
        return breakButton;
    }

    public WebElement getProgressCircle(){
        return progressCircle;
    }

    public WebElement getMinutes(){
        return minutes;
    }

    public WebElement getSeconds(){
        return seconds;
    }

    public WebElement getBrainView(){
        return brainView;
    }

    public WebElement getSkipBreakButton(){
        return skipBreakButton;
    }

    public WebElement getPauseButton(){
        return pauseButton;
    }

    public WebElement getStopButton(){
        return stopButton;
    }

    public WebElement getPlusOneButton(){
        return plusOneButton;
    }

    public WebElement getResumeButton(){
        return resumeButton;
    }

    public WebElement getLabel(){
        return label;
    }
}
