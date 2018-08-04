package tests;
import org.testng.Assert;
import org.testng.annotations.*;

import by.htp.kyzniatsova.steps.SearchStep;

public class TestOneWay extends BaseTest {
	
	private SearchStep steps;
	private final String DESTINATION1 = "Ã»Õ— ";
	private final String DESTINATION2 = "–»√¿";
	private final String text = "support@belavia.by";
	

	@Test
	public void searchOneWayTicketToRiga() {
		
		steps.openBelaviaPage();
		steps.setDepatureAndDestination(DESTINATION1, DESTINATION2);
		steps.setOneWayOrReturnTicket("One-way");
		steps.searchFlight();
		BookingPage page = steps.getResultsOfOneWayTicketSearch();
	
	}

}
