package pages;


import org.openqa.selenium.By;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import utils.reusableFunctions;

public class SubscribePage {
	 private AppiumDriver driver;
	  reusableFunctions actions;
 
	    
	    public SubscribePage(AppiumDriver driver) {
	        this.driver = driver;
	  actions = new reusableFunctions(driver, 30);// Pass driver to LoginPage
	 	   
	    }

	    

	   
}
