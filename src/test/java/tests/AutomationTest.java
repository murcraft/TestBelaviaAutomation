package tests;

import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.*;

import by.htp.kyzniatsova.entity.*;
import by.htp.kyzniatsova.steps.SearchOneWayStep;


public class AutomationTest extends BaseTest {
	
	private SearchOneWayStep step;

	private final String DESTINATION1 = "Ã»Õ— ";
	private final String DESTINATION2 = "–»√¿";
	private final String supportLink = "support@belavia.by";
	private final static int MONTH_RANGE = 3;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		step = new SearchOneWayStep();
		step.initBrowser();
	}
	
	
	@BeforeTest(groups = {"open"}, description = "ChooseTab")
	public void testOpenPage() {
		step.openMainPage();
		String value = step. getPageName();
		Assert.assertEquals(supportLink, value);
	}
	
	@Test(groups = {"one way"}, description = "Fill dates in one way")
	public void testSearchOneWay() {
		Calendar endDate = new GregorianCalendar();
		endDate.add(Calendar.MONTH, MONTH_RANGE);
		
		step.fillDestination(DESTINATION1, DESTINATION2);
		step.chooseDateInOneWay();
		step.clickButtonSearch();
		
		List<Ticket> tickets = step.getTicketsInOneWay(endDate);
		
		System.out.println("Sorted in price: ");
		Collections.sort(tickets, new TicketPriceComparator());
		System.out.println(tickets);
		
		System.out.println("Sorted in date: ");
		Collections.sort(tickets, new TicketDateComporator());
		System.out.println(tickets);
	}
	
	@Parameters({"DepartCity","ArriveCity","Months"})
	@Test(groups = {"two sides"}, description = "tickets at two ways")
	public void searchTwoWays(String fromCity, String toCity, int mounths) {
		Calendar endDate = new GregorianCalendar();
		endDate.add(Calendar.MONTH, mounths);
		
		step.fillDestination(fromCity, toCity);
		step.chooseDateInOneWay();
		step.chooseDateInTwoWays(endDate, mounths);
		
		List<Ticket> ticketsDestin = step.getColumnTickets(endDate);
		List<Ticket> ticketsBack = step.getRowTickets(endDate);
		
		System.out.println("Minsk -------- Riga");
		System.out.println("Sorted in price:");
		Collections.sort(ticketsBack, new TicketPriceComparator());
		System.out.println(ticketsBack);
		System.out.println("Sorted in date:");
		Collections.sort(ticketsBack, new TicketDateComporator());
		System.out.println(ticketsBack);
		
		System.out.println("Riga -------- Minsk");
		System.out.println("Sorted in price:");
		Collections.sort(ticketsDestin, new TicketPriceComparator());
		System.out.println(ticketsDestin);
		System.out.println("Sorted in date:");
		Collections.sort(ticketsDestin, new TicketDateComporator());
		System.out.println(ticketsDestin);
		
	}
	
	@AfterSuite(description = "Stop Browser")
	public void stopBrowser() {
		step.closeDriver();
	}

}
