package stepDefinitions;

import static org.testng.Assert.assertTrue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import context.TestContext;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {

	
	 
	    private TestContext testContext;

	    public LoginSteps(TestContext testContext) {
	        this.testContext = testContext;
	    }
	    // Creating a logger
	    private static Logger logger = LogManager.getLogger();

	    @Given("user is on login page")
	    public void userIsOnLoginPage() {
	        System.out.println("User is on the login page");
	    }

	    @When("user enters username {string} and password {string}")
	    public void userEntersUsernameAndPassword(String username, String password) {
	    	testContext.getLoginPage().enterUsername(username);
	    	testContext.getLoginPage().enterPassword(password);
	    }

	    @When("user clicks the login button")
	    public void userClicksLoginButton() {
	    	testContext.getLoginPage().clickLoginButton();
	        
	    }

	    @Then("login should be {string}")
	    public void loginShouldBe(String status) {
	        if (status.equalsIgnoreCase("success")) {
	            logger.info("Happy path testing for login");
	            assertTrue(testContext.getLoginPage().isProductsPageDisplayed(), "Product page should be visible after successful login");
	        } else {
	        	logger.info("Login negative test cases completed");
	            assertTrue(testContext.getLoginPage().isErrorTextDisplayed(), "Error message should be visible for failed login");
	        }
	    }
    
}
