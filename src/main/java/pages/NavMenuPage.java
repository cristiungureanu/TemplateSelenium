package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumWrappers;

public class NavMenuPage extends SeleniumWrappers{

	
	public NavMenuPage(WebDriver driver) {
		super(driver);
	}
	

	public By shopLink = By.linkText("BOOKS");
	public By loginLink = By.linkText("Login");
	public By contactLink = By.linkText("CONTACTS");
	public By singleAuthor = By.linkText("SINGLE AUTHOR");
	public By blog = By.linkText("BLOG");
	public By aboutLink = By.linkText("ABOUT");
	public By postFormatsBlogLink = By.linkText("Post Formats");
	
	public By searchIcon = By.cssSelector("button[class*='search_submit']");
	public By searchField =By.cssSelector("input[class*='search_field']");
	
	public By product = By.xpath("//div[@id='sc_tab_1456822345_1_17']/descendant::a[contains(@href,'garden')]");
	
	public void navigateTo(By locator) {
		
		driver.findElement(locator).click();
	}
	
	
	public void searchBook(String value) {
		click(searchIcon);
		sendKeys(searchField, value);
		click(searchIcon);
	}
	
	public boolean isBookPictureDisplayed(String picture) {
		WebElement element =  driver.findElement(By.cssSelector("div[data-image*='"+picture+"']"));
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
	}
	
}
