package by.htp.kyzniatsova.steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import by.htp.kyzniatsova.entity.TicketWay;
import by.htp.kyzniatsova.pages.MainPage;
import by.htp.kyzniatsova.pages.ResultsTicketPage;

public class SearchStep {
	
	private WebDriver driver;
	private MainPage mainPage;
	private ResultsTicketPage resultsPage;
	private TicketWay ticketWay;

	public SearchStep(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openPage() {
		mainPage = new MainPage(driver);
		mainPage.openPage();
	}

	public void setDepatureAndDestination(String departure, String destination) {
		mainPage = new MainPage(driver);
		mainPage.setDeparture(departure);
		mainPage.setDestinationCity(destination);
	}

	public void setOneWayOrReturnTicket(String type) {
		mainPage = new MainPage(driver);
		if (type.equalsIgnoreCase("one")) {
			mainPage.setOneWayTicketType();
		} else if (type.equalsIgnoreCase("return")) {
			mainPage.setReturnTicketType();
		} else {
			System.out.println("Wrong way");
		}
	}

	public void searchFlight() {
		mainPage = new MainPage(driver);
		mainPage.setDepatureDate();
		mainPage.clickSearchButton();
		resultsPage = new ResultsTicketPage(driver);
	}
	
	public void searchReturnFlight() {
		mainPage = new MainPage(driver);
		mainPage.setDepatureDate();
		mainPage.setReturnDate();
		mainPage.clickSearchButton();
		resultsPage = new ResultsTicketPage(driver);
	}
	
	public ResultsTicketPage getResultsOfOneWayTicketSearch() {
		ResultsTicketPage bookingPage = new ResultsTicketPage(driver);
		List<TicketWay> tickets = bookingPage.readOneWayTickets();
		bookingPage.sortByPrice(tickets);
		bookingPage.printOneWayTickets(tickets);
		return bookingPage;
	}

	public ResultsTicketPage getResultsOfReturnTicketSearch() {
		ResultsTicketPage bookingPage = new ResultsTicketPage(driver);
		List<TicketWay> tickets = bookingPage.getTicketsToBack();
		bookingPage.sortFlightDates(tickets);
		bookingPage.printReturnTickets(tickets);
		return bookingPage;
	}

}
