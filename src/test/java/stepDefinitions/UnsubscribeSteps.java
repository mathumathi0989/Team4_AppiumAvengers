package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UnsubscribeSteps {

@When("User open already subscribed video")
public void user_open_already_subscribed_video() {
 
}

@Then("User should see the Unsubscribe option")
public void user_should_see_the_Unsubscribe_option() {
	 System.out.println("user should see the Unsubscribe option");
   
}

@Then("User should see the Unsubscribe button")
public void user_should_see_the_Unsubscribe_button() {
	 System.out.println("user should see the Unsubscribe button");
}

@When("click on Unsubscribe")
public void click_on_Unsubscribe() {
  
}
@Then("Toast message {string} should be displayed for unsubscribe")
public void toast_message_should_be_displayed_for_unsubscribe(String string) {
	 System.out.println("Toast message displayed for unsubscribe");
}






}
