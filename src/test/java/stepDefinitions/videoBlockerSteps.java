package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	
	@Given("User is on the Search tab")
	public void user_is_on_the_search_tab() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User searches for a specific channel")
	public void user_searches_for_a_specific_channel() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks the three-dot menu for that channel")
	public void user_clicks_the_three_dot_menu_for_that_channel() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should see the {string} option")
	public void user_should_see_the_option(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User is on the Video Blocker settings page")
	public void user_is_on_the_video_blocker_settings_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User selects either the Deny List or Allow List")
	public void user_selects_either_the_deny_list_or_allow_list() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should see videos listed in the Block List")
	public void user_should_see_videos_listed_in_the_block_list() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Video Blocker is currently enabled in settings")
	public void video_blocker_is_currently_enabled_in_settings() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User disables the Video Blocker toggle")
	public void user_disables_the_video_blocker_toggle() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Blocked videos should now be visible in the list")
	public void blocked_videos_should_now_be_visible_in_the_list() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



}
