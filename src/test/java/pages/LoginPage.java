package pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import utils.reusableFunctions;

public class LoginPage {
	 private AppiumDriver driver;
	  reusableFunctions actions;
	    private By userNameField = AppiumBy.accessibilityId("test-Username");
	    private By passwordField = AppiumBy.accessibilityId("test-Password");
	    private By loginButton = AppiumBy.androidUIAutomator("new UiSelector().text(\"LOGIN\")");
	    private By productsPage = AppiumBy.androidUIAutomator("new UiSelector().text(\"PRODUCTS\")");
	    private By errorText = AppiumBy.androidUIAutomator("new UiSelector().text(\"Username and password do not match any user in this service.\")");
	    private By menu = AppiumBy.accessibilityId("test-Menu");
	    private By logout = AppiumBy.androidUIAutomator("new UiSelector().text(\"LOGOUT\")");
	    
	    
	    
	    public LoginPage(AppiumDriver driver) {
	        this.driver = driver;
	  actions = new reusableFunctions(driver, 30);// Pass driver to LoginPage
	 	   
	    }

	    public void enterUsername(String username) {
	        driver.findElement(userNameField).sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickLoginButton() {
	        driver.findElement(loginButton).click();
	        
	    }

	    public boolean isProductsPageDisplayed() {
	    		actions.waitForElementVisible(productsPage);
	    	boolean isProductDisplayed = driver.findElement(productsPage).isDisplayed();
	         if(isProductDisplayed) {
	        	 clickMenuButton();
	        	 clickLogoutLink();
	         }
	         return isProductDisplayed;
	    }

	    public boolean isErrorTextDisplayed() {
	        return driver.findElement(errorText).isDisplayed();
	    }
	    
	    public void clickMenuButton() {
	    	driver.findElement(menu).click();
	    }
	    
	    public void clickLogoutLink() {
	    	driver.findElement(logout).click();
	    }
}
