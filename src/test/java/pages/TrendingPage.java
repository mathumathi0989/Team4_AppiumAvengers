package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
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
	  
	  
	  public TrendingPage(AppiumDriver driver) {
	        this.driver = driver;
	  actions = new reusableFunctions(driver, 30);// Pass driver to LoginPage
	 	   
	    }

	    public void getSkyTubePageTitle() {
	    	try {
	    	driver.findElement(changesPopup).click();}
	    	catch(Exception e){
	    		
	    	}
	    	String getTrendingTitle = driver.findElement(skyTubePageTitle).getText();
	    	System.out.println("Title of the trending page is " + getTrendingTitle);
	    	
	    }
	    
	    public void enterSearch(String searchText) {
	    	driver.findElement(search).click();
	    	driver.findElement(enterSearch).sendKeys(searchText);
	    	driver.findElement(enterSearch).sendKeys(Keys.RETURN);
	    }
	    
	    
	   
	
	
	
}
