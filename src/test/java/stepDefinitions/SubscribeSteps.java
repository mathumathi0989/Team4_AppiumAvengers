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
	    
	      System.out.println("user is on trending tab");
	    }
	    @When("User click on three dots in any video")
	    public void user_click_on_three_dots_in_any_video() {
	       System.out.println("user clicks three dots");
	    }
	    @When("click on channel")
	    public void click_on_channel() {
	    	 System.out.println("user clicks on channel");
	    }
	    @Then("User should see the {string} option")
	    public void user_should_see_the_option(String string) {
	    	 System.out.println("user should see the subscribe");
	       
	    }
    
}
