package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WatchedVideoCleanerSteps {

    private TestContext testContext;
    private int actualBookmark;
    private int expectedBookmark;
    
	public WatchedVideoCleanerSteps(TestContext testContext) {
	        this.testContext = testContext;
	    }
	private static Logger logger = LogManager.getLogger();

	    
	@When("User click on three dots in top right page")
	public void user_click_on_three_dots_in_top_right_page() {
		testContext.getTrendingPage().clickTopRightThreeDots();		
	}
	
	@Then("User should see the Watched video cleaner option")
	public void user_should_see_the_Watched_video_cleaner_option() {
	  String actualText = 	testContext.getwatchVideoCleanerPage().getwatchVideoCleaner();
	   Assert.assertEquals(actualText, "Watched Video Cleaner");
	}
	
	@Given("User already watched bookmarks")
	public void user_already_watched_bookmarks() throws InterruptedException {
		testContext.getTrendingPage().enterSearch("frozen"); 
		testContext.getTrendingPage().clickThreeDots();
		testContext.getwatchVideoCleanerPage().doBookmark();
		testContext.getSubscribePage().clickBack();
		actualBookmark = testContext.getwatchVideoCleanerPage().getBookMarksNo();
	
	}
	
	@Given("User already watched downloads")
	public void user_already_watched_downloads() throws Exception {
		testContext.getTrendingPage().enterSearch("frozen"); 
		testContext.getTrendingPage().clickThreeDots();
		testContext.getwatchVideoCleanerPage().doDownload();
		testContext.getwatchVideoCleanerPage().allowPop();
	  	testContext.getSubscribePage().clickBack();
	  	testContext.getSubscribePage().clickBack();
	}
	
	
	@When("Click on watched video cleaner and click on Clean")
	public void click_on_watched_video_cleaner_and_click_on_clean() {
		testContext.getwatchVideoCleanerPage().enterWatchVideoCleaner();
		testContext.getwatchVideoCleanerPage().clickClean();
	}
	
	@Then("Toast message should be displayed for watched video cleaner")
	public void toast_message_should_be_displayed_for_watched_video_cleaner() {
		expectedBookmark = testContext.getwatchVideoCleanerPage().getBookMarksNo();
		Assert.assertNotEquals(actualBookmark, expectedBookmark);
		logger.info("Bookmarks and Downloads are removed using Watched video cleaner");
	}
	


	
}
