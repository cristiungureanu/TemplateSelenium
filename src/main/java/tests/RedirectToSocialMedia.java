package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactPage;
import pages.EventsPage;
import pages.NavMenuPage;
import pages.SingleEventPage;
import utils.BaseTest;

public class RedirectToSocialMedia extends BaseTest{
	
	@Test
	public void redirect() throws InterruptedException{
		
		String expectedURLInsta = "https://www.instagram.com/";
		String expectedURLFace = "https://www.facebook.com/keytraining.ro";
		
		NavMenuPage menu = new NavMenuPage(driver);
		menu.navigateTo(menu.instaIcon);
		
		Thread.sleep(3000);
		
		List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		
		String redirectURL=driver.getCurrentUrl();
		Assert.assertEquals(redirectURL,expectedURLInsta);
		
		driver.close(); // inchide tabul curent
		driver.switchTo().window(browserTabs.get(0)); //schimba focusul pe tabul ramas
		
		menu.navigateTo(menu.facebookIcon);
		Thread.sleep(3000);
		driver.switchTo().window(browserTabs.get(2));
		
		String URLFace = driver.getCurrentUrl();
		Assert.assertEquals(URLFace,expectedURLFace);
		driver.close(); 
		driver.switchTo().window(browserTabs.get(1));
		
		menu.navigateTo(menu.twitterIcon);
		Thread.sleep(3000);
		driver.switchTo().window(browserTabs.get(1));
		Assert.assertEquals(driver.getCurrentUrl(),"https://twitter.com");
		driver.close(); 
		driver.switchTo().window(browserTabs.get(0)); 
		
		Thread.sleep(5000);
	}
}
