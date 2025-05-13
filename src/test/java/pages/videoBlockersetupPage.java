//package pages;
//
//import java.util.ArrayList;
//
//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import io.appium.java_client.AppiumBy;
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.nativekey.AndroidKey;
//import io.appium.java_client.android.nativekey.KeyEvent;
//import utils.reusableFunctions;
//
//public class videoBlockersetupPage {
//
//	private AppiumDriver driver;
//	reusableFunctions actions;
//
//	private By search = AppiumBy.accessibilityId("Search Videos");
//	private By enterSearch = AppiumBy
//			.xpath("//android.widget.AutoCompleteTextView[@resource-id=\"free.rm.skytube.oss:id/search_src_text\"]");
//	private By threeDots = AppiumBy
//			.xpath("(//android.widget.ImageButton[@resource-id=\"free.rm.skytube.oss:id/options_button\"])[1]");
//	// free.rm.skytube.oss:id/options_button
//	private By channel = AppiumBy
//			.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Channel...\"]");
//	// ByAndroidUIAutomator("new
//	// UiSelector().resourceId(\"free.rm.skytube.oss:id/title\").textContains(\"Channel\")")
//	private By blockChannel = AppiumBy.xpath(
//			"//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Block Channel\"]");
//	private By preferences = AppiumBy.xpath(
//			"//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Preferences\"]");
//	private By videoBlockerText = AppiumBy
//			.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Video Blocker\"]");
//
//	private By ChannelDenyList = AppiumBy
//			.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Channel Deny List\"]");
//	private By denyListChannels = AppiumBy.accessibilityId("free.rm.skytube.oss:id/channel_name");
//
//	private By selectAlltoUnblock = AppiumBy.accessibilityId("free.rm.skytube.oss:id/select_all_button");
//
//	private By Unblock = AppiumBy.accessibilityId("free.rm.skytube.oss:id/md_buttonDefaultPositive");
//
//	private By back = AppiumBy.accessibilityId("Navigate up");
//
//	public videoBlockersetupPage(AppiumDriver driver) {
//		this.driver = driver;
//		actions = new reusableFunctions(driver, 30);
//	}
//
//	public void clickThreeDots() {
//		driver.findElement(threeDots).click();
//	}
//
//	public void clickChannel() {
//		driver.findElement(channel).click();
//	}
//
//	public boolean isOptionVisible(String expectedText) {
//		return driver.findElement(By.xpath("//android.widget.TextView[@text='" + expectedText + "']")).isDisplayed();
//	}
//
//	public void clickBlockChannel() {
//		driver.findElement(blockChannel).click();
//		;
//	}
//
//	public void clickPreferences() {
//		driver.findElement(preferences).click();
//	}
//
//	public void clickvideoBlockoption() {
//		driver.findElement(videoBlockerText).click();
//
//	}
//
//	public void viewChannelDenyList() {
//		driver.findElement(ChannelDenyList).click();
//
//	}
//
//	public List<String> getBlockedChannelNames() {
//		List<String> channelNames = new ArrayList<>();
//		List<WebElement> channelElements = driver.findElements(By.id("free.rm.skytube.oss:id/channel_name"));
//		for (WebElement element : channelElements) {
//			channelNames.add(element.getText().trim());
//		}
//		return channelNames;
//	}
//
//	public void selectAllBlockedChannels() {
//
//		driver.findElement(selectAlltoUnblock).click();
//
//	}
//
//	public void unblockChannel() {
//
//		driver.findElement(Unblock).click();
//	}
//	  public void clickBack() {
//		   driver.findElement(back).click();
//	   }
//
//	  public void enterSearchData() {
//	    	driver.findElement(search).click();
//	    	driver.findElement(search).sendKeys("young thug");
//	    	  // Cast WebDriver to AndroidDriver to access pressKey
//	        AndroidDriver androidDriver = (AndroidDriver) driver;
//	        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
//	    }
//
//
//
//}
