package context;

import base.baseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import pages.LoginPage;

//TestContext.java (Dependency Injection)

public class TestContext {

	private AppiumDriver driver;
    private LoginPage loginPage;
    private ScenarioContext scenarioContext;
  
    
    public TestContext() throws Exception {
        this.scenarioContext = new ScenarioContext();  // Initialize the ScenarioContext
//        this.driver = baseTest.getDriver();  // Get the driver from BaseTest
//        this.loginPage = new LoginPage(driver); 
       
    }

    public LoginPage getLoginPage() {
        if (this.loginPage == null) {
            this.loginPage = new LoginPage(getDriver()); // lazy init
        }
        return this.loginPage;
    }

    public AppiumDriver getDriver() {
        if (this.driver == null) {
            this.driver = baseTest.getDriver();
        }
        return this.driver;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;  // Return the ScenarioContext for storing/sharing data
    }
	    
}
