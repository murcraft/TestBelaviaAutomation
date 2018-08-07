package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import by.htp.kyzniatsova.pages.ResultsTicketPage;
import by.htp.kyzniatsova.steps.SearchStep;
import by.htp.kyzniatsova.steps.SearchOneWayStep;


public class TestOneWay extends BaseTest {
	
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
	
	
	@Test(priority = 1, description = "ChooseTab")
	public void testOpenPage() {
		step.openMainPage();
		String value = step. getPageName();
		Assert.assertEquals(supportLink, value);
	}
	
	@Test(priority = 2, description = "Fill date")
	public void testChooseDestinations() {
		step.fillDestination(DESTINATION1, DESTINATION2);
	}

	@Test(priority = 3, description = "Fill date")
	public void testChooseDates() {
		step.chooseDateInOneWay("10");
		step.clickButtonSearch();
	}
	
	@AfterSuite(description = "Stop Browser")
	public void stopBrowser() {
		step.closeDriver();
	}

}
