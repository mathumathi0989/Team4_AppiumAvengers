package stepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchChannelSteps {

	private static Logger logger = LogManager.getLogger();

	private TestContext testContext;

	public searchChannelSteps(TestContext testContext) {
		this.testContext = testContext;
	}

	@Given("User launched the app")
	public void user_launched_the_app() {

		testContext.getTrendingPage().getSkyTubePageTitle();

	}

	@Given("User is on the Home screen")
	public void user_is_on_the_home_screen() {

		testContext.getSearchPage().searchDisplayed();
		logger.info("User in Search Tab");

	}

	@When("User taps on the search icon and enters a valid channel name")
	public void user_taps_on_the_search_icon_and_enters_a_valid_channel_name() throws IOException {

		String searchText = testContext.getExcelReader().getCellData("Sheet1", 2, 0);
		System.out.println("searchText is " + searchText);
		testContext.getTrendingPage().enterSearch(searchText);
	}

	@Then("Use should see matching channel results displayed")
	public void use_should_see_matching_channel_results_displayed() {
		Assert.assertTrue(testContext.getSearchPage().isSearchResultDisplayed());

	}

	@Given("User has a valid channel search results returned")
	public void user_has_a_valid_channel_search_results_returned() throws IOException {

		testContext.getSearchPage().searchDisplayed();
		logger.info("User in Search Tab");
		String searchText = testContext.getExcelReader().getCellData("Sheet1", 2, 0);
		System.out.println("searchText is " + searchText);
		testContext.getTrendingPage().enterSearch(searchText);

	}

	@When("User taps on a channel name from the results")
	public void user_taps_on_a_channel_name_from_the_results() {

		testContext.getSearchPage().clickfirstResult();
	}

	@Then("User should be navigated to the channel page")
	public void user_should_be_navigated_to_the_channel_page() {

		testContext.getSearchPage().getChannelTitle();
		logger.info("Title of search Channel");

	}

	@Given("User is on the search tab")
	public void user_is_on_the_search_tab() {

		testContext.getSearchPage().searchDisplayed();
		logger.info("User in Search Tab");
	}

	@When("User enters a channel name in mixed case Ex:\"NatGeo\"")
	public void user_enters_a_channel_name_in_mixed_case_ex_natgeo() throws IOException {

		String searchText = testContext.getExcelReader().getCellData("Sheet1", 3, 0);
		System.out.println("searchText is " + searchText);
		testContext.getTrendingPage().enterSearch(searchText);

	}

	@Then("User should see matching channels should still appear")
	public void user_should_see_matching_channels_should_still_appear() {
		Assert.assertTrue(testContext.getSearchPage().isSearchResultDisplayed());

	}

	@When("User enters a part of a known channel name")
	public void user_enters_a_part_of_a_known_channel_name() throws IOException {

		String searchText = testContext.getExcelReader().getCellData("Sheet1", 4, 0);
		System.out.println("searchText is " + searchText);
		testContext.getTrendingPage().enterSearch(searchText);

	}

	@Then("User able to see related suggestions appeared")
	public void user_able_to_see_related_suggestions_appeared() {
		Assert.assertTrue(testContext.getSearchPage().isSearchResultDisplayed());

	}

	@When("User enters search input with spaces")
	public void User_enters_search_input_with_space()throws IOException {

		String searchText = testContext.getExcelReader().getCellData("Sheet1", 5, 0);
		System.out.println("searchText is " + searchText);
		testContext.getTrendingPage().enterSearch(searchText);

	}

	@Then("User should see results shown for \"AB C\"")
	public void user_should_see_results_shown_for_ab_c() {

		Assert.assertTrue(testContext.getSearchPage().isSearchResultDisplayed());

	}

	@Given("User is on the search Tab with searched channel details before")
	public void user_is_on_the_search_tab_with_searched_channel_details_before() {

		testContext.getSearchPage().searchTabVisible();
		logger.info("User is in Saecrh Tab");

	}

	@When("User clicks the search bar again")
	public void user_clicks_the_search_bar_again() {

		testContext.getSearchPage().clickSearchTab();
	}

	@Then("Recent searches should appear")
	public void recent_searches_should_appear() {

		Assert.assertTrue(testContext.getSearchPage().isSearchResultDisplayed());

	}

//	@When("User enters a random or invalid string")
//	public void user_enters_a_random_or_invalid_string() throws IOException {
//		
//		String searchText = testContext.getExcelReader().getCellData("Sheet1", 6, 0);
//    	System.out.println("searchText is "+searchText);
//    	testContext.getTrendingPage().enterSearch(searchText); 
//	
//		
//	}
//
//	@Then("\"No results found\" message should appear")
//	public void no_results_found_message_should_appear() {
//		
//		
//	}

	@When("User enters \"@#$%^&\"")
	public void user_enters_special_characters() throws IOException {
		String searchText = testContext.getExcelReader().getCellData("Sheet1", 7, 0);
		System.out.println("searchText is " + searchText);
		testContext.getTrendingPage().enterSearch(searchText);

	}

	@Then("No results should appear, and the app should not crash")
	public void no_results_should_appear_and_the_app_should_not_crash() {

		Assert.assertFalse(testContext.getSearchPage().isSearchResultDisplayed());

	}

	@When("User presses search without typing anything")
	public void user_presses_search_without_typing_anything() {
 
		testContext.getSearchPage().emptySearch();
	}

	@Then("Either all results should be shown or a message “Please enter search query”")
	public void either_all_results_should_be_shown_or_message_enter_search_query() {

		boolean isResultDisplayed = testContext.getSearchPage().isSearchResultDisplayed();
		boolean isValidationMessageDisplayed = testContext.getSearchPage()
				.isValidationMessageDisplayed("Please enter search query");

		Assert.assertTrue(isResultDisplayed || isValidationMessageDisplayed);

//    Assert.assertTrue("Neither search results nor validation message appeared.",
//            isResultDisplayed || isValidationMessageDisplayed);

	}

	@Given("the network is disabled")
	public void the_network_is_disabled() throws IOException {
		//copied code
		Runtime.getRuntime().exec("adb shell svc wifi disable");
	}
	

	@When("User tries to search")
	public void user_tries_to_search() throws IOException {
		
		String searchText = testContext.getExcelReader().getCellData("Sheet1", 8, 0);
		System.out.println("searchText is " + searchText);
		testContext.getTrendingPage().enterSearch(searchText);
	}

	@Then("an error toast or message like \"No internet connection\" should be displayed")
	public void an_error_toast_or_message_should_be_displayed() {
		
		Assert.assertTrue(testContext.getSearchPage().isNetworkErrorMessageShown());
	}

}
