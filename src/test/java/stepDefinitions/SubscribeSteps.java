package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import context.TestContext;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SubscribeSteps {

	
	 
	    private TestContext testContext;
	    private String actualText;
	    private String searchText;
	    private String expectedChannelTitle;
	    public SubscribeSteps(TestContext testContext) {
	        this.testContext = testContext;
	    }
	    // Creating a logger
	    private static Logger logger = LogManager.getLogger();

	    
	    @Given("User is on Trending tab")
	    public void user_is_on_trending_tab() throws Exception {
	    	logger.info("App launched and Trending tab showed");
	    	testContext.getTrendingPage().getSkyTubePageTitle();
	    }
	    
	    @Given("User opens any video")
	    public void user_opens_any_video() throws Exception {
	    	searchText = testContext.getExcelReader().getCellData("Sheet1", 2, 0);
	    	System.out.println("searchText is "+searchText);
	    	testContext.getTrendingPage().enterSearch(searchText); 
	    }
	    
	    
	    @When("User click on three dots in any video")
	    public void user_click_on_three_dots_in_any_video() {
	    	testContext.getTrendingPage().clickThreeDots();
	    }
	    
	    @When("click on channel")
	    public void click_on_channel() {
	    	testContext.getTrendingPage().clickChannel();
	    }
	    
	    @Then("User should see the subscribe option")
	    public void user_should_see_the_subscribe_option() {
	    	String expectedText = testContext.getSubscribePage().getSubscribe();
	    	Assert.assertEquals("Subscribe", expectedText);
	    }
	    
	    @When("User click on any video")
	    public void user_click_on_any_video() {
	    	testContext.getSubscribePage().clickVideo();
	    }
	    @Then("User should see the subscribe button")
	    public void user_should_see_the_subscribe_button() {
	    	String expectedText = testContext.getSubscribePage().getSubscribeButton();
	    	Assert.assertEquals("SUBSCRIBE", expectedText);
	    }
	  
	    @When("click on subscribe")
	    public void click_on_subscribe() {
	    	 expectedChannelTitle = testContext.getSubscribePage().getChannelTitle();
	    	testContext.getSubscribePage().clickSubscribeButton();
	    	System.out.println("subscribe button clicked");
	    	testContext.getSubscribePage().clickBack();
	    	testContext.getSubscribePage().clickBack();
	    	testContext.getTrendingPage().clickMenu();
	 
	  
	    }
	    
	    @When("click on subscribe link")
	    public void click_on_subscribe_link() {
	    	
	    	testContext.getSubscribePage().clickSubscribeLink();
	    	expectedChannelTitle = testContext.getSubscribePage().getChannelVideoTitle();
	    	testContext.getSubscribePage().clickBack();
	    	testContext.getTrendingPage().clickMenu();
	    	
	    }
	    
	    @Then("subscribed channel display under subscriptions")
	    public void subscribed_channel_display_under_subscriptions() {
//	    	WebElement actualToast = testContext.getSubscribePage().verifyToastPresence();
//	    	 Assert.assertNotNull(actualToast, "Expected toast message did not appear");
	    	String actualText = testContext.getSubscribePage().getSubscriptionName();
	    	System.out.println("Subscribed name is "+actualText);
	    	Assert.assertEquals(actualText, expectedChannelTitle);
	    	
	    }

	    
    
}
