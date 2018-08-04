package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import by.htp.kyzniatsova.driver.DriverSingleton;
import by.htp.kyzniatsova.steps.SearchStep;

public class BaseTest {
	
	
	protected WebDriver driver;
	protected SearchStep steps;
		
	@BeforeSuite
	public void setUpDriver() {
		driver = DriverSingleton.getDriver();
		steps = new SearchStep(driver);
	}

	@AfterSuite
	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

}
