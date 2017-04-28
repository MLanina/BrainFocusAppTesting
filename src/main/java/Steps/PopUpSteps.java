package Steps;

import Elements.MainPageElements;
import Elements.PopUpElements;
import Elements.SettingsElements;
import Elements.WelcomeSlidesElements;
import io.appium.java_client.android.AndroidDriver;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mlanina on 27/04/17.
 */
public class PopUpSteps {

    PopUpElements popUpElements;
    AndroidDriver driver;

    public static Logger LOG = Logger.getLogger(PopUpSteps.class.getName());

    public PopUpSteps(AndroidDriver driver) {
        this.popUpElements = new PopUpElements(driver);
        this.driver = driver;
    }

    @Step(value = "Verify all the elements are displayed in Pop Up")
    public void verifyElementsInPopUp(){
        assertThat("OK button is not displayed", popUpElements.getOkButton().isDisplayed());
        assertThat("Cancel button is not displayed", popUpElements.getCancelButton().isDisplayed());
        assertThat("Question message is not displayed", popUpElements.getQuestion().isDisplayed());
    }

    @Step(value = "Click on OK button")
    public void clickOnOKButton(){
        popUpElements.getOkButton().click();
    }

    @Step(value = "Click on Cancel button")
    public void clickOnCancelButton(){
        popUpElements.getCancelButton().click();
    }

}
