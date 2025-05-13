package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import utils.reusableFunctions;

public class BookmarkPage {
    private AppiumDriver driver;
    reusableFunctions actions;

    public BookmarkPage(AppiumDriver driver) {
        this.driver = driver;
        actions = new reusableFunctions(driver, 30);// Pass driver to LoginPage

    }



    private By bookmarkTab = AppiumBy.xpath("//android.widget.TextView[@text=\"BOOKMARKS\"]");
    private By bookmarkLink = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Bookmark\"]");
    private By unBookmarkLink = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Unbookmark\"]");
    private By bookmarkButton = AppiumBy.id("free.rm.skytube.oss:id/channel_bookmark_button");
    private By unBookmarkButton = AppiumBy.id("free.rm.skytube.oss:id/channel_bookmark_button");
    private By bookmarkToast = AppiumBy.xpath("//android.widget.Toast[contains(@text, 'Bookmarked')]");
    private By unBookmarkToast = AppiumBy.xpath("//android.widget.Toast[@text=\"Unbookmarked\"]");
    private By back = AppiumBy.accessibilityId("Navigate up");
    private By noBookmarkedVideosText = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/noBookmarkedVideosText\"]");
    private By threeDots = AppiumBy.xpath("(//android.widget.ImageButton[@resource-id=\"free.rm.skytube.oss:id/options_button\"])[1]");



    public void clickBookmarkTab() {
        driver.findElement(bookmarkTab).click();
    }



    public void clickThreeDots() {
        driver.findElement(threeDots).click();
    }

    public String clickBookmarkLink () {
        driver.findElement(bookmarkLink).click();
        return actions.getTextFromElement(bookmarkToast);
    }
    public String clickUnbookmarkLink () {
        driver.findElement(unBookmarkLink).click();
        return actions.getTextFromElement(unBookmarkToast);
    }

    public String getNoBookmarkedVideosText() {
        return actions.getTextFromElement(noBookmarkedVideosText);
    }

    public String getBookmark() {
        return actions.getTextFromElement(bookmarkLink);
    }

    public String getUnbookmark() {
        return actions.getTextFromElement(unBookmarkLink);
    }




    public String getBookmarkButton() {
        return actions.getTextFromElement(bookmarkButton);
    }

    public String getUnbookmarkButton() {
        return actions.getTextFromElement(unBookmarkButton);
    }

    public void clickBookmarkButton() {
        driver.findElement(bookmarkButton).click();
    }

    public void clickUnbookmarkButton() {
        driver.findElement(unBookmarkButton).click();
    }

    public WebElement verifyToastPresence() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement toast = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.widget.Toast")
        ));
        return toast;
    }

    public void clickBack() {
        driver.findElement(back).click();
    }





}

