package context;

import base.baseTest;
import io.appium.java_client.AppiumDriver;
import pages.SearchPage;
import pages.SubscribePage;
import pages.TrendingPage;
import utils.ExcelReader;

public class TestContext {

	private AppiumDriver driver;
    protected SubscribePage subscribePage;
    protected TrendingPage trendingPage;
    private ExcelReader excelReader;
    protected SearchPage searchPage;

    
    public TestContext() throws Exception {
        this.excelReader = new ExcelReader();  
    }

    public SubscribePage getSubscribePage() {
        if (this.subscribePage == null) {
            this.subscribePage = new SubscribePage(getDriver()); 
        }
        return this.subscribePage;
    }
    
    
    public SearchPage getSearchPage() {
        if (this.searchPage == null) {
            this.searchPage = new SearchPage(getDriver()); 
        }
        return this.searchPage;
    }

    public TrendingPage getTrendingPage() {
        if (this.trendingPage == null) {
            this.trendingPage = new TrendingPage(getDriver()); 
        }
        return this.trendingPage;
    }
    
    public AppiumDriver getDriver() {
        if (this.driver == null) {
            this.driver = baseTest.getDriver();
        }
        return this.driver;
    }

 
    
    public ExcelReader getExcelReader() {
        return excelReader;
    }
    
	    
}
