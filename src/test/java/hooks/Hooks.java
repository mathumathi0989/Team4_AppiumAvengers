package hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.baseTest;
import context.TestContext;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.AppiumReporterUtil;


public class Hooks {
	private TestContext testContext;
    public Hooks(TestContext context) {
        this.testContext = context;
    }
    

@BeforeAll
public static void launchEmulator() throws Exception, InterruptedException {
	baseTest.launchAndroidEmulator();
	
}

    @Before
	public void setup() throws Exception {
    	baseTest.startServer();
    	 baseTest.clearAppData();  // Clear app data to reset the app's state
    	    baseTest.terminateAndResetApp(); // Ensure the app is fully reset and terminated
       baseTest.setup();  
       
    }

    @After
	public void teardown(Scenario scenario) {
        System.out.println("Closing App");
        AppiumDriver driver = baseTest.getDriver();
        if (driver != null) {
            try {
                baseTest.terminateAndResetApp();  // Ensure clean state
            } catch (IOException e) {
                e.printStackTrace();
            }
        String sessionId = AppiumReporterUtil.getSessionId(driver);
        String testName = scenario.getName();
        String status = scenario.getStatus().name(); 

        switch (status) {
        case "FAILED":
            AppiumReporterUtil.setTestInfo(sessionId, testName, "FAILED", status);
            break;
        case "PASSED":
            AppiumReporterUtil.setTestInfo(sessionId, testName, "PASSED", null);
            break;
        default:
            AppiumReporterUtil.setSkippedTestInfo(testName, "SKIPPED", status);
    }
        }

    }

    @AfterStep
    public void takeScreenshotOnFailure(Scenario scenario) {
    	 if (scenario.isFailed() && baseTest.getDriver() != null) {
    	        TakesScreenshot ts = (TakesScreenshot) baseTest.getDriver();
    	        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
    	        scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
       try {
    	            File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
    	            String fileName = "screenshots/" + scenario.getName().replaceAll(" ", "_") + "_" + System.currentTimeMillis() + ".png";
    	            File destination = new File(fileName);
    	            destination.getParentFile().mkdirs();  // Create directory if not exists

    	            Files.copy(screenshotFile.toPath(), destination.toPath());
    	            System.out.println("Screenshot saved to: " + destination.getAbsolutePath());
    	        } catch (IOException e) {
    	            e.printStackTrace();
    	        }
    	    }
    }

    @AfterAll
    public static void generateHtmlReport() {
        System.out.println("Generating HTML report...");
        String report = AppiumReporterUtil.getReport();
        AppiumReporterUtil.deleteReportData();
        AppiumReporterUtil.createReportFile(report, "AppiumAvengersReport");
        baseTest.tearDown();
        baseTest.stopServer();
        baseTest.stopAndroidEmulator(); // <-- kill emulator after all tests
       
        
    }
    
 
}