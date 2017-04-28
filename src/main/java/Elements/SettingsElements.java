package Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by mlanina on 27/04/17.
 */
public class SettingsElements {
    WebDriver webDriver;

    public SettingsElements(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "android.widget.ImageView")
    private List<WebElement> settings;

    @FindBy(id = "com.AT.PomodoroTimer:id/title")
    private List<WebElement> settingList;

    @FindBy(xpath = "//android.widget.TextView[@text='Work Duration']")
    private WebElement workDurationLabel;

    @FindBy(xpath = "//android.widget.TextView[@text='Break Duration']")
    private WebElement breakDurationLabel;

    @FindBy(id = "com.AT.PomodoroTimer:id/WorkDurationTextView")
    private WebElement workDurationValue;

    @FindBy(id = "com.AT.PomodoroTimer:id/breakDurationTextView")
    private WebElement breakDurationValue;

    @FindBy(id = "com.AT.PomodoroTimer:id/alertTitle")
    private WebElement sessionDurationAlert;

    @FindBy(className = "android.widget.EditText")
    private WebElement editSessionDuration;

    @FindBy(id = "android:id/button1")
    private WebElement okButton;

    @FindBy(id = "android:id/button2")
    private WebElement cancelButton;

    @FindBy(className = "android.widget.ImageButton")
    private WebElement backButton;


    public List<WebElement> getSettings(){
        return settings;
    }

    public List<WebElement> getSettingList(){
        return settingList;
    }

    public WebElement getWorkDurationLabel(){
        return workDurationLabel;
    }

    public WebElement getBreakDurationLabel(){
        return breakDurationLabel;
    }

    public WebElement getBreakDurationValue(){
        return breakDurationValue;
    }

    public WebElement getWorkDurationValue(){
        return workDurationValue;
    }

    public WebElement getSessionDurationAlert() {return sessionDurationAlert; }

    public WebElement getEditSessionDuration() {return editSessionDuration; }

    public WebElement getOkButton() {return okButton; }

    public WebElement getCancelButton() {return cancelButton; }

    public WebElement getBackButton() {return backButton; }

}
