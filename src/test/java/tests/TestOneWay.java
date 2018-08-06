package tests;

import org.testng.annotations.*;

import by.htp.kyzniatsova.pages.ResultsTicketPage;
import by.htp.kyzniatsova.steps.SearchStep;

public class TestOneWay extends BaseTest {
	
	private SearchStep steps;
	private final String DESTINATION1 = "Ã»Õ— ";
	private final String DESTINATION2 = "–»√¿";
	private final String KIND = "One";

	@Test
	public void searchOneWayTicketToRiga() {
		
		steps.openPage();
		steps.setDepatureAndDestination(DESTINATION1, DESTINATION2);
		steps.setOneWayOrReturnTicket(KIND);
		steps.searchFlight();
		ResultsTicketPage resPage = steps.getResultsOfOneWayTicketSearch();
	
<<<<<<< HEAD
	}

=======
	@Test(priority = 3, description = "Fill date")
	public void testChooseDate() {
		step.chooseDate("10");
	}

	
	@Test(priority = 4, description = "Click on the button search")
	public void testClickButtonSearch() {
//		step.clickButtonSearch();
		step.searchTickets();
	}
	
//	@Test(priority = 5, description = "go to seach results")
//	public void testSearchTicketsResSet() {
//		step.searchTickets();
//	}
	
//	@Test(priority = 5, description = "Init browser")
//	public void setUpParse() {
//		stepic = new ParseTicketsStep();
//	}
//		
	@AfterSuite(description = "Stop Browser")
	public void stopBrowser() {
		step.closeDriver();
	}


>>>>>>> parent of da1c59c... Were added steps for search prices
}
