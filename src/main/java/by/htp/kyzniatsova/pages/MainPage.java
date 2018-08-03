package by.htp.kyzniatsova.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page {
	private final Logger logger = LogManager.getRootLogger();
	private final String URL = "https://belavia.by/";
	private final String fromDestination = "ÌÈÍÑÊ";
	private final String toDestination = "ÐÈÃÀ";
	
	private final By tabLocator = By.cssSelector("#navtab > ul > li:nth-child(1) > a");
	private final By inputFromLocator = By.cssSelector("#OriginLocation_Combobox");
	private final By inputToLocator = By.cssSelector("#DestinationLocation_Combobox");
	private final By dropdownInputFrom = By.xpath("//ul[@id='ui-id-2']/li[@class='ui-menu-item']");
	private final By dropdownInputTo = By.xpath("//ul[@id='ui-id-3']/li[@class='ui-menu-item']");
	
	private final By buttonFind = By.cssSelector("#step-2 > div:nth-child(4) > div > button");
	private final By radioButton = By.xpath("//div[@id='step-2']/div[1]/div/label[1]");
	private final By inputDateTo = By.xpath("//div[@id='step-2']/div[2]/div[1]/div/a");
	private final By inputDateBack = By.xpath("//div[@id='step-2']/div[2]/div[2]/div/a");
	private final By selectPasseger = By.xpath("//a[@id='ui-id-1']");
	private final By getLeftMonthYear = By.xpath("//div[@id='calendar']/div/div[1]/div/div");
	private final By getRightMonthYear = By.xpath("//div[@id='calendar']/div/div[2]/div/div");
	private final By getPreviousCalendarMonth = By.xpath("//div[@id='calendar']/div/div[1]/div/a");
	private final By getNextCalendarMonth = By.xpath("//div[@id='calendar']/div/div[2]/div/a");
	private final By getDayOfMonth = By.xpath("//*[@id='calendar']/div/div[1]/table/tbody/tr[1]/td[3]/a");
	private final By getSupportLink = By.xpath("//div[@id='footer']/div[1]/div/div[1]/div[2]/a");

	
	private final By inputLeftCalendar = By.xpath("//div[@id='step-2']/div[2]/div[1]/div/a");
	private final By getTableTd = By.xpath("//div[@id='calendar']/div/div[contains(@class,'ui-datepicker-group-first')]/table/descendant::td/a");
	private final By buttonResultsNext = By.xpath("//button[contains(@class, 'btn btn-b2-green')]");

	private Destinations destination; //= new Destinations(driver);
	private CalendarField calendarField;
	
	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(URL);
		logger.info("Page is opened");
	}
	
	public String getSiteName() {
		return driver.findElement(getSupportLink).getText();
	}
	
	public void chooseSearchigTab() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(tabLocator));
		driver.findElement(tabLocator).click();
	}

	public void chooseRadioButtonSides() {
		driver.findElement(radioButton).click();
	}
	
	public ResultsTicketPage putButton() {
		WebDriverWait waitResPage = new WebDriverWait(driver, 30);
		waitResPage.until(ExpectedConditions.elementToBeClickable(buttonFind));
		driver.findElement(buttonFind).click();
		waitResPage.until(ExpectedConditions.visibilityOfElementLocated(buttonResultsNext));
		return new ResultsTicketPage(driver);
	}
}
