package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import utils.reusableFunctions;

public class PreferencesPage {
    
    private AppiumDriver driver;
    private reusableFunctions actions;


    
   
    private By menu = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"More options\"]");

   
    private By preferences = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Preferences\"]");
    private By permissionMessage = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.android.permissioncontroller:id/permission_message\"]");


    private By allowButton = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button");
   
    private By denyButton = AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button");
   
    private By preferencesText = AppiumBy.xpath("//android.widget.TextView[@text=\"Preferences\"]");
   
    public By videoPlayerText = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Video Player\"]");
    
    public By videoBlockerText = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Video Blocker\"]");
   
    public By sponsorBlockText = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"SponsorBlock\"]");
    
    public By importExportText = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Import/Export\"]");
  

    public By privacyText = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Privacy\"]");
   
  
    public By networkAndDownloadsText = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Network and Downloads\"]");

    public By othersText = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Others\"]");
   
    public By aboutText = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"About\"]");


    public PreferencesPage(AppiumDriver driver) {
	        this.driver = driver;
	  actions = new reusableFunctions(driver, 30);// Pass driver to LoginPage
	 	   
	    }



public void clickMenu() {
    driver.findElement(menu).click();
}
public void clickPreferences() {
    driver.findElement(preferences).click();    
}
public String getPreferencesText() {
	actions.waitForElementVisible(preferences);
    return actions.getTextFromElement(preferences);
}

public boolean isOnPreferencesPage() {
   
    return driver.findElement(preferencesText).isDisplayed();
}

public boolean isVideoPlayerPresent() {
    return driver.findElement(videoPlayerText).isDisplayed();
}

public boolean isVideoBlockerPresent() {
    return driver.findElement(videoBlockerText).isDisplayed();
}

public boolean isSponsorBlockPresent() {
    return driver.findElement(sponsorBlockText).isDisplayed();
}

public boolean isImportExportPresent() {
    return driver.findElement(importExportText).isDisplayed();
}

public boolean isPrivacyPresent() {
    return driver.findElement(privacyText).isDisplayed();
}

public boolean isNetworkAndDownloadsPresent() {
    return driver.findElement(networkAndDownloadsText).isDisplayed();
}

public boolean isOthersPresent() {
    return driver.findElement(othersText).isDisplayed();
}

public boolean isAboutPresent() {
    return driver.findElement(aboutText).isDisplayed();
}

public boolean isPreferenceOptionVisible(By element) {
    return driver.findElement(element).isDisplayed();
}



    // Check if popup is present
    public boolean isPermissionPopupDisplayed() {
        return !driver.findElements(permissionMessage).isEmpty();
    }

    // Handle popup with allow
    public void handlePermissionAllowIfPresent() {
        if (isPermissionPopupDisplayed()) {
            try {
                driver.findElement(allowButton).click();
                System.out.println("Permission popup handled with ALLOW");
            } catch (Exception e) {
                System.out.println("Failed to click ALLOW: " + e.getMessage());
            }
        } else {
            System.out.println("Permission popup not displayed.");
        }
    }


    public void tapOnOption(String optionText) {

        String xpath = "//android.widget.TextView[@text='" + optionText + "']";
        actions.waitForElementVisible(By.xpath(xpath));
        driver.findElement(By.xpath(xpath)).click();

    }
 
    public boolean isDialogTitleVisible(String titleText) {

        String xpath = "//android.widget.TextView[@text='" + titleText + "']";

        return driver.findElement(By.xpath(xpath)).isDisplayed();

    }
 
    public boolean isRadioOptionSelected(String radioText) {

        // XPath for selected default option

        String xpath = "//android.widget.TextView[@resource-id='android:id/summary' and @text='Video player to use: " + radioText + "']";

        WebElement element = driver.findElement(By.xpath(xpath));

        return element != null && element.isDisplayed();

    }
 
private By screenOrientationLabel = By.xpath("//android.widget.TextView[@text='Screen Orientation']");
private String summaryPrefix = "Video player orientation: ";
public By getOrientationSummary(String optionText) {    return By.xpath("//android.widget.TextView[@resource-id='android:id/summary' and @text='" + summaryPrefix + optionText + "']");}public By getOrientationDialogOption(String optionText) {    return By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='" + optionText + "']");}
 
//Method for Screen Orientation 
public void tapOnScreenOrientation() {

    driver.findElement(screenOrientationLabel).click();

}
 
public boolean isScreenOrientationSetTo(String orientation) {

    try {

        return driver.findElement(getOrientationSummary(orientation)).isDisplayed();

    } catch (Exception e) {

        return false;

    }

}
 
public void selectScreenOrientationOption(String optionText) {

    driver.findElement(getOrientationDialogOption(optionText)).click();

}

 


    
}
