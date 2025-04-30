package context;

import base.baseTest;
import io.appium.java_client.AppiumDriver;
import pages.SearchPage;
import pages.SubscribePage;
import utils.ExcelReader;

public class TestContext {

	private AppiumDriver driver;
    protected SubscribePage loginPage;
    private ScenarioContext scenarioContext;
    private ExcelReader excelReader;
    protected SearchPage searchPage;

    
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
    
    
    public SearchPage getSearchPage() {
        if (this.searchPage == null) {
            this.searchPage = new SearchPage(getDriver()); 
        }
        return this.searchPage;
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
