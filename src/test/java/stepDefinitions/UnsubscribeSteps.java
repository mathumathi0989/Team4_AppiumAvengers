package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UnsubscribeSteps {

    private TestContext testContext;

    public UnsubscribeSteps(TestContext testContext) {
        this.testContext = testContext;
    }
    // Creating a logger
    private static Logger logger = LogManager.getLogger();

    
  	@When("User open already subscribed video")
  	public void user_open_already_subscribed_video() {
      	testContext.getTrendingPage().enterSearch("thanyasreevlog"); 
      	testContext.getSubscribePage().clickAlreadyVideo();
       	testContext.getSubscribePage().clickSubscribeButton();
       	testContext.getSubscribePage().clickBack();
  	}

  	 @When("click on open channel")
  	    public void click_on_open_channel() {
  	    	testContext.getTrendingPage().clickOpenChannel();
  	    	try {
  	    	testContext.getTrendingPage().getAlertNotification();
  	    	}
  	    	catch(Exception e) {}
  	    	
  	    }
  	    
  	
  	
  	@Then("User should see the Unsubscribe option")
  	public void user_should_see_the_Unsubscribe_option() {
  		String expectedText = testContext.getSubscribePage().getUnsubscribe();
      	Assert.assertEquals("Unsubscribe", expectedText);
      	
  	   
  	}

  	@Then("User should see the Unsubscribe button")
  	public void user_should_see_the_Unsubscribe_button() {
  		testContext.getSubscribePage().clickAlreadyVideo();
  		String expectedText = testContext.getSubscribePage().getunSubscribeButton();
      	Assert.assertEquals("UNSUBSCRIBE", expectedText);
  	}

  	@When("click on Unsubscribe")
  	public void click_on_Unsubscribe() {
  		testContext.getSubscribePage().clickAlreadyVideo();
  		testContext.getSubscribePage().clickUnSubscribeButton();
      	System.out.println("UnSubscribe button clicked");
  	}
  	
  	@Then("Toast message {string} should be displayed for unsubscribe")
  	public void toast_message_should_be_displayed_for_unsubscribe(String string) {
  		WebElement actualToast = testContext.getSubscribePage().verifyToastPresence();
     	 Assert.assertNotNull(actualToast, "Expected toast message did not appear");
     	 
  	}






}
