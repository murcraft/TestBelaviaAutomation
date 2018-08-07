package by.htp.kyzniatsova.steps;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.WebDriver;

import by.htp.kyzniatsova.driver.DriverSingleton;
import by.htp.kyzniatsova.entity.Ticket;
import by.htp.kyzniatsova.pages.CalendarField;
import by.htp.kyzniatsova.pages.Destinations;
import by.htp.kyzniatsova.pages.MainPage;
import by.htp.kyzniatsova.pages.ResultsTicketPage;
import by.htp.kyzniatsova.pages.TicketsTablePage;

public class SearchOneWayStep extends AbstractStep {
	
	private WebDriver driver;
	private Calendar dateOnClickInRow;
	private Calendar dateOnClickInColumn;
	private final String currentURL = "https://booking.belavia.by/Select/Calendar";
	
	@Override
	public void initBrowser() {
		driver = DriverSingleton.getDriver();
		dateOnClickInRow = new GregorianCalendar();
		dateOnClickInColumn = new GregorianCalendar();
	}
	@Override
	public void closeDriver() {
		DriverSingleton.closeDriver();
	}
	
	public void openMainPage() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
	}
	
	public String getPageName() {
		MainPage mainPage = new MainPage(driver);
		String supportLink = mainPage.getSiteName().trim().toLowerCase();
		return supportLink;
	}

	public void fillDestination(String destination1, String destination2) {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseSearchigTab();
		Destinations dest = new Destinations(driver);
		dest.chooseDepartCity();
		dest.chooseDestinationCity();
		mainPage.chooseRadioButtonSides();
	}
	
	public void chooseDateInOneWay() {
		CalendarField cal = new CalendarField(driver);
		cal.parseDates();
		cal.chooseDate();
	}
	
	public void chooseDateInTwoWays(Calendar dateReturn, int monthRange) {
		CalendarField cal = new CalendarField(driver);
		cal.chooseDate();
	}
	
	public ResultsTicketPage clickButtonSearch() {
		MainPage mainPage = new MainPage(driver);
		mainPage.putButton();
		return new ResultsTicketPage(driver);
	}
	

	private void setDayValue(Calendar calendar) {
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
	}

	private void clickOnDateField() {
		TicketsTablePage tablePage = new TicketsTablePage(driver);
		String date = tablePage.getNextDateInRowOnClick(dateOnClickInRow);
		tablePage.setFieldDateRow(date);
		tablePage.clickOnTicket(date);
	}

	private List<Ticket> getTicketsInDepartDate() {
		List<Ticket> tickets = new ArrayList<Ticket>();
		ResultsTicketPage resTicket = new ResultsTicketPage(driver);
		
		List<Ticket> tempTickets = resTicket.getDepartTickets();
		for (Ticket t : tempTickets) {
			tickets.add(t);
		}
		resTicket.clickPricesTable();
		return tickets;
	}

	private List<Ticket> getTicketsInArrivalDate() {
		List<Ticket> tickets = new ArrayList<Ticket>();
		ResultsTicketPage ticketPage = new ResultsTicketPage(driver);
		tickets.addAll(ticketPage.getTicketsOnArrivalDate());
		ticketPage.clickPricesTable();
		return tickets;
	}

	public List<Ticket> getTicketsInOneWay(Calendar endDate) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		dateOnClickInRow.add(Calendar.DATE, -1);
		setDayValue(dateOnClickInRow);
		
		while (dateOnClickInRow.before(endDate)) {
			if (driver.getCurrentUrl().contains(currentURL)) {
				clickOnDateField();
				tickets.addAll(getTicketsInDepartDate());
			} else {
				tickets.addAll(getTicketsInDepartDate());
			}
		}
		return tickets;
	}

	public List<Ticket> getRowTickets(Calendar endDate) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		TicketsTablePage tablePage = new TicketsTablePage(driver);
		
		dateOnClickInRow.setTime(new Date());
		setDayValue(dateOnClickInRow);
		dateOnClickInRow.add(Calendar.DATE, -1);
		String dateInColumn = tablePage.getNextDateInColumnOnClick(dateOnClickInColumn);
		
		Calendar rangeOfDates = getRangeOfDates(endDate);
		setDayValue(rangeOfDates);
		
		while (dateOnClickInRow.before(rangeOfDates)) {
			String dateInRow = tablePage.getNextDateInRowOnClick(dateOnClickInRow);
			tablePage.setFieldDateRow(dateInColumn);
			tablePage.setFieldDateRow(dateInRow);
			tablePage.clickOnTicketFieldInRow(dateInRow);
			tickets.addAll(getTicketsInDepartDate());
			setDayValue(dateOnClickInRow);
		}
		return tickets;
	}
	
	public Calendar getRangeOfDates(Calendar endDate) {
		Calendar rangeOfDates = new GregorianCalendar();
		rangeOfDates.setTime(endDate.getTime());
		rangeOfDates.add(Calendar.DATE, -1);
		return rangeOfDates;
	}

	public List<Ticket> getColumnTickets(Calendar endDate) {
		TicketsTablePage tablePage = new TicketsTablePage(driver);
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		dateOnClickInColumn.setTime(endDate.getTime());
		setDayValue(dateOnClickInColumn);
		dateOnClickInColumn.add(Calendar.DATE, 1);
		String freeDate = tablePage.getNextDateInRowOnClick(dateOnClickInRow);
		
		Calendar rangeOfDates = getDateForColumnTickets();
		setDayValue(rangeOfDates);
		
		while (dateOnClickInColumn.compareTo(rangeOfDates) != 0) {
			String dateInColumn = tablePage.getNextDateInColumnOnClick(dateOnClickInColumn);
			tablePage.setFieldDateRow(freeDate);
			tablePage.setFieldDateColumn(dateInColumn);
			tablePage.clickOnTicketFieldInColumn(dateInColumn);
			tickets.addAll(getTicketsInArrivalDate());
			setDayValue(dateOnClickInColumn);
		}
		return tickets;
	}
	
	public Calendar getDateForColumnTickets() {
		Calendar rangeOfDates = new GregorianCalendar();
		rangeOfDates.setTime(dateOnClickInRow.getTime());
		rangeOfDates.add(Calendar.DATE, 1);
		return rangeOfDates;
	}

	

}
