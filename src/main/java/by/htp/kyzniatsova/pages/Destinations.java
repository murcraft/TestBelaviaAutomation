package by.htp.kyzniatsova.pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Destinations extends MainPage {
	private final Logger logger = LogManager.getRootLogger();
	
	private final String fromDestination = "Ã»Õ— ";
	private final String toDestination = "–»√¿";

	private final By inputFromLocator = By.cssSelector("#OriginLocation_Combobox");
	private final By inputToLocator = By.cssSelector("#DestinationLocation_Combobox");
	private final By dropdownInputFrom = By.xpath("//ul[@id='ui-id-2']/li[@class='ui-menu-item']");
	private final By dropdownInputTo = By.xpath("//ul[@id='ui-id-3']/li[@class='ui-menu-item']");
	
	private final By dropdownDestination = By.xpath("//div[@id='ibe']/form/div[1]/div[1]/div/a");
	private final By dropdownDestinationTo = By.xpath("//div[@id='ibe']/form/div[1]/div[2]/div/a");
	
	private final By labelSideOne = By.xpath("//div[@id='step-2']/div[1]/div/label[1]");
	private final By labelSideTwo = By.xpath("//div[@id='step-2']/div[1]/div/label[2]");
	
	public Destinations(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void chooseDepartCity() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(dropdownDestination));
		driver.findElement(dropdownDestination).click();
		driver.findElement(inputFromLocator).sendKeys(fromDestination);
		
		WebElement inputTextFrom = driver.findElement(dropdownInputFrom);
		wait.until(ExpectedConditions.elementToBeClickable(dropdownInputFrom));
		inputTextFrom.click();
	}
	
	public void chooseDestinationCity() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(dropdownDestinationTo));
		driver.findElement(dropdownDestinationTo).click();
		driver.findElement(inputToLocator).sendKeys(toDestination);
		
		WebElement inputTextTo = driver.findElement(dropdownInputTo);
		wait.until(ExpectedConditions.elementToBeClickable(dropdownInputTo));
		inputTextTo.click();
	}

	public void chooseLabelDestOneSide() {
		driver.findElement(labelSideOne).click();
	}	
	
	public void chooseLabelDestTwoSides() {
		driver.findElement(labelSideTwo).click();
	}

}
