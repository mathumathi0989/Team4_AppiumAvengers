package stepDefinitions;

import static org.testng.Assert.assertTrue;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.reusableFunctions;

public class LoginSteps {

	 private LoginPage loginPage;
	
	    public LoginSteps(TestContext testContext) {
	        this.loginPage = testContext.getLoginPage();  // Get LoginPage from TestContext
	    }

	    @Given("user is on login page")
	    public void userIsOnLoginPage() {
	        System.out.println("User is on the login page");
	    }

	    @When("user enters username {string} and password {string}")
	    public void userEntersUsernameAndPassword(String username, String password) {
	        loginPage.enterUsername(username);
	        loginPage.enterPassword(password);
	    }

	    @When("user clicks the login button")
	    public void userClicksLoginButton() {
	        loginPage.clickLoginButton();
	        
	    }

	    @Then("login should be {string}")
	    public void loginShouldBe(String status) {
	        if (status.equalsIgnoreCase("success")) {
	        	
	            assertTrue(loginPage.isProductsPageDisplayed(), "Product page should be visible after successful login");
	        } else {
	            assertTrue(loginPage.isErrorTextDisplayed(), "Error message should be visible for failed login");
	        }
	    }
    
}
