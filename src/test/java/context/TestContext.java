package context;

import base.baseTest;
import io.appium.java_client.AppiumDriver;
import pages.SubscribePage;
import utils.ExcelReader;

public class TestContext {

	private AppiumDriver driver;
    protected SubscribePage loginPage;
    private ScenarioContext scenarioContext;
    private ExcelReader excelReader;
    
    public TestContext() throws Exception {
        this.scenarioContext = new ScenarioContext();  
        this.excelReader = new ExcelReader();  
    }

    public SubscribePage getLoginPage() {
        if (this.loginPage == null) {
            this.loginPage = new SubscribePage(getDriver()); 
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
        return scenarioContext;  
    }
    
    public ExcelReader getExcelReader() {
        return excelReader;
    }
    
	    
}
