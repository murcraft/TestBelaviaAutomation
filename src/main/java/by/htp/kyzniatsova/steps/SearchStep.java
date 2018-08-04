package by.htp.kyzniatsova.steps;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.kyzniatsova.driver.DriverSingleton;
import by.htp.kyzniatsova.pages.CalendarField;
import by.htp.kyzniatsova.pages.Destinations;
import by.htp.kyzniatsova.pages.MainPage;
import by.htp.kyzniatsova.pages.ResultsTicketPage;
import by.htp.kyzniatsova.pages.TicketsPricesPage;

public class SearchStep extends AbstractStep {
/*	
	private final Logger logger = LogManager.getRootLogger();
	
	private WebDriver driver;
	
	public SearchStep(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}
	
	@Override
	public void closeDriver() {
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
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
		Destinations dest = new Destinations(driver);
		dest.chooseDepartCity();
		dest.chooseDestinationCity();
		dest.chooseLabelDestOneSide();
	}
	
	public void chooseDate(String date) {
		CalendarField cal = new CalendarField(driver);
		cal.clickInputCalendar();
		cal.parseDatesTo();
		cal.chooseDateTo(date);
	}
	
	public ResultsTicketPage clickButtonSearch() {
		MainPage mainPage = new MainPage(driver);
		mainPage.putButton();
		return new ResultsTicketPage(driver);
	}
	
	public void searchTickets() {
		MainPage mainPage = new MainPage(driver);
		System.out.println("Click to search results");
		ResultsTicketPage resultsPage = mainPage.putButton();
		System.out.println("has found results");
//		resultsPage.searchTicketPrices();
	}
	
	public MainPage clickOnBackOnMain() {
		ResultsTicketPage resultsPage = new ResultsTicketPage(driver);
		resultsPage.clickReturnButton();
		return new MainPage(driver);
	}
	
	public int getDayOfMonth(int year, int month) {
		Calendar myCal = (Calendar)Calendar.getInstance().clone();
		myCal.set(year, month, 1);
		int maxDay = myCal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return maxDay;
	}
	
	public int getCurrentDay() {
		GregorianCalendar cal = new GregorianCalendar();
		return cal.get(Calendar.DATE);
	}


	public void cycleSteps(int year, int month) {
		int date1 = getCurrentDay();
		String date = "" + getCurrentDay();
		for(int i = date1; i <= getDayOfMonth(year, month); i++) {
		fillDestination("ÌÈÍÑÊ", "ÐÈÃÀ");
			chooseDate(date); 
			clickButtonSearch(); 
//			sedfj();
			searchTickets();
			clickOnBackOnMain();
		}
	}
	
	public void nextSevenDays() {
		ResultsTicketPage resultsPage = new ResultsTicketPage(driver);
//		resultsPage.goToNextDays(); 
		
		
		
		resultsPage.getPricesPage();
//		return new TicketsPricesPage(driver);
	}
	
	*/
	
	private WebDriver driver;
	private MainPage mainPage;
	private BookingPage bookingPage;
	private Ticket ticket;

	public Steps(WebDriver driver) {
		this.driver = driver;
	}

	public void openBelaviaPage() {

		mainPage = new MainPage(driver);
		mainPage.openPage();

	}

	public void setDepatureAndDestination(String departure, String destination) {
		
		mainPage = new MainPage(driver);
		mainPage.setDeparture(departure);
		mainPage.setDestination(destination);
	}

	public void setOneWayOrReturnTicket(String type) {

		mainPage = new MainPage(driver);

		if (type == "One-way") {
			mainPage.setOneWayTicketType();
		} else if (type == "Return") {
			mainPage.setReturnTicketType();
		} else {
			System.out.println("Incorrect type of ticket");
		}
	}

	public void searchFlight() {

		mainPage = new MainPage(driver);
		mainPage.setDepatureDate();
		mainPage.clickSearch();

		bookingPage = new BookingPage(driver);

	}
	
	public void searchReturnFlight() {

		mainPage = new MainPage(driver);
		mainPage.setDepatureDate();
		mainPage.setReturnDate();
		mainPage.clickSearch();

		bookingPage = new BookingPage(driver);

	}
	
	public BookingPage getResultsOfOneWayTicketSearch() {
		
		BookingPage bookingPage = new BookingPage(driver);
		List<Ticket> tickets = bookingPage.getOneWayTickets();
		bookingPage.sortByPrice(tickets);
		bookingPage.printListOfOneWayTickets(tickets);
		
		return bookingPage;
	}

	public BookingPage getResultsOfReturnTicketSearch() {
		
		BookingPage bookingPage = new BookingPage(driver);
		List<Ticket> tickets = bookingPage.getReturnTickets();
		bookingPage.sortByFlightDate(tickets);
		bookingPage.printListOfReturnTickets(tickets);
		
		return bookingPage;
	}


}
