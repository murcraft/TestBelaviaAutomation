package by.htp.kyzniatsova.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.kyzniatsova.driver.DriverSingleton;
import by.htp.kyzniatsova.pages.CalendarField;
import by.htp.kyzniatsova.pages.Destinations;
import by.htp.kyzniatsova.pages.MainPage;
import by.htp.kyzniatsova.pages.ResultsTicketPage;

public class SearchOneWayStep extends AbstractStep {
	
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
		ResultsTicketPage resultsPage = mainPage.putButton();
		resultsPage.searchTicketPrices();
	}

}
