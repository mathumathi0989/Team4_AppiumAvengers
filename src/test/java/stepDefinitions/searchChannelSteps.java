package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchChannelSteps {

	 
    private TestContext testContext;

    public searchChannelSteps(TestContext testContext) {
        this.testContext = testContext;
    }
    // Creating a logger
    private static Logger logger = LogManager.getLogger();
	
	@Given("User launched the app")
	public void user_launched_the_app() { }

	@Given("User is on the Home screen")
	public void user_is_on_the_home_screen() { }

	@When("User taps on the search icon and enters a valid channel name")
	public void user_taps_on_the_search_icon_and_enters_a_valid_channel_name() { }

	@Then("Use should see matching channel results displayed")
	public void use_should_see_matching_channel_results_displayed() { }

	@Given("User has a valid channel search results returned")
	public void user_has_a_valid_channel_search_results_returned() { }

	@When("User taps on a channel name from the results")
	public void user_taps_on_a_channel_name_from_the_results() { }

	@Then("User should be navigated to the channel page")
	public void user_should_be_navigated_to_the_channel_page() { }

	@Given("User is on the search tab")
	public void user_is_on_the_search_tab() { }

	@When("User enters a channel name in mixed case Ex:\"NatGeo\"")
	public void user_enters_a_channel_name_in_mixed_case_ex_natgeo() { }

	@Then("User should see matching channels should still appear")
	public void user_should_see_matching_channels_should_still_appear() { }

	@When("User enters a part of a known channel name")
	public void user_enters_a_part_of_a_known_channel_name() { }

	@Then("User able to see related suggestions appeared")
	public void user_able_to_see_related_suggestions_appeared() { }

	@Given("User in on the search Tab")
	public void user_in_on_the_search_tab() { }

	@When("User enters \" AB C \" \\(with spaces)")
	public void user_enters_ab_c_with_spaces() { }

	@Then("User should see results shown for \"AB C\"")
	public void user_should_see_results_shown_for_ab_c() { }

	@Given("User is on the search Tab with searched channel details before")
	public void user_is_on_the_search_tab_with_searched_channel_details_before() { }

	@When("User clicks the search bar again")
	public void user_clicks_the_search_bar_again() { }

	@Then("Recent searches should appear")
	public void recent_searches_should_appear() { }

	@When("User enters a random or invalid string")
	public void user_enters_a_random_or_invalid_string() { }

	@Then("\"No results found\" message should appear")
	public void no_results_found_message_should_appear() { }

	@Given("User enters search input accepts text")
	public void user_enters_search_input_accepts_text() { }

	@When("User enters \"@#$%^&\"")
	public void user_enters_special_characters() { }

	@Then("No results should appear, and the app should not crash")
	public void no_results_should_appear_and_the_app_should_not_crash() { }

	@When("User presses search without typing anything")
	public void user_presses_search_without_typing_anything() { }

	@Then("Either all results should be shown or a message “Please enter search query”")
	public void either_all_results_should_be_shown_or_message_enter_search_query() { }

	@Given("the network is disabled")
	public void the_network_is_disabled() { }

	@When("User tries to search")
	public void user_tries_to_search() { }

	@Then("an error toast or message like \"No internet connection\" should be displayed")
	public void an_error_toast_or_message_should_be_displayed() { }

	@Given("User is on the search Tab \\(multiple fast search inputs)")
	public void user_is_on_the_search_tab_multiple_fast_search_inputs() { }

	@When("User enters and deletes quickly")
	public void user_enters_and_deletes_quickly() { }

	@Then("the app should not freeze or crash")
	public void the_app_should_not_freeze_or_crash() { }

}
