package base;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterMethod;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utils.ConfigManager;


public class baseTest {

	 private static AppiumDriver driver;
	  private static AppiumDriverLocalService service;
	  
	    public static AppiumDriverLocalService getService() {
	        return service;
	    }
	    
	    public static void startServer() throws Exception, Exception {
	    	String appiumJsPath = ConfigManager.getProperty("appium.js.path");
	   //     System.out.println("Appium JS Path is: " + appiumJsPath);
	        if (appiumJsPath == null || appiumJsPath.isEmpty()) {
	            throw new IllegalStateException("Appium JS Path is not set in environment variables.");
	        }  
	    String nodeExecutablePath = ConfigManager.getProperty("node.executable");

	       Map<String, String> environment = new HashMap<>(System.getenv());
	        environment.put("ANDROID_SDK_ROOT",ConfigManager.getProperty("android.sdk.path") );
	        
	        // Create a builder for the Appium service
	        AppiumServiceBuilder builder = new AppiumServiceBuilder()
	        		  .withAppiumJS(new File(appiumJsPath))
	                  .usingDriverExecutable(new File(nodeExecutablePath))
	                  .withArgument(() -> "--use-plugins=appium-reporter-plugin,element-wait")
	                  .usingPort(4723)
	                  .withEnvironment(environment);

	     
	        // Start the Appium server with the configured builder
	        service = AppiumDriverLocalService.buildService(builder);
	        service.start();

	        // Log the server URL for debugging
	//        System.out.println("Appium server started at " + service.getUrl());
	    
	    }
	    
	    public static void stopServer() {
          if (service != null && service.isRunning()) {
              service.stop();
    //          System.out.println("Appium server stopped.");
          } else {
    //          System.out.println("Appium server is not running.");
          }
       // Kill Appium Node process if still running
          try {
              String os = System.getProperty("os.name").toLowerCase();
              if (os.contains("mac")) {
                  Runtime.getRuntime().exec("killall node");
              } else if (os.contains("win")) {
                  Runtime.getRuntime().exec("taskkill /F /IM node.exe");
              }
      //        System.out.println("Appium (Node) process killed.");
          } catch (IOException e) {
  //            System.out.println("Failed to kill Appium process: " + e.getMessage());
          }
          
      }
	    
