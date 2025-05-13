package pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import utils.reusableFunctions;

public class videoPage {
	 private AppiumDriver driver;
	  reusableFunctions actions;
	  private By video = AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"free.rm.skytube.oss:id/top_layout\"])[2]");
	  private By  play = AppiumBy.id("free.rm.skytube.oss:id/exo_play");
	  private By pause = AppiumBy.accessibilityId("Pause");
	 private By rewind = AppiumBy.id("free.rm.skytube.oss:id/exo_rew");
	 private By forward = AppiumBy.id("free.rm.skytube.oss:id/exo_ffwd");
	 private By startTime = AppiumBy.id("free.rm.skytube.oss:id/exo_position");
	 private By endTime = AppiumBy.id("free.rm.skytube.oss:id/exo_duration");
	 private By progressBar = AppiumBy.id("free.rm.skytube.oss:id/exo_progress");
	 private By goBack = AppiumBy.accessibilityId("Navigate up");
	 private By skipButton = AppiumBy.id("free.rm.skytube.oss:id/skipButton");
	 private By resumeAlert = AppiumBy.id("free.rm.skytube.oss:id/md_content");
	 private By resumeNo = AppiumBy.id("free.rm.skytube.oss:id/md_buttonDefaultNegative");
	 private By resumeYes = AppiumBy.id("free.rm.skytube.oss:id/md_buttonDefaultPositive");
	 private By viewingFullScreenPopup = AppiumBy.id("android:id/ok");
	  private By meteredNetworkPopup = AppiumBy.id("free.rm.skytube.oss:id/md_buttonDefaultPositive");
	  
		 public videoPage(AppiumDriver driver) {
		        this.driver = driver;
		  actions = new reusableFunctions(driver, 30);// Pass driver to LoginPage
		 	   
		    }

	
	public void clickVideo() {
		driver.findElement(video).click();
	}
	
	public void clickskipButton() {

		driver.findElement(skipButton).click();

		
	}
	
	public String getstartTime() {
		actions.tapUsingPointerInput(0,0);
	//	actions.tapUsingPointerInput((actions.getScreenSize().getWidth())/2, (actions.getScreenSize().getHeight())/2);
	//	actions.waitForElementVisible(startTime);
	return	driver.findElement(startTime).getText();
		}
			
	public String getEndTime() {
	return	driver.findElement(endTime).getText();
		}
	
	public void clickPause() throws Exception {
//		// Tap on screen using W3C Actions (replace with your actual driver)
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence tap = new Sequence(finger, 1);
		tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
		        PointerInput.Origin.viewport(), 540, 960)); // X, Y coordinates
		tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		tap.addAction(new Pause(finger, Duration.ofMillis(200)));
		tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Arrays.asList(tap));
	//	actions.tapUsingPointerInput(0,0);
		driver.findElement(pause).click();
//		System.out.println("before pause its tapped");
	//	Thread.sleep(500);
		//actions.waitForElementVisible(pause);
		
	}
	public boolean isVideoPlaying(String startTime, String endTime) {
	    try {
	        int startSeconds = convertToSeconds(startTime);
	        int endSeconds = convertToSeconds(endTime);
	        return endSeconds > startSeconds;
	    } catch (Exception e) {
	        System.out.println("⚠️ Error parsing time: " + e.getMessage());
	        return false;
	    }
	}

	private int convertToSeconds(String time) {
	    String[] parts = time.split(":");

	    if (parts.length == 2) { // mm:ss
	        int minutes = Integer.parseInt(parts[0]);
	        int seconds = Integer.parseInt(parts[1]);
	        return minutes * 60 + seconds;
	    } else if (parts.length == 3) { // HH:mm:ss
	        int hours = Integer.parseInt(parts[0]);
	        int minutes = Integer.parseInt(parts[1]);
	        int seconds = Integer.parseInt(parts[2]);
	        return hours * 3600 + minutes * 60 + seconds;
	    } else {
	        throw new IllegalArgumentException("Unrecognized time format: " + time);
	    }
	}
	
	public boolean isPlayButtonDisplayed() {
		return driver.findElement(play).isDisplayed();
	}
	public void fastForwardClick() {
		driver.findElement(forward).click();
	}
	
	public void fastRewindClick() {
		driver.findElement(rewind).click();
	}
	public void rotate(String phoneMode) throws Exception {
		   AndroidDriver androidDriver = (AndroidDriver) driver;  // cast AppiumDriver to AndroidDriver
		    if (phoneMode.equalsIgnoreCase("landscape")) {
		        androidDriver.rotate(ScreenOrientation.LANDSCAPE);
		        Thread.sleep(1000);
		    } else {
		        androidDriver.rotate(ScreenOrientation.PORTRAIT);
		    }
	}
	
	public void isRotate() {
		ScreenOrientation orientation = ((AndroidDriver) driver).getOrientation();
		System.out.println("orientation is : "+orientation);
		Assert.assertEquals(orientation, ScreenOrientation.LANDSCAPE, "Orientation is not LANDSCAPE");

	}
	
	public void clickBack() {
		driver.findElement(goBack).click();}
	public String getResumeAlert() {
		actions.waitForElementVisible(resumeAlert);
		return driver.findElement(resumeAlert).getText();
	}
	
	public void clickResumeNo() {
		actions.waitForElementVisible(resumeNo);
		driver.findElement(resumeNo).click();
	}
	public void clickResumeYes() {
		actions.waitForElementVisible(resumeYes);
		driver.findElement(resumeYes).click();
	}
	
	
	public String getResumeStartTime() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    return wait.until(driver -> {
	        WebElement timeElement = driver.findElement(startTime);
	        String timeText = timeElement.getText();
	        if (timeElement.isDisplayed() && !timeText.equals("0:00") && !timeText.equals("00:00")) {
	            return timeText;
	        }
	        return null; // keep waiting
	    });
	}
	
	public void allowviewingFullScreenPopup() {
		actions.waitForElementPresence(viewingFullScreenPopup);
		driver.findElement(viewingFullScreenPopup).click();
	}
	
	
	public void allowmeteredNetworkPopup() {
		actions.waitForElementPresence(meteredNetworkPopup);
		driver.findElement(meteredNetworkPopup).click();
	}
}
