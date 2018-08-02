package by.htp.kyzniatsova.steps;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.kyzniatsova.pages.MainPage;
import by.htp.kyzniatsova.pages.SearchResultsPage;

public class ParseTicketsStep extends AbstractStep {
	
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();
	
	

	@Override
	public void initBrowser() {
	}

	@Override
	public void closeDriver() {
	}
	
	public void searchTickets() {
		WebDriverWait waitDate = new WebDriverWait(driver, 30);
		waitDate.withTimeout(30, TimeUnit.SECONDS);
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		searchResultsPage.searchText();
	}
	
}
