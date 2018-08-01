package tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.SearchOneWay;


public class TestOneWay {
	private SearchOneWay step;
	private final String DESTINATION1 = "МИНСК";
	private final String DESTINATION2 = "РИГА";
	private final String text = "2000 — 2018 «Авиакомпания «Белавиа»";
	

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		step = new SearchOneWay();
		step.initBrowser();
	}
	
	@Test
	public void testMainPage() {
//		step.openPage();
		Assert.assertEquals(text.trim().toLowerCase(), step.getPageName());
	}

//	@Test(groups = {"init"}, description = "Login to Email")
//	public void oneCanLogin() {
//		step.login(DESTINATION1, DESTINATION2);
//		Assert.assertTrue(step.isLoggedIn(DESTINATION1));
//	}
	
//	@AfterMethod(description = "Stop Browser")
//	public void stopBrowser() {
//		step.closeDriver();
//	}


}
