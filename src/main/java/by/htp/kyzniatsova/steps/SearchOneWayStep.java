package by.htp.kyzniatsova.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.htp.kyzniatsova.driver.DriverSingleton;
import by.htp.kyzniatsova.pages.MainPage;
import by.htp.kyzniatsova.pages.SearchResultsPage;

public class SearchOneWayStep extends AbstractStep {
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
	
	public void chooseDate(String date) {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseDate(date);

	}
	
	public SearchResultsPage clickButtonSearch() {
		MainPage mainPage = new MainPage(driver);
		mainPage.putButton();
		return new SearchResultsPage(driver);
	}

}
