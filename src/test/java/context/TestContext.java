package context;

import base.baseTest;
import io.appium.java_client.AppiumDriver;
import pages.LoginPage;
import pages.productsPage;
import utils.ExcelReader;

//TestContext.java (Dependency Injection)

public class TestContext {

	private AppiumDriver driver;
    protected LoginPage loginPage;
    private ScenarioContext scenarioContext;
    private ExcelReader excelReader;
    protected productsPage productsPage;
    
    public TestContext() throws Exception {
        this.scenarioContext = new ScenarioContext();  // Initialize the ScenarioContext
//        this.driver = baseTest.getDriver();  // Get the driver from BaseTest
//        this.loginPage = new LoginPage(driver); 
        this.excelReader = new ExcelReader();  // Load Excel once

       
    }

    public LoginPage getLoginPage() {
        if (this.loginPage == null) {
            this.loginPage = new LoginPage(getDriver()); // lazy init
        }
        return this.loginPage;
    }

    public productsPage getProductPage() {
        if (this.productsPage == null) {
            this.productsPage = new productsPage(getDriver()); // ✅ init here
        }
        return this.productsPage;
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
    
    public ExcelReader getExcelReader() {
        return excelReader;
    }
    
	    
}
