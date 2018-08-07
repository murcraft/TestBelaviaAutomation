package by.htp.kyzniatsova.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.kyzniatsova.entity.Ticket;


public class ResultsTicketPage extends Page {

	private final By valueDay = By.xpath("//div[@class='hdr']/.//h3");
	private final By valueDepartTime = By.xpath("//div[@class='departure']//strong"); 

	private final By flightCategory = By.xpath("//div[@class='fare-avail ui-corner-all']/.//a");
	private final By priceLabel = By.xpath("//div[@class='fare-avail ui-corner-all']/.//label");
	private final By tariffsCalendarLink = By.xpath("//div[@class='col-mb-5 text-right']/a");
	
	private final By directionContainer = By.xpath("//div[@class='direction']");

	private WebDriverWait wait = new WebDriverWait(driver, 10);

	public ResultsTicketPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		
	}
	
	public String getDepartTime() {
		String time = driver.findElements(valueDepartTime).get(0).getText();
		return time;
	}
	
	public Calendar getDepartDate() {
		String departDateStr = driver.findElements(valueDay).get(0).getText();
		Calendar departDate = new GregorianCalendar();
		SimpleDateFormat format = new SimpleDateFormat("EEEE dd MMMM");
		try {
			departDate.setTime(format.parse(departDateStr));
			return departDate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return departDate;
	}
	
	public List<Ticket> getDepartTickets() {
		Calendar departDate =  getDepartDate();
		String time = getDepartTime();
		List<Ticket> tickets = new ArrayList<Ticket>();
		List<WebElement> flightsCategories = driver.findElements(flightCategory);
		List<WebElement> prices = driver.findElements(priceLabel);
		
		for (int i = 0; i < flightsCategories.size(); i++) {
			
			Ticket ticket = new Ticket();
			ticket.setDepartureDate(departDate);
			ticket.setDepartureTime(time);
			ticket.setFlightClass(flightsCategories.get(i).getAttribute("innerText"));
			
			String priceValue = prices.get(i).getText();
			priceValue = priceValue.replace(",", ".");
			
			String[] splitPrice = priceValue.split(" ");
			double price = Double.parseDouble(splitPrice[0]);
			ticket.setTicketPrice(price);
			tickets.add(ticket);
		}
		return tickets;
	}
	
	public String getArrivalTime() {
		String time = driver.findElements(valueDepartTime).get(2).getText();
		return time;
	}
	
	public Calendar getArrivalDate() {
		String departDateStr = driver.findElements(valueDay).get(1).getText();
		Calendar departDate = new GregorianCalendar();
		SimpleDateFormat format = new SimpleDateFormat("EEEE dd MMMM");
		try {
			departDate.setTime(format.parse(departDateStr));
			return departDate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return departDate;
	}

	public List<Ticket> getTicketsOnArrivalDate() {
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		Calendar date = getArrivalDate();
		String time = getArrivalTime();
		
		List<WebElement> directionContainers = driver.findElements(directionContainer);
		List<WebElement> flightsCategories = directionContainers.get(1).findElements(flightCategory);
		List<WebElement> costs = directionContainers.get(1).findElements(priceLabel);
		for (int i = 0; i < flightsCategories.size(); i++) {
			Ticket ticket = new Ticket();
			ticket.setDepartureDate(date);
			ticket.setDepartureTime(time);
			ticket.setFlightClass(flightsCategories.get(i).getAttribute("innerText"));
			
			String costStr = costs.get(i).getText();
			costStr = costStr.replace(",", ".");
			
			String[] result = costStr.split(" ");
			double cost = Double.parseDouble(result[0]);
			ticket.setTicketPrice(cost);
			tickets.add(ticket);
		}
		return tickets;
	}

	public void clickPricesTable() {
		driver.findElement(tariffsCalendarLink).click();
	}

}
