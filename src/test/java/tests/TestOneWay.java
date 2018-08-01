package tests;
import org.testng.Assert;
import org.testng.annotations.*;

import steps.SearchOneWay;
import steps.StepsResultPage;


public class TestOneWay {
	private SearchOneWay step;
	private StepsResultPage stepic;
	private final String DESTINATION1 = "Ã»Õ— ";
	private final String DESTINATION2 = "–»√¿";
	private final String text = "support@belavia.by";
	

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		step = new SearchOneWay();
		step.initBrowser();
	}
	
	@Test(groups = {"on"}, description = "check needed site")
	public void testMainPage() {
		step.openMainPage();
		String str= step.getPageName();
		Assert.assertEquals(text.trim().toLowerCase(), str);
	}

	@AfterGroups(groups = {"on"}, description = "Fill destination")
	public void oneCanLogin() {
		step.fillDestination(DESTINATION1, DESTINATION2);
		step.chooseDate();
		step.clickButtonSearch();
	}
	
	@AfterClass
	public void searchTicketsResSet() {
		stepic.searchTickets();
	}
	
//	@AfterGroups(groups = {"on"}, description = "click on button")
//	public void buttonSearch() {
//		step.clickButtonSearch();
//	}

	
//	@AfterTest(description = "Stop Browser")
//	public void stopBrowser() {
//		step.closeDriver();
//	}


}
