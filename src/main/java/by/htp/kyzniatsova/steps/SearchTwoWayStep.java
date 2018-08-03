package by.htp.kyzniatsova.steps;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.kyzniatsova.driver.DriverSingleton;
import by.htp.kyzniatsova.pages.CalendarField;
import by.htp.kyzniatsova.pages.Destinations;
import by.htp.kyzniatsova.pages.MainPage;
import by.htp.kyzniatsova.pages.ResultsTicketPage;

public class SearchTwoWayStep extends AbstractStep {
	
	private WebDriver driver;
	private final Logger logger = LogManager.getRootLogger();

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
		dest.chooseLabelDestTwoSides();
		
	}
	
	public void chooseDateTo(String date) {
		CalendarField cal = new CalendarField(driver);
		cal.clickInputCalendar();
		cal.parseDatesTo();
		cal.chooseDateTo(date);
	}
	
	public void chooseDateBack(String date) {
		CalendarField cal = new CalendarField(driver);
		cal.parseDatesFrom();
		cal.chooseDateBack(date);
	}
	
	public ResultsTicketPage clickButtonSearch() {
		MainPage mainPage = new MainPage(driver);
		mainPage.putButton();
		return new ResultsTicketPage(driver);
	}
	
	public void searchTickets() {
		MainPage mainPage = new MainPage(driver);
		ResultsTicketPage resultsPage = mainPage.putButton();
		resultsPage.searchTicketPrices();
	}

}
