package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.List;

import org.testng.Assert;
import context.TestContext;

public class PreferencesSteps {

    private TestContext testContext;

    public PreferencesSteps(TestContext context) {
        this.testContext = context;
    }

    @When("User click on three dots in top right page1")
    public void user_click_on_three_dots_in_top_right_page() {
        testContext.getPreferencesPage().clickMenu();
      
    }

    @Then("User should see the preferences option")
    public void user_should_see_the_preferences_option() {
        testContext.getPreferencesPage().getPreferencesText();
        String expectedText = testContext.getPreferencesPage().getPreferencesText();
        System.out.println("Preferences text: " + expectedText);
        Assert.assertTrue(expectedText.contains("Preferences")); // Replace with actual verification logic
        
    }

    @When("User click on preferences option")
    public void user_click_on_preferences_option() {
        testContext.getPreferencesPage().clickPreferences();
        testContext.getPreferencesPage().handlePermissionAllowIfPresent();
       
    }

    @Then("User should be on preferences page")
    public void user_should_be_on_preferences_page() {
        testContext.getPreferencesPage().isOnPreferencesPage();
        
    }

    @Then("User should see the following buttons present:")

    public void user_should_see_buttons_present(io.cucumber.datatable.DataTable dataTable) {
    
        List<String> buttonLabels = dataTable.asList();
     
        for (String label : buttonLabels) {
    
            boolean isDisplayed;
    
            switch (label.trim()) {
    
                case "Video Player":
    
                    isDisplayed = testContext.getPreferencesPage().isPreferenceOptionVisible(
    
                            testContext.getPreferencesPage().videoPlayerText); break;
    
                case "Video Blocker":
    
                    isDisplayed = testContext.getPreferencesPage().isPreferenceOptionVisible(
    
                            testContext.getPreferencesPage().videoBlockerText); break;
    
                case "SponsorBlock":
    
                    isDisplayed = testContext.getPreferencesPage().isPreferenceOptionVisible(
    
                            testContext.getPreferencesPage().sponsorBlockText); break;
    
                case "Import/Export":
    
                    isDisplayed = testContext.getPreferencesPage().isPreferenceOptionVisible(
    
                            testContext.getPreferencesPage().importExportText); break;
    
                case "Privacy":
    
                    isDisplayed = testContext.getPreferencesPage().isPreferenceOptionVisible(
    
                            testContext.getPreferencesPage().privacyText); break;
    
                case "Network and Downloads":
    
                    isDisplayed = testContext.getPreferencesPage().isPreferenceOptionVisible(
    
                            testContext.getPreferencesPage().networkAndDownloadsText); break;
    
                case "Others":
    
                    isDisplayed = testContext.getPreferencesPage().isPreferenceOptionVisible(
    
                            testContext.getPreferencesPage().othersText); break;
    
                case "About":
    
                    isDisplayed = testContext.getPreferencesPage().isPreferenceOptionVisible(
    
                            testContext.getPreferencesPage().aboutText); break;
    
                default:
    
                    throw new IllegalArgumentException("Unexpected button label: " + label);
    
            }
    
            Assert.assertTrue(isDisplayed, "Button not visible: " + label);
    
        }
    
    }
   
   @When("User taps on the {string} option")
public void user_taps_on_the_option(String optionText) {
    testContext.getPreferencesPage().tapOnOption(optionText);
}
 
@Then("A dialog with title {string} should appear")
public void dialog_with_title_should_appear(String titleText) {
    boolean visible = testContext.getPreferencesPage().isDialogTitleVisible(titleText);
    Assert.assertTrue(visible, "Dialog with title '" + titleText + "' is not visible.");
}
 
@Then("The radio option {string} should be selected")
public void the_radio_option_should_be_selected(String radioText) {
    boolean selected = testContext.getPreferencesPage().isRadioOptionSelected(radioText);
    Assert.assertTrue(selected, "Radio option '" + radioText + "' is not selected.");
}

@When("User taps on the Screen Orientation option")
public void user_taps_on_screen_orientation_option() {
    testContext.getPreferencesPage().tapOnScreenOrientation();
}
 
@When("User selects {string} from the orientation dialog")
public void user_selects_from_orientation_dialog(String option) {
    testContext.getPreferencesPage().selectScreenOrientationOption(option);
}
 
@Then("The orientation value should be set to {string}")
public void the_orientation_value_should_be_set_to(String option) {
    Assert.assertTrue(testContext.getPreferencesPage().isScreenOrientationSetTo(option),
        "Orientation is not set to: " + option);
}

     
        }
    
       
       
        
