package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import context.TestContext;
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

    // @Given("User launched the app")
    // public void user_launched_the_app() {
    //     // Code to launch the app (e.g., using Appium)
    //     System.out.println("Launching the app...");
    // }

    // @Given("User is on Trending tab")
    // public void user_is_on_trending_tab() {
    //     // Code to navigate to the Trending tab
    //     System.out.println("Navigating to the Trending tab...");
    // }

    @When("User clicks Bookmark tab")
    public void user_clicks_bookmark_tab() {
        testContext.getBookmarkPage().clickBookmarkTab();
        // Code to click on the Bookmark tab
    }

    @Then("The user should see the message {string}")
    public void the_user_should_see_the_message(String message) {
        // Code to verify that the specified message is displayed
        String noBookmarkedVideosText = testContext.getBookmarkPage().getNoBookmarkedVideosText();
        System.out.println("No Bookmarked Videos text: " + noBookmarkedVideosText);
        Assert.assertTrue(noBookmarkedVideosText.contains(message)); // Replace with actual verification logic

    
    }

    @When("User clicks on three dots in any video")
    public void user_clicks_on_three_dots_in_any_video() {
       testContext.getBookmarkPage().clickThreeDots();
        // Code to click on the three dots in any video
        System.out.println("Clicking on three dots in any video...");
    }

    @Then("User should see the Bookmark option")
    public void user_should_see_the_bookmark_option() {
        // Code to verify that the "Bookmark" option is displayed

        String bookmarkText = testContext.getBookmarkPage().getBookmark();
        System.out.println("Bookmark text: " + bookmarkText);
        Assert.assertTrue(bookmarkText.contains("Bookmark")); // Replace with actual verification logic
    }

    @When("Clicks on Bookmark")
    public void clicks_on_bookmark() {
      testContext.getBookmarkPage().clickBookmarkLink();
        // Code to click on the "Bookmark" action
        System.out.println("Clicking on the Bookmark action...");
    }

    @Then("Toast message {string} should be displayed")
    public void toast_message_should_be_displayed(String message) {
        // Code to verify that the specified toast message is displayed
        String toastMessage = testContext.getBookmarkPage().getBookmark();
        System.out.println("Toast message: " + toastMessage);
        Assert.assertTrue(toastMessage.contains(message)); // Replace with actual verification logic
    }

    @Then("User should see the Unbookmark option")
    public void user_should_see_the_unbookmark_option() {
        // Code to verify that the "Unbookmark" option is displayed
        String unbookmarkText = testContext.getBookmarkPage().getUnbookmark();
        System.out.println("Unbookmark text: " + unbookmarkText);
        Assert.assertTrue(unbookmarkText.contains("Unbookmark")); // Replace with actual verification logic
    }

    @When("User clicks on three dots in bookmarked video")
    public void user_clicks_on_three_dots_in_bookmarked_video() {
       testContext.getBookmarkPage().clickThreeDots();
        // Code to click on the three dots in a bookmarked video
        System.out.println("Clicking on three dots in bookmarked video...");
    }

    @When("User clicks Unbookmark tab")
    public void user_clicks_unbookmark_tab() {
        testContext.getBookmarkPage().clickUnbookmarkLink();
        // Code to navigate to the Unbookmark tab
        System.out.println("Navigating to the Unbookmark tab...");
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
        testContext.getBookmarkPage().clickUnbookmarkLink();
    }
}