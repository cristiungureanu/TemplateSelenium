package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.BlogPage;
import pages.GalleryFormatPage;
import pages.NavMenuPage;
import utils.BaseTest;

public class NavigateToPostFormatPageUsingJSExecutor extends BaseTest{

	@Test
	public void navigateToPostFormat() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		NavMenuPage menu =  new NavMenuPage(driver);
		
		//jse.executeScript("document.getElementsByClassName('sf-with-ul')[0].click()");               de ce nu merge asa?
		//menu.navigateTo(menu.blog);
		String javaScriptHover = "var obiect = document.createEvent('MouseEvent');"
				+ "obiect.initMouseEvent('mouseover', true);"
				+ "arguments[0].dispatchEvent(obiect);";
		
		jse.executeScript(javaScriptHover, menu.getElement(menu.blog));
		
		menu.navigateTo(menu.postFormatsBlogLink);
		//jse.executeScript("document.getElementsByClassName('menu-item menu-item-type-taxonomy menu-item-object-category menu-item-232')[0].click()");          de ce nu merge asa?
		

		Actions action = new Actions(driver);
		BlogPage blogPage = new BlogPage(driver);
		
		//Javascript executor scroll to Element
		WebElement galleryTitle = driver.findElement(blogPage.galleryFormat);
		jse.executeScript("arguments[0].scrollIntoView();", galleryTitle);
		
		//Actions class move to element
		action.moveToElement(galleryTitle).perform();
		Thread.sleep(3000);	
		
		
		
		//click on ReadMore button for Gallery Format section
		//jse.executeScript("document.getElementsByClassName('sc_button sc_button_square sc_button_style_filled sc_button_size_small')[0].click()");      cum fac sa identific unic aici? daca folosesc clasa asa cum e, ea se regaseste de 4 ori si da click pe primul blog?
		jse.executeScript("arguments[0].click()", menu.getElement(blogPage.readMoreButton));
		
		//adaugam un comment
		//jse.executeScript("document.getElementById('comment').value = 'first comment'");   de ce nu merge asa?
		//jse.executeScript("document.getElementById('author')[0].value = 'cristi'");
		//jse.executeScript("document.getElementById('email')[0].value = 'cristi@yahoo.com'");
		//jse.executeScript("document.getElementByClassName('submit')[0].click()");
		
		GalleryFormatPage gallery = new GalleryFormatPage(driver);
		
		jse.executeScript("arguments[0].click()", gallery.getElement(gallery.comment));
		jse.executeScript("arguments[0].value='first comment3334343'", gallery.getElement(gallery.comment));
		
		jse.executeScript("arguments[0].click()", gallery.getElement(gallery.name));
		jse.executeScript("arguments[0].value='cristi'", gallery.getElement(gallery.name));
		
		jse.executeScript("arguments[0].click()", gallery.getElement(gallery.email));
		jse.executeScript("arguments[0].value='cristi@yahoo.com'", gallery.getElement(gallery.email));
		
		jse.executeScript("arguments[0].click()", gallery.getElement(gallery.postCommentButton));
		
	}
}
