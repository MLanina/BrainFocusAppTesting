package Steps;

import Elements.SettingsElements;
import io.appium.java_client.android.AndroidDriver;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mlanina on 27/04/17.
 */
public class SettingsSteps {

    SettingsElements settingsElements;
    AndroidDriver driver;

    public static Logger LOG = Logger.getLogger(SettingsSteps.class.getName());

    public SettingsSteps(AndroidDriver driver) {
        this.settingsElements = new SettingsElements(driver);
        this.driver = driver;
    }

    @Step(value = "Click on Settings sign")
    public void clickOnSettings(){
        settingsElements.getSettings().get(0).click();
    }

    @Step(value = "Verify list of settings is correctly displayed")
    public void checkSettingListDisplay(){
        assertThat("Count of settings is not 6", settingsElements.getSettingList().size() == 6);
        assertThat("First settings is not Statistics", settingsElements.getSettingList().get(0).getText().equals("Statistics"));
        assertThat("Second settings is not Tasks", settingsElements.getSettingList().get(1).getText().equals("Tasks"));
        assertThat("Third settings is not Settings", settingsElements.getSettingList().get(2).getText().equals("Settings"));
        assertThat("Fourth setting is not Categories", settingsElements.getSettingList().get(3).getText().equals("Categories"));
        assertThat("Fifth setting is not Go Pro", settingsElements.getSettingList().get(4).getText().equals("Go Pro"));
        assertThat("Sixth setting is not About", settingsElements.getSettingList().get(5).getText().equals("About"));
    }

    @Step(value = "Check session duration settings are displayed")
    public void checkDurationSettingsAreDisplayed(){
        assertThat("Work duration message is not displayed", settingsElements.getWorkDurationLabel().isDisplayed());
        assertThat("BreakDuration message is not displayed", settingsElements.getBreakDurationLabel().isDisplayed());
        assertThat("WorkDuration is not 25 min by default ", Integer.valueOf(settingsElements.getWorkDurationValue().getText()) == 25);
        assertThat("BreakDuration is not 5 min by default ", Integer.valueOf(settingsElements.getBreakDurationValue().getText()) == 5);

    }

    @Step(value = "Click on Settings option")
    public void clickOnSettingsOption(){
        settingsElements.getSettingList().get(2).click();
    }

    @Step(value = "Change work duration")
    public void changeWorkDuration(String min){
        settingsElements.getWorkDurationValue().click();
        assertThat("Work duration alert is not correct", settingsElements.getSessionDurationAlert().getText().equals("Work Duration"));
        settingsElements.getEditSessionDuration().sendKeys(min);
        assertThat("OK button is not displayed", settingsElements.getOkButton().isDisplayed());
        assertThat("Cancel button is not displayed", settingsElements.getCancelButton().isDisplayed());
        settingsElements.getOkButton().click();
        assertThat("WorkDuration is not " + min +" min", settingsElements.getWorkDurationValue().getText().equals(min));
    }

    @Step (value = "Change break duration")
    public void changeBreakDuration(String min){
        settingsElements.getBreakDurationValue().click();
        assertThat("Break duration alert is not correct", settingsElements.getSessionDurationAlert().getText().equals("Break Duration"));
        settingsElements.getEditSessionDuration().sendKeys(min);
        assertThat("OK button is not displayed", settingsElements.getOkButton().isDisplayed());
        assertThat("Cancel button is not displayed", settingsElements.getCancelButton().isDisplayed());
        settingsElements.getOkButton().click();
        assertThat("BreakDuration is not " + min +" min", settingsElements.getBreakDurationValue().getText().equals(min));
    }
}
