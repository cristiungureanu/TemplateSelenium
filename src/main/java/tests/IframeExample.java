package tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import pages.ContactPage;
import pages.EventsPage;
import pages.NavMenuPage;
import pages.SingleEventPage;
import utils.BaseTest;

public class IframeExample extends BaseTest{

	//@Test
	public void iframeExample() throws InterruptedException {
		
		NavMenuPage menu = new NavMenuPage(driver);
		menu.navigateTo(menu.contactLink);
		ContactPage contactPage = new ContactPage(driver);
		contactPage.zoomMap(contactPage.zoomIn);
		Thread.sleep(3000);
		
	}
	
	@Test
	public void iframeExample2() throws InterruptedException {
		NavMenuPage menu = new NavMenuPage(driver);
		menu.navigateTo(menu.eventsLink);
		EventsPage eventsPage = new EventsPage(driver);
		eventsPage.click(eventsPage.festivalOfOldFilmsLink);
		Thread.sleep(3000);
		
		SingleEventPage sePage = new SingleEventPage(driver);
		sePage.clickMap();
		Thread.sleep(3000);
		
		System.out.println("All: " + driver.getWindowHandles());
		System.out.println("Current: " + driver.getWindowHandle());
		
		List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println(browserTabs.size());
		driver.switchTo().window(browserTabs.get(1));
		driver.close(); // inchide tabul curent
		Thread.sleep(5000);
		System.out.println("Current 2: " + driver.getWindowHandle());
	}
}
