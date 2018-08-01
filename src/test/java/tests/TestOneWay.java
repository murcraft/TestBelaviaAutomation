package tests;
import org.testng.Assert;
import org.testng.annotations.*;

import steps.SearchOneWay;


public class TestOneWay {
	private SearchOneWay step;
	private final String DESTINATION1 = "Ã»Õ— ";
	private final String DESTINATION2 = "–»√¿";
	private final String text = "support@belavia.by";
	

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		step = new SearchOneWay();
		step.initBrowser();
	}
	
	@Test(groups = {"openPage"}, description = "check needed site")
	public void testMainPage() {
		Assert.assertEquals(text.trim().toLowerCase(), step.getPageName());
	}

	@AfterGroups(groups = {"openPage"}, description = "Fill destination")
	public void oneCanLogin() {
		step.fillDestination(DESTINATION1, DESTINATION2);
//		Assert.assertTrue(step.isLoggedIn(DESTINATION1));
	}
	
//	@AfterMethod(description = "Stop Browser")
//	public void stopBrowser() {
//		step.closeDriver();
//	}


}
