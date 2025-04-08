package base;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import utils.AppiumReporterUtil;
import utils.ConfigManager;

public class baseTest {

	  private static AppiumDriver driver;

	  public static void setup() throws MalformedURLException, Exception {
		  if (ConfigManager.getProperty("platform").equalsIgnoreCase("Android")) {
				UiAutomator2Options options = new UiAutomator2Options()
						.setAppWaitActivity("*")
					    .setUdid(ConfigManager.getProperty("device.name"))
					    .setApp(ConfigManager.getProperty("app.path"));
				 driver = new AndroidDriver(new URL(ConfigManager.getProperty("appium.server.url")), options);			
			//	driver.executeScript("plugin: setWaitPluginProperties", ImmutableMap.of("timeout", 10000 , "intervalBetweenAttempts", 500 ));
						    }
		  else if (ConfigManager.getProperty("platform").equalsIgnoreCase("iOS")) {
			  XCUITestOptions options = new XCUITestOptions()
			  .setDeviceName(ConfigManager.getProperty("device.name"))
	            .setPlatformVersion(ConfigManager.getProperty("platform.version"))
	            .setNoReset(true);
			  driver = new IOSDriver(new URI(ConfigManager.getProperty("appium.server.url")).toURL(), options);
			//  driver.executeScript("plugin: setWaitPluginProperties", ImmutableMap.of("timeout", 10000 , "intervalBetweenAttempts", 500 ));
			 	  }
		  else {
	            throw new IllegalArgumentException("Invalid platform: " + ConfigManager.getProperty("platform"));
	        }
		  
		  // Set wait plugin + reporter plugin properties
		  if (!AppiumReporterUtil.isDeviceFarm(driver)) {
	        driver.executeScript("plugin: setWaitPluginProperties", ImmutableMap.of(
	                "timeout", 10000,
	                "intervalBetweenAttempts", 500
	        ));
		  }
	        driver.executeScript("plugin: setReporterPluginProperties", ImmutableMap.of(
	                "enabled", true,
	                "projectName", "Numpy Ninja Project",
	                "reportTitle", "Appium Test Execution Report"
	        ));
	        
	    
	        
		  
	    }

	    public static void tearDown() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }

	    public static AppiumDriver getDriver() {
	        return driver;
	    }
	    
}
