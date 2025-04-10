package pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import utils.reusableFunctions;

public class productsPage {
	
	 private AppiumDriver driver;
	  reusableFunctions actions;
	  
	 
	  private By viewCartButton = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup");
	  private By checkoutButton = AppiumBy.accessibilityId("test-CHECKOUT");
	  private By firstName = AppiumBy.accessibilityId("test-First Name");
	  private By lastName = AppiumBy.accessibilityId("test-Last Name");
	  private By zipCode = AppiumBy.accessibilityId("test-Zip/Postal Code");
	  private By continueButton = AppiumBy.androidUIAutomator("new UiSelector().text(\"CONTINUE\")");
	  private By finishButton = AppiumBy.accessibilityId("test-FINISH");
	  private By backHomeButton = AppiumBy.accessibilityId("test-BACK HOME");
	  
	  
	  public productsPage(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
        actions = new reusableFunctions(appiumDriver, 30);// Pass driver to LoginPage
 	   
    }
	
	  public void addProductToCart(String prodName) {
		  String uiScrollables = "new UiScrollable(new UiSelector().scrollable(true))"
                  + ".scrollIntoView(new UiSelector().text(\"" + prodName + "\"))";

driver.findElement(AppiumBy.androidUIAutomator(uiScrollables));

	   driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+prodName+"']/ancestor::android.view.ViewGroup[1]//android.view.ViewGroup[@content-desc='test-ADD TO CART']\n")).click();
	 
	    }
	  
	  public String getProductPrice(String prodName) {
		  String prodPrice = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+prodName+"']/ancestor::android.view.ViewGroup[1]//android.widget.TextView[@content-desc=\"test-Price\"]")).getText();
		return prodPrice;
	  }
	
	  public void clickViewCart() {
		   actions.waitForElementVisible(viewCartButton);
		  driver.findElement(viewCartButton).click();
	  }
	  
	  
	  public void clickCheckout() {
		  actions.waitForElementVisible(checkoutButton);
		  driver.findElement(checkoutButton).click();
	  }
	
	  
	  public void clickContinue() {
		  actions.waitForElementVisible(continueButton);
		  driver.findElement(continueButton).click();
	  }
	  
	  public void clickFinish() {
	//	  actions.waitForElementVisible(finishButton);
		  driver.findElement(AppiumBy.androidUIAutomator(
				    "new UiScrollable(new UiSelector().scrollable(true))" +
				    ".scrollIntoView(new UiSelector().text(\"FINISH\"))"
				));

		  driver.findElement(finishButton).click();
	  }
	 
	  
	  public void clickBackHome() {
		  actions.waitForElementVisible(backHomeButton);
		  driver.findElement(backHomeButton).click();
	  }
	  
	  public String getCheckoutProdName(String prodName) {  
		  String checkoutProdName = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+prodName+"']")).getText();
		return checkoutProdName;
	  }
	  
	  public String getCheckoutProductPrice(String prodName) {
		  String checkoutProdPrice = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='\"+prodName+\"']/ancestor::android.view.ViewGroup[@content-desc=\"test-Item\"]/android.view.ViewGroup[@content-desc=\"test-Price\"]")).getText();
		return checkoutProdPrice;
	  }
	  
	  public String getSuccessMessage() {
		  
		  String successMessage = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]")).getText();
		  return successMessage;
	  }
	  
	  public void getCheckoutDetails(String tempFirstName, String tempLastName, String tempZipcode) {
		//  String tempFirstName = testContext.getExcelReader().getCellData("Sheet1", 1, 0);
		  driver.findElement(firstName).sendKeys(tempFirstName);
		  driver.findElement(lastName).sendKeys(tempLastName);
		  driver.findElement(zipCode).sendKeys(tempZipcode);
	  }
	
	  
	  
	
	  
	  
	  
	  
}
