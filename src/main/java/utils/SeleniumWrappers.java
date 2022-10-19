package utils;


import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrappers {

	public WebDriver driver;
	
	public SeleniumWrappers(WebDriver driver) {
		
		this.driver = driver;
	}
	
	/**
	 * Custom sendKeys method/ Wraps selenium default SendKeys and enhance it
	 * with clear() method before sending the text
	 * @param locator --> used inside method to create a WebElement object
	 * @param value --> String value 
	 */
	
	
	public void sendKeys(By locator, String value) {
			
		WebElement element = driver.findElement(locator);
		
		try {
			element.clear();
			element.sendKeys(value);
			
		}catch(Exception e) {
			System.out.println("Something went wrong");
		}
		}
	
	public void click(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			element.click();
		}catch(NoSuchElementException e) {
			System.out.println("Something went wrong");
		}catch(StaleElementReferenceException e) {
			WebElement element2 = driver.findElement(locator);
			element2.click();
		}
	}
	
	public void waitForElementToBeClickable(WebElement element) {
			
			WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	
	public void dragAndDrop (By locator, int x, int y) {
		
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, x, y);
		
		
	}

	public void hoverElement(By locator) {	
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();	
	}
	
	public String readUrl() {
		System.out.println("");
		return driver.getCurrentUrl();
	}
	
	
}
