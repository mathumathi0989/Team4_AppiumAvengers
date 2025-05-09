package context;

import base.baseTest;
import io.appium.java_client.AppiumDriver;
import pages.BookmarkPage;
import pages.PreferencesPage;
import pages.SearchPage;
import pages.SubscribePage;
import pages.TrendingPage;
import pages.videoPage;
import pages.watchVideoCleanerPage;
import utils.ExcelReader;

public class TestContext {

	private AppiumDriver driver;
    protected SubscribePage subscribePage;
    protected TrendingPage trendingPage;
    private ExcelReader excelReader;
    protected SearchPage searchPage;
    protected videoPage videoPage;
    private watchVideoCleanerPage watchVideoCleanerPage;
    private BookmarkPage bookmarkPage;
    private PreferencesPage preferencesPage;


    
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
    

    public videoPage getvideoPage() {
        if (this.videoPage == null) {
            this.videoPage = new videoPage(getDriver()); 
        }
        return this.videoPage;
    }
    
    
    public watchVideoCleanerPage getwatchVideoCleanerPage() {
        if (this.watchVideoCleanerPage == null) {
            this.watchVideoCleanerPage = new watchVideoCleanerPage(getDriver()); 
        }
        return this.watchVideoCleanerPage;
    }
    

    
    public AppiumDriver getDriver() {
        if (this.driver == null) {
            this.driver = baseTest.getDriver();
            if (this.driver == null) {
                throw new IllegalStateException("Driver is not initialized in baseTest");
            }
        }
        return this.driver;
    }

 
    
    public ExcelReader getExcelReader() {
        return excelReader;
    }

    public BookmarkPage getBookmarkPage() {
       if (this.bookmarkPage == null) {
            this.bookmarkPage = new BookmarkPage(getDriver()); 
        }
        return this.bookmarkPage;
    }
    
    public PreferencesPage getPreferencesPage() {
        if (this.preferencesPage == null) {
            this.preferencesPage = new PreferencesPage(getDriver()); 
        }
        return this.preferencesPage;
    }
	    
}
