package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class BlogPage extends SeleniumWrappers{

	public BlogPage(WebDriver driver) {
		super(driver);
	}
	
	public By galleryFormat = By.xpath("//h4[@class='post_title']/descendant::a[@href='https://keybooks.ro/2016/02/01/gallery-format/']");
	public By readMoreButton = By.xpath("//a[@href='https://keybooks.ro/2016/02/01/gallery-format/'][@class='sc_button sc_button_square sc_button_style_filled sc_button_size_small']");
	

}
