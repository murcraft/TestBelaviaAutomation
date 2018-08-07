package by.htp.kyzniatsova.steps;

import org.openqa.selenium.WebDriver;

import by.htp.kyzniatsova.entity.Ticket;
import by.htp.kyzniatsova.pages.MainPage;
import by.htp.kyzniatsova.pages.ResultsTicketPage;

public class SearchStep {
	
	private WebDriver driver;
	private MainPage mainPage;
	private ResultsTicketPage resultsPage;
	private Ticket ticketWay;

	public SearchStep(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openPage() {
		mainPage = new MainPage(driver);
		mainPage.openPage();
	}

}
