package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UnsubscribeSteps {

    private TestContext testContext;

    public UnsubscribeSteps(TestContext testContext) {
        this.testContext = testContext;
    }
    private static Logger logger = LogManager.getLogger();
    private String actualChannelTitle;
    
  	@When("User open already subscribed video")
  	public void user_open_already_subscribed_video() {
      	testContext.getTrendingPage().enterSearch("thanyasreevlog"); 
      	testContext.getSubscribePage().clickAlreadyVideo();
       	testContext.getSubscribePage().clickSubscribeButton();
       	actualChannelTitle = testContext.getSubscribePage().getChannelTitle();
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
     	testContext.getSubscribePage().clickBack();
     	testContext.getSubscribePage().clickBack();
    	testContext.getTrendingPage().clickMenu();
      	
  	}
  	
  	@Then("channel should not display under subscription list")
  	public void channel_should_not_display_under_subscription_list() {
  		boolean isPresent = testContext.getSubscribePage().isChannelPresentInSubscriptions(actualChannelTitle);
  		Assert.assertFalse(isPresent, "Channel '" + actualChannelTitle + "' should NOT be present in subscriptions list.");
  		logger.info("User unsubscribed the channel");  	
     
  	}






}
