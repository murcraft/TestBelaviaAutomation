package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import driver.DriverSingleton;
import pages.MainPage;

public class SearchOneWay extends AbstractStep {
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();
	
	@Override
	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}
	
	@Override
	public void closeDriver() {
		DriverSingleton.closeDriver();
	}
	
	public void openPage() {
		MainPage mainPage = new MainPage(driver);
	}

	public void fillDestination(String destination1, String destination2) {
		MainPage mainPage = new MainPage(driver);
	}
	
	public String getPageName() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		String actualUsername = mainPage.getSiteName().trim().toLowerCase();
		return actualUsername;
	}

//	public boolean isLoggedIn(String username) {
//		LoginPage loginPage = new LoginPage(driver);
//		System.out.println(loginPage.getDriver().getCurrentUrl());
//		String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
//		logger.info("Actual username: " + actualUsername);
//		return actualUsername.equals(username);
//	}
//	
//	public boolean isMessagesInbox(String newEmail) {
//		MainPage mainPage = new MainPage(driver );
//		System.out.println(mainPage.getDriver().getCurrentUrl());
//		String actualPage = mainPage.getMainPageSend();
//		logger.info("Actual page: " + actualPage);
//		return actualPage.contains(newEmail);
//	}
//	
//	public void pressSendEmail() {
//		
//	}
//	
//	public void sendEmail() {
//		MainPage mainPage = new MainPage(driver);
//		ComposePage composePage = mainPage.findMessage();;
//		composePage.fillDestinationAddress(); 
//		composePage.findFrameTextEmail();
//		
//	}
//	
//	public boolean isSendBoxEmpty() {
//		return true;
//	}

}
