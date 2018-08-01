package steps;

import java.util.concurrent.TimeUnit;

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
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		DriverSingleton.closeDriver();
	}
	
	public void openMainPage() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
	}
	
	public String getPageName() {
		MainPage mainPage = new MainPage(driver);
		String actualUsername = mainPage.getSiteName().trim().toLowerCase();
		return actualUsername;
	}
	

	public void fillDestination(String destination1, String destination2) {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseSearchigTab();
		mainPage.chooseDestination();
	}
	
	public void chooseDate() {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseDate();

	}
	
	public void clickButtonSearch() {
		MainPage mainPage = new MainPage(driver);
		mainPage.putButton();
	}

}
