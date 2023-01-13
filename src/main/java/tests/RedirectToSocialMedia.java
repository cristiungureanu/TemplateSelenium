package tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
		
		NavMenuPage menu = new NavMenuPage(driver);
		/**   - not fully functionable
		String expectedURLInsta = "https://www.instagram.com/";
		String expectedURLFace = "https://www.facebook.com/keytraining.ro";
		
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
		
		Thread.sleep(5000); */
		
        By[] icons = new By[3];
        icons[0] = menu.instaIcon;
        icons[1] = menu.facebookIcon;
        icons[2] = menu.twitterIcon;
        
        String[] expectedURLS = new String[3];
        expectedURLS[0] = "https://www.instagram.com/";
        expectedURLS[1] = "https://www.facebook.com/keytraining.ro";
        expectedURLS[2] = "https://twitter.com/";
        
        for(int i=0; i<icons.length; i++) {
            
            menu.navigateTo(icons[i]);
            List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(browserTabs.get(1));
            assertEquals(driver.getCurrentUrl(),expectedURLS[i]);
            
            driver.close(); 
            driver.switchTo().window(browserTabs.get(0)); 
                
        }

	}
}