	  public static void setup() throws MalformedURLException, Exception {
		  
		    
		  String platform = ConfigManager.getProperty("platform").toLowerCase();
		    //    startServer(platform);
		       
			  if (platform.equalsIgnoreCase("Android")) {
				//  launchAndroidEmulator(ConfigManager.getProperty("avd.name"));
					UiAutomator2Options options = new UiAutomator2Options()
							.setAppWaitActivity(ConfigManager.getProperty("app.activity"))						
							 .setUdid(ConfigManager.getProperty("device.name"))
							 .setIgnoreHiddenApiPolicyError(true)
							 .setAppPackage(ConfigManager.getProperty("app.package"))
							    .setAppActivity(ConfigManager.getProperty("app.activity"))
						    .setApp(ConfigManager.getAppPath())
					  .setNoReset(true)  // <-- Keeps app and data between sessions
					  .setFullReset(false);   // <-- Prevents uninstalling the app
					 driver = new AndroidDriver(new URL(ConfigManager.getProperty("appium.server.url")), options);			
					  
			  }
			  else if (platform.equalsIgnoreCase("iOS")) {
				  XCUITestOptions options = new XCUITestOptions()
						  .setUdid(ConfigManager.getProperty("udid"))
						  .setApp(ConfigManager.getProperty("app.ios.path"))
						  .setNoReset(false)
						  .setAutoAcceptAlerts(true)
						  .setShowXcodeLog(true);
				  driver = new IOSDriver(new URL(ConfigManager.getProperty("appium.server.url")), options);
				
				 
				 	  }
			
			        driver.executeScript("plugin: setWaitPluginProperties", ImmutableMap.of(
			                "timeout", 25000,
			                "intervalBetweenAttempts", 500
			        ));
				 
			        driver.executeScript("plugin: setReporterPluginProperties", ImmutableMap.of(
			                "enabled", true,
			                "projectName", "Numpy Ninja Project",
			                "reportTitle", "Appium Test Execution Report"
			        ));
			    if (driver == null) {
			        throw new IllegalStateException("Driver initialization failed in baseTest");
			    }
	    }

	  
	  public static void launchAndroidEmulator() throws IOException, InterruptedException {
		  String avdName = ConfigManager.getProperty("avd.name");
		  String emulatorPath = ConfigManager.getProperty("android.emulator.path");
		    String adbPath = ConfigManager.getProperty("android.adb.path");
	     //   System.out.println("Starting Android Emulator: " + avdName);
	        // Start emulator process
	        ProcessBuilder emulatorPb = new ProcessBuilder(emulatorPath, "-avd", avdName,
	                "-wipe-data");
	        emulatorPb.redirectErrorStream(true);
	        emulatorPb.start();

	        // Wait for emulator to be visible to adb
	    //    System.out.println("Waiting for device to boot...");
	        ProcessBuilder adbWaitPb = new ProcessBuilder(adbPath, "wait-for-device");
	        adbWaitPb.inheritIO();  // Optional: to show logs in console
	        Process waitProcess = adbWaitPb.start();
	        waitProcess.waitFor();  // This will block until the emulator is ready

	        Thread.sleep(30000); 
	        System.out.println("Emulator is ready.");      
	    }
	  
	  
	  public static void stopAndroidEmulator() {
		    try {
		        String adbPath = ConfigManager.getProperty("android.adb.path");
		        ProcessBuilder pb = new ProcessBuilder(adbPath, "emu", "kill");
		        pb.start();
		//        System.out.println("Emulator stopped.");
		    } catch (IOException e) {
		//        System.out.println("Failed to stop emulator: " + e.getMessage());
		    }
		}
	  
	    @AfterMethod
		public static void tearDown() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }

	    public static AppiumDriver getDriver() {
	        return driver;
	    }
	    
	    public static void clearAppData() throws IOException {
	    	  String adbPath = ConfigManager.getProperty("android.adb.path");
	    	    String appPackage = ConfigManager.getProperty("app.package");

	    	    // Clear app data
	    	    ProcessBuilder adbClearData = new ProcessBuilder(adbPath, "shell", "pm", "clear", appPackage);
	    	    adbClearData.start();
	    	  //  System.out.println("App data cleared for package: " + appPackage);

	    	    // Optionally, terminate the app if it is still running
	    	    ProcessBuilder adbTerminate = new ProcessBuilder(adbPath, "shell", "am", "force-stop", appPackage);
	    	    adbTerminate.start();
	    	//    System.out.println("App terminated for package: " + appPackage);
	    }
	    public static void terminateAndResetApp() throws IOException {
	        String platform = ConfigManager.getProperty("platform").toLowerCase();

	        if (platform.equals("android")) {
	            String appPackage = ConfigManager.getProperty("app.package");
	            String adbPath = ConfigManager.getProperty("android.adb.path");

	            // Terminate the app
	            ProcessBuilder adbTerminate = new ProcessBuilder(adbPath, "shell", "am", "force-stop", appPackage);
	            adbTerminate.start();
	      //      System.out.println("Android app terminated");

	            // Reset the app
	            clearAppData();  // Clears the app data to ensure a clean state

	      //      System.out.println("Android app data cleared and reset.");
	        } 
	    }
	    
	    public static boolean isEmulatorRunning() throws IOException {
	        String adbPath = ConfigManager.getProperty("android.adb.path");
	        ProcessBuilder pb = new ProcessBuilder(adbPath, "devices");
	        Process process = pb.start();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            if (line.contains("emulator") && line.contains("device")) {
	                return true;
	            }
	        }
	        return false;
	    }
	    
}
