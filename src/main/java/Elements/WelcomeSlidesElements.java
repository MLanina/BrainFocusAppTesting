package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by mlanina on 24/04/17.
 */
public class WelcomeSlidesElements {
    WebDriver webDriver;

    public WelcomeSlidesElements(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "android.widget.FrameLayout")
    private WebElement logo;

    @FindBy(className="android.widget.TextView")
    private List<WebElement> messages;

    @FindBy(id = "com.AT.PomodoroTimer:id/forwardButtonCircle")
    private WebElement forwardButtonCircle;

    @FindBy(id = "com.AT.PomodoroTimer:id/backButtonCircle")
    private WebElement backwardButtonCircle;

    @FindBy(id = "com.AT.PomodoroTimer:id/doneButtonCircle")
    private WebElement doneButton;

    public WebElement getLogo() {
        return logo;
    }

    public List<WebElement> getMessages(){
        return messages;
    }

    public WebElement getForwardButtonCircle(){
        return forwardButtonCircle;
    }

    public WebElement getBackwardButtonCircle(){
        return backwardButtonCircle;
    }

    public WebElement getDoneButton(){
        return doneButton;
    }


}
