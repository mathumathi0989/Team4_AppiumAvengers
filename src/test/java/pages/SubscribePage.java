package pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import utils.reusableFunctions;
public class SubscribePage {
	private AppiumDriver driver;
	
	  reusableFunctions actions;
 
	  private By subscribeLink = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Subscribe\"]");
	  private By unSubscribeLink = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Unsubscribe\"]");
	  private By clickOnVideo = AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"free.rm.skytube.oss:id/channel_layout\"])[1]");
	  private By clickOnAlreadyVideo = AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"free.rm.skytube.oss:id/channel_layout\"])[2]");
	  private By subscribeButton = AppiumBy.id("free.rm.skytube.oss:id/channel_subscribe_button");
	  private By unSubscribeButton = AppiumBy.id("free.rm.skytube.oss:id/channel_subscribe_button");
	 private By subscribeToast = AppiumBy.xpath("//android.widget.Toast[contains(@text, 'Subscribed')]");
	  private By unSubscribeToast =	AppiumBy.xpath("//android.widget.Toast[@text=\"Unsubscribed\"]");
	  private By back = AppiumBy.accessibilityId("Navigate up");
	  private By subscriptionsList = AppiumBy.id("free.rm.skytube.oss:id/sub_channel_name_text_view");
	  
	    public SubscribePage(AppiumDriver driver) {
	        this.driver = driver;
	  actions = new reusableFunctions(driver, 30);// Pass driver to LoginPage
	 	
	    }   



	    public String getSubscribe() {
	    	return actions.getTextFromElement(subscribeLink);
	    }

	    public String getUnsubscribe() {
	    	return actions.getTextFromElement(unSubscribeLink);
	    }

	    
	    public void clickSubscribeLink() {
			   driver.findElement(subscribeLink).click();
		   }
	    
	   public void clickVideo() {
		   driver.findElement(clickOnVideo).click();
	   }
	   public void clickAlreadyVideo() {
		   driver.findElement(clickOnAlreadyVideo).click();
	   }
	   public String getSubscribeButton() {
	    	return actions.getTextFromElement(subscribeButton);
	    }
	   
	   public String getunSubscribeButton() {
	    	return actions.getTextFromElement(unSubscribeButton);
	    }
	   
	   public void clickSubscribeButton() {
		   driver.findElement(subscribeButton).click();
	  
	   }
	   public void clickUnSubscribeButton() {
		   driver.findElement(unSubscribeButton).click();
	  
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
	  

	   public String getSubscriptionName() {
		  return driver.findElement(subscriptionsList).getText();
	   }
	   
	   
	   public String getChannelTitle() {
		   WebElement titleElement =driver.findElement(
				    By.xpath("//android.widget.ScrollView//android.widget.TextView[1]")
				);
			String dynamicTitle = titleElement.getText();
		
				System.out.println("Channel title found: " + dynamicTitle);
				 return dynamicTitle;
	   }
	   
	   public String getChannelVideoTitle() {
		   WebElement titleElement =driver.findElement(
				    By.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/channel_text_view\"]")
				);
			String dynamicVideoChannelTitle = titleElement.getText();
		
				System.out.println("Channel title found: " + dynamicVideoChannelTitle);
				 return dynamicVideoChannelTitle;
		 
	   }
	   
	   public boolean isChannelPresentInSubscriptions(String channelName) {
		    List<WebElement> elements = driver.findElements(By.id("free.rm.skytube.oss:id/sub_channel_name_text"));
		    for (WebElement el : elements) {
		        String text = el.getText().trim();
		        if (text.equalsIgnoreCase(channelName)) {
		            System.out.println("Found channel: " + text);
		            return true; // channel is present
		        }
		    }
		    System.out.println("Channel NOT found in subscription list.");
		    return false; // channel is not present
		}
	   

}
