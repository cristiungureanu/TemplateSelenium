package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class GalleryFormatPage extends SeleniumWrappers{

	public GalleryFormatPage(WebDriver driver) {
		super(driver);
	}
	
	public By comment = By.cssSelector("textarea[id='comment']");
	public By name = By.cssSelector("input[id='author']");
	public By email = By.cssSelector("input[id='email']");
	
	public By postCommentButton = By.cssSelector("input[class='submit']");

}
