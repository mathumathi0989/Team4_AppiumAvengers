package pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.reusableFunctions;

public class productsPage {
	
	 private AndroidDriver driver;
	  reusableFunctions actions;
	  
	 
	  private By viewCartButton = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup");
	  
	public productsPage(AndroidDriver driver) {
        this.driver = driver;
        actions = new reusableFunctions(driver, 30);// Pass driver to LoginPage
 	   
    }
	
	  public void addProductToCart(String prodName) {
		//android.widget.TextView[@content-desc="test-Item title" and @text="Sauce Labs Backpack"]
	    //driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\""+prodName+"\"]")).click(); 
	    driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+prodName+"']/ancestor::android.view.ViewGroup[1]//android.view.ViewGroup[@content-desc='test-ADD TO CART']\n"));
	  
	    }
	  
	  public String getProductPrice(String prodName) {
		  String prodPrice = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+prodName+"']/ancestor::android.view.ViewGroup[1]//android.widget.TextView[@content-desc=\"test-Price\"]")).getText();
		return prodPrice;
	  }
	
	  public void clickViewCart() {
		  driver.findElement(viewCartButton).click();
	  }
	  
	  
	
		
}
