package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.lv.Un;
import utils.reusableFunctions;

public class BookmarkPage {
     private AppiumDriver driver;
	  reusableFunctions actions;



private By bookmarkTab = AppiumBy.xpath("//android.widget.TextView[@text=\"BOOKMARKS\"]");

////android.widget.TextView[@resource-id="free.rm.skytube.oss:id/title" and @text="Bookmark"]
      
private By bookmarkButton = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Bookmark\"]");
////android.widget.TextView[@resource-id="free.rm.skytube.oss:id/title" and @text="Unbookmark"]
private By unBookmarkButton = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Unbookmark\"]");

private By bookmarkToast = AppiumBy.xpath("//android.widget.Toast[contains(@text, 'Bookmarked')]");
private By unBookmarkToast = AppiumBy.xpath("//android.widget.Toast[@text=\"Unbookmarked\"]");
private By back = AppiumBy.accessibilityId("Navigate up");
private By noBookmarkedVideosText = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/noBookmarkedVideosText\"]");
private By threeDots = AppiumBy.xpath("(//android.widget.ImageButton[@resource-id=\"free.rm.skytube.oss:id/options_button\"])[1]");
////android.widget.ImageButton[@resource-id="free.rm.skytube.oss:id/options_button"]
private By bookmarkDots = AppiumBy.xpath("//android.widget.ImageButton[@resource-id=\"free.rm.skytube.oss:id/options_button\"]");
////android.widget.TextView[@resource-id="free.rm.skytube.oss:id/title" and @text="Unbookmark"]
private By UnbookmarkInTab = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Unbookmark\"]");  

public BookmarkPage(AppiumDriver driver) {
	        this.driver = driver;
	  actions = new reusableFunctions(driver, 30);// Pass driver to LoginPage
	 	   
	    }
    



public void clickBookmarkTab() {
    driver.findElement(bookmarkTab).click();
}

public String getNoBookmarkedVideosText() {
    return actions.getTextFromElement(noBookmarkedVideosText);
}

public void clickThreeDots() {
	
    driver.findElement(threeDots).click();
}


public String getBookmark() {
    return actions.getTextFromElement(bookmarkButton);
}

public void clickBookmarkButton() {
    driver.findElement(bookmarkButton).click();
}



public String getUnbookmark() {
    //waitForElementVisible(unBookmarkButton);
    return actions.waitForElementPresence(unBookmarkButton).getText();
    
}




public String getBookmarkButton() {
    return actions.getTextFromElement(bookmarkButton);
}

public String getUnbookmarkButton() {
    return actions.getTextFromElement(unBookmarkButton);
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
public void clickBookmarkDots() {
    driver.findElement(bookmarkDots).click();
    
}

public void clickUnbookmarkInTab() {
    driver.findElement(UnbookmarkInTab).click();
   
}




public void clickBack() {
    driver.findElement(back).click();
}

    
   
    
  
    }
   
