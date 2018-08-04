package tests;
import org.testng.Assert;
import org.testng.annotations.*;

import by.htp.kyzniatsova.steps.SearchOneWayStep;

public class TestOneWay {
	
	private SearchOneWayStep step;
	private final String DESTINATION1 = "Ã»Õ— ";
	private final String DESTINATION2 = "–»√¿";
	private final String text = "support@belavia.by";
	

	@BeforeSuite(description = "Init browser")
	public void setUp() {
		step = new SearchOneWayStep();
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
		step.chooseDate("4");
	}

	
	@Test(priority = 4, description = "Click on the button search")
	public void testClickButtonSearch() {
		step.searchTickets();
		step.nextSevenDays();
	}
	
	@Test(priority = 5, description = "Click on the button search")
	public void testReturnButton() {
//		step.clickOnBackOnMain();
	}
	
//	@Test(priority = 6, description = "check needed site")
//	public void testMainPage1() {
//		step.openMainPage();
//		String str= step.getPageName();
//		Assert.assertEquals(text.trim().toLowerCase(), str);
//	}
	
//	@AfterSuite(description = "Stop Browser")
//	public void stopBrowser() {
//		step.closeDriver();
//	}


}
