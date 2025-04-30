package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class videoBlockerSteps {
	
	
	
	@Given("the user navigates to the Video Blocker settings")
	public void the_user_navigates_to_the_video_blocker_settings() { }

	@When("the user enables the video blocker toggle")
	public void the_user_enables_the_video_blocker_toggle() { }

	@When("the user adds the keyword {string}")
	public void the_user_adds_the_keyword(String keyword) { }

	@Then("User should see the videos with the keyword {string} not in the feed list")
	public void user_should_see_the_videos_with_the_keyword_not_in_the_feed_list(String keyword) { }

	@Given("the user is on the Video Blocker settings page")
	public void the_user_is_on_the_video_blocker_settings_page() { }

	@When("the user adds the channel {string} to the block list")
	public void the_user_adds_the_channel_to_the_block_list(String channelName) { }

	@Then("User should see videos from {string} not visible in the feed")
	public void user_should_see_videos_from_not_visible_in_the_feed(String channelName) { }

	@Given("User in video blocker settings as currently enabled")
	public void user_in_video_blocker_settings_as_currently_enabled() { }

	@When("the user disables the video blocker toggle")
	public void the_user_disables_the_video_blocker_toggle() { }

	@Then("User should see all previously blocked videos should appear in the feed")
	public void user_should_see_all_previously_blocked_videos_should_appear_in_the_feed() { }

	@When("the user enters {string} as a channel to block")
	public void the_user_enters_as_a_channel_to_block(String channelName) { }

	@Then("User should see a warning {string} and channel not in list")
	public void user_should_see_a_warning_and_channel_not_in_list(String warningMessage) { }


}
