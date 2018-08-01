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
	
	public String getPageName() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		String actualUsername = mainPage.getSiteName().trim().toLowerCase();
		return actualUsername;
	}
	

	public void fillDestination(String destination1, String destination2) {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseSearchigTab();
//		mainPage.chooseDestination();
//		mainPage.chooseMonthRight();
	}

}
