package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ScrollExample extends BaseTest{

	//@Test
	public void jsExecutorScroll() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		jse.executeScript("window.scrollBy(0, 2000)");
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 2000).perform();
	}
	
	//@Test
	public void scrollToElement() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		
		WebElement signUpButton = driver.findElement(By.cssSelector("input[value='Sign up']"));
		//Javascript executor scroll to Element
		//jse.executeScript("arguments[0].scrollIntoView();", signUpButton);
		
		//Actions class move to element
		action.moveToElement(signUpButton).perform(); // se opreste cand da de Sign up..si este vizibil in josul paginii
		Thread.sleep(3000);	
	}
	
	@Test
	public void scrollTopAndDown() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//scroll down
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // scroll pe toata inaltimea, pana jos
		Thread.sleep(3000);	
		
		//scroll up
		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)"); // scroll pe toata inaltimea, pana sus
		
	}
}
