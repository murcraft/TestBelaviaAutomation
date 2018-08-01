package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pages.SearchResultsPage;

public class StepsResultPage extends AbstractStep {
	
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();
	
	

	@Override
	public void initBrowser() {
	}

	@Override
	public void closeDriver() {
		// TODO Auto-generated method stub
		
	}
	
	public void searchTickets() {
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		searchResultsPage.searchText();
	}
	
}
