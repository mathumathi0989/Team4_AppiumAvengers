package stepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class videoBlockerSteps {
	
	private static Logger logger = LogManager.getLogger();

	private TestContext testContext;

	
	public videoBlockerSteps(TestContext testContext) {
		this.testContext = testContext;
	}
	
	@Given("User is on the Search tab to block channel")
	public void user_is_on_the_search_tab() {
	  
		testContext.getSearchPage().searchDisplayed();
		logger.info("User in Search Tab");
		
	}

	@When("User searches for a specific channel")
	public void user_searches_for_a_specific_channel() throws IOException {
		String searchText = testContext.getExcelReader().getCellData("Sheet1", 2, 0);
		System.out.println("searchText is " + searchText);
		testContext.getTrendingPage().enterSearch(searchText);
	}

	@When("User clicks the three-dot menu for that channel")
	public void user_clicks_the_three_dot_menu_for_that_channel()  {
		logger.info("User clicks the channel to block");

		testContext.getVideoBlockerPage().clickThreeDots();
		testContext.getVideoBlockerPage().clickChannel();
		
	}

	@Then("User should see the {string} option")
	public void user_should_see_the_option(String expectedOption) {
		
	    Assert.assertTrue(testContext.getVideoBlockerPage().isOptionVisible(expectedOption));	    
	}

	@Given("User is on the Video Blocker settings page")
	public void user_is_on_the_video_blocker_settings_page() throws IOException {
		String searchText = testContext.getExcelReader().getCellData("Sheet1", 2, 0);
		System.out.println("searchText is " + searchText);
		testContext.getTrendingPage().enterSearch(searchText);
		testContext.getVideoBlockerPage().clickThreeDots();
		testContext.getVideoBlockerPage().clickChannel();		
		testContext.getVideoBlockerPage().clickBlockChannel(); 
		
		logger.info("User clicks the channel to block and view list");
	}

	@When("User selects either the Deny List or Allow List")
	public void user_selects_either_the_deny_list_or_allow_list() {
		logger.info("User views the dent or allow list");
		testContext.getVideoBlockerPage().clickPreferences();
		testContext.getVideoBlockerPage().clickvideoBlockoption();
		testContext.getVideoBlockerPage().viewChannelDenyList();
		

	}

	@Then("User should see videos listed in the Block List")
	public void user_should_see_videos_listed_in_the_block_list() {
		logger.info("User views the dent or allow list");

		 List<String> blockedChannels = testContext.getVideoBlockerPage().getBlockedChannelNames();
		    
		    // Assert that list is not empty
		    Assert.assertFalse(blockedChannels.isEmpty(), "No channels are listed in the Block List!");

		    // Print the blocked channel names
		    System.out.println("Blocked Channels:");
		    for (String channel : blockedChannels) {
		        System.out.println("- " + channel);
		    }
		
	}

	@Given("User is on the Video Blocker settings page to unblock")
	public void User_is_on_the_Video_Blocker_settings_page_to_unblock() {
		testContext.getVideoBlockerPage().clickPreferences();
		testContext.getVideoBlockerPage().clickvideoBlockoption();
		testContext.getVideoBlockerPage().viewChannelDenyList();

	}

	@When("User unblocks either the Deny List or Allow List")
	public void User_unblocks_either_the_Deny_List_or_Allow_List() {
	   
		testContext.getVideoBlockerPage().selectAllBlockedChannels();
		testContext.getVideoBlockerPage().unblockChannel();
		testContext.getVideoBlockerPage().clickBack();
		
		testContext.getVideoBlockerPage().clickBack();
		logger.info("User unblocks the channel list ");

		
	}

	@Then("User should see videos in playlist")
	public void User_should_see_videos_in_playlist() {
		logger.info("User views unblocked playlist in skytube");
		
		
		

	}



}
