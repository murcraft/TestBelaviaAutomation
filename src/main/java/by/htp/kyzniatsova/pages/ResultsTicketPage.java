package by.htp.kyzniatsova.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.kyzniatsova.entity.TicketWay;

public class ResultsTicketPage extends Page {

	@FindBy(linkText = "Fare calendar")
	private WebElement fareCalendar;

	@FindBy(xpath = "//div[@class='price']//input")
	private List<WebElement> visibleDates;

	@FindBy(xpath = "//div[@class='price']/div")
	List<WebElement> returnTickets;

	@FindBy(xpath = "//*[@class='button btn btn-b2-green btn-large btn-b2-green-fixed ui-corner-all']")
	private WebElement nextButton;

	private WebDriverWait wait = new WebDriverWait(driver, 10);

	public ResultsTicketPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		
	}

	public List<TicketWay> readOneWayTickets() {
		wait.until(ExpectedConditions.visibilityOf(fareCalendar));

		fareCalendar.click();
		List<TicketWay> tickets = new ArrayList<TicketWay>();
		TicketWay ticket = null;

		do {
			for (WebElement element : visibleDates) {
				WebElement price = element.findElement(By.xpath("following-sibling::label"));
				String date = element.getAttribute("value");

				ticket = new TicketWay();
				ticket.setDepartureDate(date);
				ticket.setTicketPrice(price.getText());
				tickets.add(ticket);
			}

			WebElement next = driver.findElement(By.xpath("//i[@class='icon-right-open']"));
			wait.until(ExpectedConditions.visibilityOf(next));
			next.click();
		} while (checkLastTicket(tickets, ticket));

		return tickets;
	}

	public Boolean checkLastTicket(List<TicketWay> tickets, TicketWay ticket) {
		Boolean shouldClickNext = false;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
		LocalDate lastDate = LocalDate.of(2018, 11, 1);
		LocalDate localDate;

		if (ticket != null && tickets.size() > 0) {
			TicketWay lastTicket = tickets.get(tickets.size() - 1);

			String flightDate = lastTicket.getDepartureDate();
			localDate = LocalDate.parse(flightDate, formatter);
			if (localDate.isBefore(lastDate)) {
				shouldClickNext = true;
			}
		}
		return shouldClickNext;
	}

	public void sortByPrice(List<TicketWay> tickets) {
		Collections.sort(tickets);
	}

	public void sortFlightDates(List<TicketWay> tickets) {

		final DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yy-MM-dd");
		Collections.sort(tickets, new Comparator<TicketWay>() {

			public int compare(TicketWay ticket1, TicketWay ticket2) {
				LocalDate date1 = LocalDate.parse(ticket1.getDepartureDate(), formatDate);
				LocalDate date2 = LocalDate.parse(ticket2.getDepartureDate(), formatDate);
				if (date1.isAfter(date2)) {
					return 1;
				} else if (date1.isBefore(date2)) {
					return -1;
				} else {
					return 0;
				}
			}
		});

	}

	public List<TicketWay> getTicketsToBack() {

		TicketWay returnTicket = null;
		List<TicketWay> tickets = new ArrayList<TicketWay>();
		do {
			for (WebElement element : returnTickets) {
				returnTicket = new TicketWay();

				WebElement date = element.findElement(By.xpath("input"));
				WebElement price = element.findElement(By.xpath("label"));

				String datesString = date.getAttribute("value");
				String[] arr = datesString.split(":");

				returnTicket.setDepartureDate((arr[0]));
				returnTicket.setReturnDate(arr[0]);
				returnTicket.setTicketPrice(price.getText());
				tickets.add(returnTicket);
			}

			WebElement next = driver.findElement(By.xpath("//i[@class='icon-right-open']"));
			wait.until(ExpectedConditions.visibilityOf(next));
			next.click();

		} while (checkLastTicket(tickets, returnTicket));

		return tickets;
	}
	

	public void printOneWayTickets(List<TicketWay> tickets) {
		for (TicketWay ticket : tickets) {
			System.out.println(ticket.toString());
		}
	}
	

	public void printReturnTickets(List<TicketWay> tickets) {
		for (TicketWay ticket : tickets) {
			System.out.println(ticket.toString());
		}
	}

}
