package by.htp.kyzniatsova.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

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
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		searchResultsPage.searchText();
	}
	
}
