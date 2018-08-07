package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import by.htp.kyzniatsova.driver.DriverSingleton;

public class BaseTest {
	
	protected WebDriver driver;
		
	@BeforeSuite
	public void setUpDriver() {
		driver = DriverSingleton.getDriver();
	}

	@AfterSuite
	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

}
