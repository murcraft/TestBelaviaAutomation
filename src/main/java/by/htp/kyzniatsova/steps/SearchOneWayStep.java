package by.htp.kyzniatsova.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		WebDriverWait waitDate = new WebDriverWait(driver, 10);
		MainPage mainPage = new MainPage(driver);
		waitDate.withTimeout(5, TimeUnit.SECONDS);
		mainPage.parseDates();
		waitDate.withTimeout(25, TimeUnit.SECONDS);
		mainPage.chooseDate(date);
	}
	
	public SearchResultsPage clickButtonSearch() {
		MainPage mainPage = new MainPage(driver);
		mainPage.putButton();
		WebDriverWait waitDate = new WebDriverWait(driver, 10);
		waitDate.withTimeout(35, TimeUnit.SECONDS);
		return new SearchResultsPage(driver);
	}
	
	public void searchTickets() {
		WebDriverWait waitDate = new WebDriverWait(driver, 30);
		waitDate.withTimeout(30, TimeUnit.SECONDS);
		SearchResultsPage searchResultsPage = clickButtonSearch();//new SearchResultsPage(driver);
		searchResultsPage.searchText();
	}

}
