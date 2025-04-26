package base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utils.AppiumReporterUtil;
import utils.ConfigManager;

public class baseTest {

	private static AppiumDriver driver;
	private static AppiumDriverLocalService service;

	public static AppiumDriverLocalService getService() {
		return service;
	}

	public static void startServer(final String platformName) throws Exception, Exception {
		String appiumJsPath = ConfigManager.getProperty("appium.js.path");
		System.out.println("Appium JS Path is: " + appiumJsPath);
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
				.usingPort(4723)
				.withEnvironment(environment);

		// Start the Appium server with the configured builder
		service = AppiumDriverLocalService.buildService(builder);
		service.start();

		// Log the server URL for debugging
		System.out.println("Appium server started at " + service.getUrl());

	}

	public static void stopServer() {
		if (service != null && service.isRunning()) {
			service.stop();
			System.out.println("Appium server stopped.");
		} else {
			System.out.println("Appium server is not running.");
		}
	}

	public static void setup() throws MalformedURLException, Exception {

		String platform = ConfigManager.getProperty("platform").toLowerCase();
		startServer(platform);

		if (platform.equalsIgnoreCase("Android")) {
			launchAndroidEmulator(ConfigManager.getProperty("avd.name"));
			UiAutomator2Options options = new UiAutomator2Options()
					.setAppWaitActivity("*")
					.setUdid(ConfigManager.getProperty("device.name"))
					.setApp(ConfigManager.getAppPath());
			driver = new AndroidDriver(new URL(ConfigManager.getProperty("appium.server.url")), options)								;
		}
		else if (platform.equalsIgnoreCase("iOS")) {
			XCUITestOptions options = new XCUITestOptions()
					.setUdid(ConfigManager.getProperty("udid"))
					.setApp(ConfigManager.getProperty("app.ios.path"))
					.setNoReset(false)
					.setShowXcodeLog(true);
			driver = new IOSDriver(new URL(ConfigManager.getProperty("appium.server.url")), options);
		}
//		if (!AppiumReporterUtil.isDeviceFarm(driver)) {
//			driver.executeScript("plugin: setWaitPluginProperties", ImmutableMap.of(
//					"timeout", 10000,
//					"intervalBetweenAttempts", 500
//			));
//		}

	}

	private static void startAppiumServer() {
		    /*
		     #Set Appium PATH in Env variable
		export APPIUM_JS_PATH=/Users/{{UserName}}/.npm-global/lib/node_modules/appium/build/lib/main.js
		     */
		System.out.println("check if its comes inside appium");
		String appiumJsPath = System.getenv("APPIUM_JS_PATH");
		if (appiumJsPath == null || appiumJsPath.isEmpty()) {
			throw new IllegalStateException("Appium JS Path is not set in environment variables.");
		}
		System.out.println("Appium JS Path is: " + appiumJsPath);
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(appiumJsPath))
				.usingAnyFreePort()
				.build();
		service.start();
		System.out.println("Appium server started at " + service.getUrl());
	}

	private static void launchAndroidEmulator(String avdName) throws IOException, InterruptedException {
		  /*
		   #Android SDK set it in env path
	export ANDROID_HOME=/Users/{{UserName}}/Library/Android/sdk
	export PATH=$PATH:$ANDROID_HOME/emulator:$ANDROID_HOME/tools:$ANDROID_HOME/tools/bin:$ANDROID_HOME/platform-tools
		   */
		String emulatorPath = ConfigManager.getProperty("android.emulator.path");
		String adbPath = ConfigManager.getProperty("android.adb.path");
		System.out.println("Starting Android Emulator: " + avdName);
		// Start emulator process
		ProcessBuilder emulatorPb = new ProcessBuilder(emulatorPath, "-avd", avdName);
		emulatorPb.redirectErrorStream(true);
		emulatorPb.start();

		// Wait for emulator to be visible to adb
		System.out.println("Waiting for device to boot...");
		ProcessBuilder adbWaitPb = new ProcessBuilder(adbPath, "wait-for-device");
		adbWaitPb.inheritIO();  // Optional: to show logs in console
		Process waitProcess = adbWaitPb.start();
		waitProcess.waitFor();  // This will block until the emulator is ready

		Thread.sleep(10000);
		System.out.println("Emulator is ready.");
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