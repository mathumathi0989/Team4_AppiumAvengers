package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import utils.reusableFunctions;

public class TrendingPage {
	 private AppiumDriver driver;
	  reusableFunctions actions;
	  private By skyTubePageTitle = AppiumBy.xpath("//android.widget.TextView[@text=\"SkyTube\"]");
  
	    
	    public TrendingPage(AppiumDriver driver) {
	        this.driver = driver;
	  actions = new reusableFunctions(driver, 30);// Pass driver to LoginPage
	 	   
	    }

	    public String getSkyTubePageTitle() {

			return	driver.findElement(skyTubePageTitle).getText();
	    }
	
	
	
	
	
}
