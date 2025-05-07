package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class videoPlaySteps {

	

    private TestContext testContext;
    private String actualStart;
    private String actualEnd;
    private String afterFF;
    private String afterRW;
    private String actualResumeStart;
    private String actualResumeEnd;
    private String expectedResumeEnd ;
    
    public videoPlaySteps(TestContext testContext) {
        this.testContext = testContext;
    }
    // Creating a logger
    private static Logger logger = LogManager.getLogger();

    
	@Given("User opens any watched videos")
	public void user_opens_any_watched_videos() throws InterruptedException {
		testContext.getTrendingPage().enterSearch("astronauts"); 
		testContext.getvideoPage().clickVideo();
		try {
  	    	testContext.getTrendingPage().getAlertNotification();
  	    	testContext.getvideoPage().clickskipButton();
  	    	
  	    	}
  	    	catch(Exception e) {}
	 	actualStart = testContext.getvideoPage().getstartTime();
	 	System.out.println("Start time is "+actualStart);
		Thread.sleep(20000);
		testContext.getvideoPage().clickPause();
		actualResumeEnd = testContext.getvideoPage().getstartTime();
	 	System.out.println("Resumed yes time is "+actualResumeEnd);
	 	testContext.getvideoPage().clickBack();
	 
	 	
	}

	@When("User click on watched video")
	public void user_click_on_watched_video() {
		testContext.getvideoPage().clickVideo();
	}

	@Then("Resume Alert popup")
	public void resume_alert_popup() {
		String actualText = testContext.getvideoPage().getResumeAlert();
		Assert.assertEquals(actualText, "Continue from where you stopped?");
	}

	@When("Resume popup appears and click on No")
	public void resume_popup_appears_and_click_on_no() {
		testContext.getvideoPage().clickResumeNo();
		actualResumeStart = testContext.getvideoPage().getstartTime();
	 	System.out.println("Start time is "+actualResumeStart);
		
	}

	@Then("video starts from beginning")
	public void video_starts_from_beginning() {
		Assert.assertEquals(actualResumeStart, "00:00");
	}

	@When("Resume popup appears and click on Resume")
	public void resume_popup_appears_and_click_on_resume() {
		testContext.getvideoPage().clickResumeYes();
	
	}

	@Then("video continues")
	public void video_continues() {
	
		expectedResumeEnd = testContext.getvideoPage().getResumeStartTime();
	 	System.out.println("Expected Resumed time is "+expectedResumeEnd);
	 	Assert.assertEquals(actualResumeEnd, expectedResumeEnd);
	}

	@Given("User opens any video to test the video play")
	public void user_opens_any_video_to_test_the_video_play() {
		testContext.getTrendingPage().enterSearch("astronauts"); 
	
	}

	@When("User click on video and watch sometime")
	public void user_click_on_video_and_watch_sometime() throws Exception {
		testContext.getvideoPage().clickVideo();
		try {
  	    	testContext.getTrendingPage().getAlertNotification();
  	    	testContext.getvideoPage().clickskipButton();
  	    	
  	    	}
  	    	catch(Exception e) {}
	 	actualStart = testContext.getvideoPage().getstartTime();
	 	System.out.println("Start time is "+actualStart);
		Thread.sleep(20000);
		testContext.getvideoPage().clickPause();
		actualEnd = testContext.getvideoPage().getstartTime();
	 	System.out.println("Resumed time is "+actualEnd);
		
		
	}


	@Then("video plays")
	public void video_plays() {
		boolean isPlaying = testContext.getvideoPage().isVideoPlaying(actualStart, actualEnd);
		 Assert.assertTrue(isPlaying);
	}

	@Then("video paused")
	public void video_paused() {
		boolean isPaused = testContext.getvideoPage().isPlayButtonDisplayed();
		Assert.assertTrue(isPaused, "Play button not visible. Video might not be paused.");
	}
	@When("User click on fast forward")
	public void user_click_on_fast_forward() throws Exception {
		testContext.getvideoPage().fastForwardClick();
		Thread.sleep(3000);
		 afterFF = testContext.getvideoPage().getstartTime();
		System.out.println("Time after fast-forward: " + afterFF);
		
	}

	@Then("video fast forwarded")
	public void video_fast_forwarded() {
		boolean isfastForwarding = testContext.getvideoPage().isVideoPlaying(actualStart, afterFF);
		 Assert.assertTrue(isfastForwarding);
	}

	@When("User click on lanscape mode")
	public void user_click_on_lanscape_mode() throws Exception {
		testContext.getvideoPage().rotate("landscape");
		
	}

	@Then("video plays in landscape mode")
	public void video_plays_in_landscape_mode() {
		testContext.getvideoPage().isRotate();
	}

	@When("User click on fast rewind")
	public void user_click_on_fast_rewind() throws Exception {
		testContext.getvideoPage().fastRewindClick();
		Thread.sleep(3000);
		 afterRW = testContext.getvideoPage().getstartTime();
		System.out.println("Time after fast-rewind: " + afterRW);
	}

	@Then("video fast rewinded")
	public void video_fast_rewinded() {
		boolean isfastRewinding = testContext.getvideoPage().isVideoPlaying(actualStart, afterRW);
		 Assert.assertTrue(isfastRewinding);
	}





}
