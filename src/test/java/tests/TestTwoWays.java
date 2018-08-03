package tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import by.htp.kyzniatsova.steps.SearchTwoWayStep;

public class TestTwoWays {
	
	private SearchTwoWayStep step;
	private final String DESTINATION1 = "Ã»Õ— ";
	private final String DESTINATION2 = "–»√¿";
	private final String text = "support@belavia.by";
	

	@BeforeSuite(description = "Init browser")
	public void setUp() {
		step = new SearchTwoWayStep();
		step.initBrowser();
	}
	
	@Test(priority = 1, description = "check needed site")
	public void testMainPage() {
		step.openMainPage();
		String str= step.getPageName();
		Assert.assertEquals(text.trim().toLowerCase(), str);
	}

	@Test(priority = 2, description = "Fill destination")
	public void testDestinationInput() {
		step.fillDestination(DESTINATION1, DESTINATION2);
	}
	
	@Test(priority = 3, description = "Fill date")
	public void testChooseDate() {
		step.chooseDateTo("10");
		step.chooseDateBack("11");
	}

	@Test(priority = 4, description = "Click on the button search")
	public void testClickButtonSearch() {
		step.searchTickets();
	}

	@AfterSuite(description = "Stop Browser")
	public void stopBrowser() {
		step.closeDriver();
	}


}
