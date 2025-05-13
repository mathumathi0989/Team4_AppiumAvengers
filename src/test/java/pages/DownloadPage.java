package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.reusableFunctions;

import java.time.Duration;

public class DownloadPage {

    private final AppiumDriver driver;
    private final reusableFunctions util;

    // Constructor
    public DownloadPage(AppiumDriver driver) {
        this.driver = driver;
        this.util = new reusableFunctions(driver, 10);  // default 10s timeout
    }

    // Locators
    private final By changelogOkButton = By.id("android:id/button3");
   // private final By denyNotification = By.id("com.android.permissioncontroller:id/permission_deny_button");
    private final By threeDots = AppiumBy.xpath("(//android.widget.ImageButton[@resource-id=\"free.rm.skytube.oss:id/options_button\"])[1]");
    private final By download = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Download\"]");
    private final By allowDownload = By.id("com.android.permissioncontroller:id/permission_allow_button");
    private final By deleteDownload = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Delete Download\"]");
    private final By downloadTab = AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Downloads\"]");
    private final By grandTheftTitle = By.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title_text_view\"]");
    private final By anyVideo = By.xpath("(//android.widget.FrameLayout)[1]");
//free.rm.skytube.oss:id/noDownloadedVideosText= download some videos
    private final By noDownloadedVideosText = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/noDownloadedVideosText\"]");
    ////android.widget.TextView[@resource-id="free.rm.skytube.oss:id/title" and @text="Download"]
    /// //android.widget.ImageButton[@resource-id="free.rm.skytube.oss:id/options_button"]
private final By ThreeDotsInDownloadedTab = AppiumBy.xpath("//android.widget.ImageButton[@resource-id=\"free.rm.skytube.oss:id/options_button\"]");
//	
//android.widget.TextView[@resource-id="free.rm.skytube.oss:id/title" and @text="Delete Download"]

    private final By deleteDownloadInDownloadedTab = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Delete Download\"]");
    // Actions

    public void clickThreeDotsForDownload() {
        util.clickElement(threeDots);
    }
    public String getDownloadText() {
        util.waitForElementVisible(download);  // Use your utility
        return driver.findElement(download).getText();
    }
    public String getDeleteDownloadText() {
        util.waitForElementVisible(deleteDownload);  // Use your utility
        return driver.findElement(deleteDownload).getText();
    }


    public boolean isDownloadOptionVisible() {
        try {
            util.waitForElementVisible(download);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickDownload() {
        util.clickElement(download);
    }

    public void clickAllowDownload() {
        util.clickElement(allowDownload);
    }
    public void clickAllowDownloadIfPresent() {
        By allowButtonLocator = By.id("com.android.permissioncontroller:id/permission_allow_button");
        try {
            WebElement allowButton = util.waitForElementVisible(allowButtonLocator);
            allowButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            // Permission dialog didn't appear, log the event and continue
            System.out.println("Permission dialog did not appear.");
        }
    }
    public void allowToAccessIfPresent() {
        By allowPermissionXPath = By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]");
        try {
            if (!driver.findElements(allowPermissionXPath).isEmpty()) {
                util.clickElement(allowPermissionXPath);
                System.out.println("Allow access button clicked.");
            } else {
                System.out.println("Allow access button not found.");
            }
        } catch (Exception e) {
            System.out.println("Error clicking allow access button: " + e.getMessage());
        }
    }

    public void clickDeleteDownload() {
        util.clickElement(deleteDownload);
    }

    public boolean isDeleteDownloadOptionVisible() {
        try {
            return util.waitForElementVisible(deleteDownload).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
  public void clickDeleteDownloadInDownloadedTab() {
        util.clickElement(deleteDownloadInDownloadedTab);
    }
    public void clickThreeDotsInDownloadedTab() {
        util.clickElement(ThreeDotsInDownloadedTab);
    }
    public void clickDownloadTab() {
        util.clickElement(downloadTab);
    }

    public String getNoDownloadedVideosText() {
        return util.getTextFromElement(noDownloadedVideosText);
    }

    public String getGrandTheftTitle() {
        return util.getTextFromElement(grandTheftTitle);
    }

    public void clickVideo() {
        util.clickElement(anyVideo);
    }

    public boolean waitForToastMessage(String partialText) {
        try {
            By toastLocator = By.xpath("//android.widget.Toast[contains(@text, '" + partialText + "')]");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator)) != null;
        } catch (Exception e) {
            return false;
        }
    }


    // Popup Handling

    public void dismissNotificationPopupIfPresent() {
        By denyNotificationXPath = By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_button']");
        try {
            if (!driver.findElements(denyNotificationXPath).isEmpty()) {
                util.clickElement(denyNotificationXPath);
                System.out.println("Notification permission popup dismissed.");
            }
        } catch (Exception e) {
            System.out.println("Notification popup not found or could not be dismissed.");
        }
    }

    public void dismissSecondaryPermissionPopupIfPresent() {
        By allowPermissionXPath = By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]");
        try {
            if (!driver.findElements(allowPermissionXPath).isEmpty()) {
                util.clickElement(allowPermissionXPath);
                System.out.println("Secondary permission popup dismissed.");
            }
        } catch (Exception e) {
            System.out.println("Secondary permission popup not found or could not be dismissed.");
        }
    }


    public void dismissChangelogPopupIfPresent() {
        try {
            if (!driver.findElements(changelogOkButton).isEmpty()) {
                util.clickElement(changelogOkButton);
                System.out.println("Dismissed changelog popup.");
            }
        } catch (Exception e) {
            System.out.println("No changelog popup to dismiss.");
        }
    }

    public void dismissStartupPopupsIfPresent() {
        dismissNotificationPopupIfPresent();
        dismissSecondaryPermissionPopupIfPresent();
        dismissChangelogPopupIfPresent();
    }
}
