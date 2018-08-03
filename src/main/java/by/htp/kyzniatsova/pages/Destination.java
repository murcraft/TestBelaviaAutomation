package by.htp.kyzniatsova.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Destination extends MainPage {

	private final String fromDestination = "ÌÈÍÑÊ";
	private final String toDestination = "ÐÈÃÀ";
	
	private final By tabLocator = By.cssSelector("#navtab > ul > li:nth-child(1) > a");
	private final By inputFromLocator = By.cssSelector("#OriginLocation_Combobox");
	private final By inputToLocator = By.cssSelector("#DestinationLocation_Combobox");
	private final By dropdownDestination = By.xpath("//div[@id='ibe']/form/div[1]/div[1]/div/a");
	private final By dropdownDestinationTo = By.xpath("//div[@id='ibe']/form/div[1]/div[2]/div/a");

	
	public Destination(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void chooseSearchigTab() {
		driver.findElement(tabLocator).click();
		
		driver.findElement(dropdownDestination).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(inputFromLocator).sendKeys(fromDestination);
		driver.findElement(By.xpath("//ul[@id='ui-id-2']/li[@class='ui-menu-item']")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.findElement(dropdownDestinationTo).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(inputToLocator).sendKeys(toDestination);
		driver.findElement(By.xpath("//ul[@id='ui-id-3']/li[@class='ui-menu-item']")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

}
