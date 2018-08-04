package tests;

import org.testng.annotations.Test;

import by.htp.kyzniatsova.pages.ResultsTicketPage;
import by.htp.kyzniatsova.steps.SearchStep;

public class TestTwoWays {
	
	private SearchStep steps;
	private final String DESTINATION1 = "Ã»Õ— ";
	private final String DESTINATION2 = "–»√¿";
	private final String KIND = "Return";
	
	@Test
	public void searchReturnTicketToRiga(){
		
		steps.openPage();
		steps.setDepatureAndDestination(DESTINATION1, DESTINATION2);
		steps.setOneWayOrReturnTicket(KIND);
		steps.searchReturnFlight();
		ResultsTicketPage resPage = steps.getResultsOfReturnTicketSearch();
			
	}

}
