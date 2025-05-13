package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import utils.reusableFunctions;


public class TrendingPage {
	 private AppiumDriver driver;
	  reusableFunctions actions;
	  private By skyTubePageTitle = AppiumBy.xpath("//android.widget.TextView[@text=\"SkyTube\"]");
	  private By search = AppiumBy.accessibilityId("Search Videos");
	  private By enterSearch = AppiumBy.xpath("//android.widget.AutoCompleteTextView[@resource-id=\"free.rm.skytube.oss:id/search_src_text\"]");
	  private By changesPopup = AppiumBy.xpath("//android.widget.Button[@resource-id=\"android:id/button3\"]") ;
	  private By threeDots = AppiumBy.xpath("(//android.widget.ImageButton[@resource-id=\"free.rm.skytube.oss:id/options_button\"])[1]");
	  private By channel = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Channel...\"]");
	 private By openChannel = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Open Channel\"]");
	 private By skyTubeNotificationAlert = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button");
	 private By moreOptions = AppiumBy.accessibilityId("More options");
	 private By menu = AppiumBy.accessibilityId("SkyTube");
	 

	 public TrendingPage(AppiumDriver driver) {
	        this.driver = driver;
	  actions = new reusableFunctions(driver, 30);// Pass driver to LoginPage
	 	   
	    }

	    public void getSkyTubePageTitle() {
	    	   if (driver == null) {
	    	        throw new IllegalStateException("Driver is not initialized");
	    	    }
	    	  try {
	    		  driver.findElement(skyTubeNotificationAlert).click();
	    	  }
	    	  catch(Exception e ) {}
	    	  
	    	try {
	    	driver.findElement(changesPopup).click();
	    	System.out.println("clicked changes popup");
			Thread.sleep(2000);
		} 
	    	catch(Exception e){
	    		
	    	}
	    //	String getTrendingTitle = driver.findElement(skyTubePageTitle).getText();
	    //	System.out.println("Title of the trending page is " + getTrendingTitle);
	    	
	    }
	    
	    public void enterSearch(String searchText) {
	    	actions.waitForElementVisible(search);
	    	driver.findElement(search).click();
	    	driver.findElement(enterSearch).sendKeys(searchText);
	    	  // Cast WebDriver to AndroidDriver to access pressKey
	        AndroidDriver androidDriver = (AndroidDriver) driver;
	        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
	    }
	    
	    public void clickThreeDots() {
	    	actions.waitForElementPresence(threeDots);
	    	driver.findElement(threeDots).click();
	    }
	    
	    public void clickChannel() {
	    	driver.findElement(channel).click();
	    }
	    
	    public void clickOpenChannel() {
	    	driver.findElement(openChannel).click();
	    }
	    
	    public void getAlertNotification() {
	    	driver.findElement(skyTubeNotificationAlert).click();
	    }
	
	
	    public void clickMenu() {
	    	driver.findElement(menu).click();
	    }
	
	    public void clickTopRightThreeDots() {
	    	actions.waitForElementVisible(moreOptions);
	    	driver.findElement(moreOptions).click();    }
	    
	    
	    
}
