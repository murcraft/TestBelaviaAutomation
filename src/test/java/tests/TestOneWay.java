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
	
	}

}
