package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.bs.A.As;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class BookmarkSteps {
    private TestContext testContext;

	public BookmarkSteps(TestContext testContext) {
		this.testContext = testContext;
	}

	// Creating a logger
	private static Logger logger = LogManager.getLogger();


    @When("User clicks Bookmark tab")
    public void user_clicks_bookmark_tab() {
        testContext.getBookmarkPage().clickBookmarkTab();
        // Code to click on the Bookmark tab
    }
  
    
@Then("The user should see the message Bookmark some videos to find them here.")
public void the_user_should_see_the_message_bookmark_some_videos_to_find_them_here() {
    testContext.getBookmarkPage().getNoBookmarkedVideosText();
    Assert.assertTrue(testContext.getBookmarkPage().getNoBookmarkedVideosText().contains("Bookmark some videos to find them here.")); // Replace with actual verification logic
}
@When("User clicks on three dots in  video")
public void user_clicks_on_three_dots_in_any_video() {
   testContext.getBookmarkPage().clickThreeDots();
   
}

@Then("User should see the Bookmark option")
public void user_should_see_the_bookmark_option() {
  
   String bookmarkText = testContext.getBookmarkPage().getBookmark();
   Assert.assertEquals("Bookmark", bookmarkText);
   
}

@When("Clicks on Bookmark")
public void clicks_on_bookmark() {
  testContext.getBookmarkPage().clickBookmarkButton();
   
    
}
    @Then("The user should see the message {string}")
    public void the_user_should_see_the_message(String message) {
        // Code to verify that the specified message is displayed
        // String noBookmarkedVideosText = testContext.getBookmarkPage().getNoBookmarkedVideosText();
        // System.out.println("No Bookmarked Videos text: " + noBookmarkedVideosText);
        // Assert.assertTrue(noBookmarkedVideosText.contains(message)); // Replace with actual verification logic
                     System.out.println("Bookmarked");
    
    }
    

    @Then("Toast message {string} should be displayed")
    public void toast_message_should_be_displayed(String message) {
       
        String toastMessage = testContext.getBookmarkPage().getBookmark();
        System.out.println("Toast message: " + toastMessage);
        Assert.assertTrue(toastMessage.contains(message)); // Replace with actual verification logic
    }





    @Then("User should see the Unbookmark option")
    public void user_should_see_the_unbookmark_option() {
        
        String unbookmarkText = testContext.getBookmarkPage().getUnbookmark();
      Assert.assertEquals("Unbookmark", unbookmarkText);
       
    }

    @When("User clicks on three dots in bookmarked video")
    public void user_clicks_on_three_dots_in_bookmarked_video() {
       testContext.getBookmarkPage().clickThreeDots();
       testContext.getBookmarkPage().clickBookmarkButton();
       testContext.getBookmarkPage().clickThreeDots();
       
       
        
    }

     @And("clicks on Unbookmark button")
    public void clicks_on_unbookmark_button() {
        testContext.getBookmarkPage().clickUnbookmarkButton();
    }

    @When("User clicks Unbookmark tab")
    public void user_clicks_unbookmark_tab() {
        testContext.getBookmarkPage().clickBookmarkButton();
        testContext.getBookmarkPage().clickThreeDots();
        testContext.getBookmarkPage().clickUnbookmarkButton();
       
    }

    @Then("Toast message Unbookmarked should be displayed")
    public void toast_message_unbookmarked_should_be_displayed(String message) {
        // Code to verify that the specified toast message is displayed
        String unbookmarkToastMessage = testContext.getBookmarkPage().getUnbookmark();
        System.out.println("Unbookmark Toast message: " + unbookmarkToastMessage);
        Assert.assertTrue(unbookmarkToastMessage.contains(message)); // Replace with actual verification logic
    }

    @When("Clicks on Unbookmark")
    public void clicks_on_unbookmark() {
        // Code to click on the "Unbookmark" action
        testContext.getBookmarkPage().clickUnbookmarkButton();
    }
    @When("User clicks on three dots in bookmarked video for bookmark tab")
    public void user_clicks_on_three_dots_in_bookmarked_video_for_bookmark_tab() {
        testContext.getBookmarkPage().clickThreeDots();
        testContext.getBookmarkPage().clickBookmarkButton();
       
    }
 
    @And("Clicks on three dots in bookmarked tab")
    public void clicks_on_three_dots_in_bookmarked_tab() {
        testContext.getBookmarkPage().clickBookmarkDots();
        
    }

    @When("User clicks on Unbookmark in bookmarked tab")
    public void user_clicks_on_unbookmark_in_bookmarked_tab() {
        testContext.getBookmarkPage().clickUnbookmarkInTab();
       
        
    }


}