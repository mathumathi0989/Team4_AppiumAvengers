package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import context.TestContext;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import utils.reusableFunctions;

public class SearchPage {
	 private AppiumDriver driver;
	  reusableFunctions actions;
 
	  
	  private By search = AppiumBy.accessibilityId("Search Videos");
	  private By enterSearch = AppiumBy.xpath("//android.widget.AutoCompleteTextView[@resource-id=\"free.rm.skytube.oss:id/search_src_text\"]");
	  private By threeDots = AppiumBy.xpath("(//android.widget.ImageButton[@resource-id=\"free.rm.skytube.oss:id/options_button\"])[1]");
	  private By channel = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Channel...\"]");
	  private By openChannel = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Open Channel\"]");
	  private By skyTubeNotificationAlert = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button");
 
	  //private By searchlist=AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"free.rm.skytube.oss:id/thumbnail_image_view\").instance(0)");
	  
	  private By searchList=AppiumBy.id("free.rm.skytube.oss:id/thumbnail_image_view");
	  private By firstThumbnail = AppiumBy.xpath(
			    "(//androidx.recyclerview.widget.RecyclerView" +
			    "//android.widget.ImageView[@resource-id='free.rm.skytube.oss:id/thumbnail_image_view'])[1]"
			);

     // private By channelTitle=AppiumBy.id("free.rm.skytube.oss:id/actionbarTitle");
	  private By channelTitle=AppiumBy.xpath("//android.widget.TextView[@text=\"National Geographic\"]");
  
	    public SearchPage(AppiumDriver driver) {
	        this.driver = driver;
	      actions = new reusableFunctions(driver, 30);
	    }

	    public boolean searchDisplayed() throws Exception
	    {
	    	Thread.sleep(2000);
	    	return driver.findElement(search).isDisplayed();
	    }
	    
	    public void enterSearch(String searchText) {
	    	driver.findElement(search).click();
	    	driver.findElement(enterSearch).sendKeys(searchText);
	    	  // Cast WebDriver to AndroidDriver to access pressKey
	        AndroidDriver androidDriver = (AndroidDriver) driver;
	        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
	    }
	    
	    public void clickThreeDots() {
	    	driver.findElement(threeDots).click();
	    }
	    
	    public void clickChannel() {
	    	driver.findElement(channel).click();
	    }
	    
	    public void clickOpenChannel() {
	    	driver.findElement(openChannel).click();
	    }
	    public void clickSearchTab() {
	    	driver.findElement(search).click();
	    	
	    }
	    public void emptySearch()
	    {
	    	driver.findElement(search).click();
	        AndroidDriver androidDriver = (AndroidDriver) driver;
	        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
	    }
	    
	    public void getAlertNotification() {
	    	driver.findElement(skyTubeNotificationAlert).click();
	    }

		public boolean isSearchResultDisplayed() {
			actions.waitForElementVisible(searchList);
			return driver.findElement(searchList).isDisplayed();
					
		}
		
		public boolean isValidationMessageDisplayed(String expectedMessage) {
		    try {
		        String actual = driver.findElement(By.id("validation_message_id")).getText();
		        return actual.equals(expectedMessage);
		    } catch (NoSuchElementException e) {
		        return false;
		    }
		}
		public void clickfirstResult()
		{
		driver.findElement(firstThumbnail).click();
		}
	   
		public void searchTabVisible() {
			
			driver.findElement(search).isDisplayed();
		}
		public void getChannelTitle() throws Exception
		{	
			
//			try {
//		    	driver.findElement(firstThumbnail).click();
//		    	System.out.println("clicked channel");
//		    	}
//		    	catch(Exception e){
//		    		
//		    	}
//			TestContext testContext = new TestContext();
//			try {
//				
//    	    	testContext.getTrendingPage().getAlertNotification();
//    	    	testContext.getvideoPage().clickskipButton();
//    	    	
//    	    	
//    	    	}
//    	    	catch(Exception e) {}
//			
//			testContext.getSubscribePage().clickBack();
			//actions.waitForElementVisible(channelTitle);
			String channelTit=driver.findElement(channelTitle).getText();
	    	System.out.println("Title of the page is " + channelTit);
			 
	
		}
		
		
		public boolean isNetworkErrorMessageShown() {
		    try {
		        WebElement toast = driver.findElement(By.xpath("//android.widget.Toast[contains(@text, 'No internet connection available')]"));
		        return toast.isDisplayed();
		    } catch (NoSuchElementException e) {
		        return false;
		    }
		}
}
