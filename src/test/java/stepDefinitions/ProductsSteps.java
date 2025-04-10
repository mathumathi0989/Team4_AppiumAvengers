package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigManager;


public class ProductsSteps {

	  
	    private TestContext testContext;

	    public ProductsSteps(TestContext testContext) {
	        this.testContext = testContext;
	    }
	    
	    // Creating a logger
	    private static Logger logger = LogManager.getLogger();
	    
	@Given("user is on product page")
	public void user_is_on_product_page() {
		testContext.getLoginPage().enterUsername(ConfigManager.getProperty("validUserName"));
		testContext.getLoginPage().enterPassword(ConfigManager.getProperty("validPassword"));
		testContext.getLoginPage().clickLoginButton();
	        
	}
	@When("user enters {string} and click search")
	public void user_enters_and_click_search(String productName) {
	   logger.info("Product Selected to place an order");
	   testContext.getProductPage().addProductToCart(ConfigManager.getProperty("productName"));
		
	}
	@When("select that product and proceed the checkout process")
	public void select_that_product_and_proceed_the_checkout_process() throws Exception {
		   testContext.getProductPage().clickViewCart();
		   testContext.getProductPage().clickCheckout();
		   String tempFirstName = testContext.getExcelReader().getCellData("Sheet1", 1, 0);
			String tempLastName = testContext.getExcelReader().getCellData("Sheet1", 1, 1);
			 String tempZipCode = testContext.getExcelReader().getCellData("Sheet1", 1, 2);
		   testContext.getProductPage().getCheckoutDetails(tempFirstName, tempLastName, tempZipCode);
		   testContext.getProductPage().clickContinue();
		   testContext.getProductPage().clickFinish();
	}
	
	@Then("validate if user get successfull message {string}")
	public void validate_if_user_get_successfull_message(String expectedSucessMessage) {
		  String actualMessage = testContext.getProductPage().getSuccessMessage();
		  Assert.assertEquals(actualMessage, expectedSucessMessage);
		  logger.info("Order placed");
	}
	
}
