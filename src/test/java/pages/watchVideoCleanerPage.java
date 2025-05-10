package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import utils.reusableFunctions;

public class watchVideoCleanerPage {
	 private AppiumDriver driver;
	  reusableFunctions actions;
	  private By bookmark = AppiumBy.androidUIAutomator("new UiSelector().text(\"Bookmark\")");
	  private By download = AppiumBy.androidUIAutomator("new UiSelector().text(\"Download\")");
	private By watchVideoCleaner = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Watched Video Cleaner\"]");
    private By watchedDownloads = AppiumBy.xpath("//android.widget.CheckBox[@resource-id=\"free.rm.skytube.oss:id/clean_watched_downloads\"]");
    private By watchedBookmarks = AppiumBy.xpath("//android.widget.CheckBox[@resource-id=\"free.rm.skytube.oss:id/clean_watched_bookmarks\"]");
    private By clean = AppiumBy.id("free.rm.skytube.oss:id/md_buttonDefaultPositive");
    private By cancel = AppiumBy.id("free.rm.skytube.oss:id/md_buttonDefaultNegative");
    private By bookmarksTab = AppiumBy.androidUIAutomator("new UiSelector().text(\"BOOKMARKS\")");
    private By allowPopup = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button");
   
	 public watchVideoCleanerPage(AppiumDriver driver) {
	        this.driver = driver;
	  actions = new reusableFunctions(driver, 30);// Pass driver to LoginPage
	 	   
	    }

	 public String getwatchVideoCleaner() {
		 return driver.findElement(watchVideoCleaner).getText();
	 }

	 public void enterWatchVideoCleaner() {
		  driver.findElement(watchVideoCleaner).click();;
	 }
	 
	 public void doBookmark() {
		 driver.findElement(bookmark).click();
	 }
	 
	 public void doDownload() {
		 driver.findElement(download).click();
	 }
	 
	 public void clickClean() {
		 actions.waitForElementVisible(clean);
		 driver.findElement(clean).click();
	 }
	 
	 public void isBookmark() {
		 driver.findElement(bookmarksTab).click();
		 
	 }
	 
	 public int getBookMarksNo() {
		 List<WebElement> gridItems = driver.findElements(By.id("free.rm.skytube.oss:id/grid_view"))
                 .get(0)
                 .findElements(By.className("android.view.ViewGroup"));
		 int count = gridItems.size();
		 System.out.println("Number of items: " + count);
		 return count;
	 }
	 
	 public void allowPop() throws Exception {
	
			 Thread.sleep(1000);
		
		 driver.findElement(allowPopup).click();
			
			 
			 try {
				 driver.findElement(allowPopup).click();
					 }
					 catch(Exception e2) {};
	
		 
	 }
}
