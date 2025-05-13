package utils;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class reusableFunctions {

	 private WebDriver driver;
	    private WebDriverWait wait;
	    
	    public reusableFunctions(WebDriver driver, int timeoutInSeconds) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    }

	    public WebElement waitForElementVisible(By locator) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
	    
	 
	    public WebElement waitForElementPresence(By locator) {
	        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    }
	    
	    public void clickElement(By locator) {
	        WebElement element = waitForElementVisible(locator);  
	        element.click();  
	    }


	    public String getTextFromElement(By locator) {
	        WebElement element = waitForElementVisible(locator);  
	        return element.getText(); 
	    }
	    
	    public Dimension getScreenSize() {
	    	Dimension size = driver.manage().window().getSize();
	    	System.out.println("Screen size: " + size);
	    	return size;
	    }
	    
	    public void tapUsingPointerInput(int x, int y) {
	    	getScreenSize();
	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

	        Sequence tap = new Sequence(finger, 1)
	            .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
	            .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	            .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	        ((RemoteWebDriver) driver).perform(Arrays.asList(tap));
	        
	    
	    }
	    
}
