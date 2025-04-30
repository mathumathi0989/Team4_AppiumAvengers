package stepDefinitions;

import static org.testng.Assert.assertTrue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import context.TestContext;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SubscribeSteps {

	
	 
	    private TestContext testContext;

	    public SubscribeSteps(TestContext testContext) {
	        this.testContext = testContext;
	    }
	    // Creating a logger
	    private static Logger logger = LogManager.getLogger();

	    
	    @Given("User is on Trending tab")
	    public void user_is_on_trending_tab() {
	    	logger.info("App launched and Trending tab showed");
	    	testContext.getTrendingPage().getSkyTubePageTitle();
	    	testContext.getTrendingPage().enterSearch("jingucha");
	     
	    }
	    @When("User click on three dots in any video")
	    public void user_click_on_three_dots_in_any_video() {
	     
	    }
	    @When("click on channel")
	    public void click_on_channel() {
	    	
	    }
	    @Then("User should see the subscribe option")
	    public void user_should_see_the_subscribe_option() {
	    	 System.out.println("user should see the subscribe option");
	       
	    }
	    
	    @When("User click on any video")
	    public void user_click_on_any_video() {
	      
	    }
	    @Then("User should see the subscribe button")
	    public void user_should_see_the_subscribe_button() {
	   	 System.out.println("user should see the subscribe button");
	    }
	  
	    @When("click on subscribe")
	    public void click_on_subscribe() {
	      
	    }
	    @Then("Toast message {string} should be displayed for subscribe")
	    public void toast_message_should_be_displayed_for_subscribe(String string) {
	   	 System.out.println("Toast message displayed for subscribe");
	    }

	    
    
}
