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
	private final By buttonFind = By.cssSelector("#step-2 > div:nth-child(4) > div > button");

	private final By selectPasseger = By.xpath("//a[@id='ui-id-1']");
	private final By getSupportLink = By.xpath("//div[@id='footer']/div[1]/div/div[1]/div[2]/a");
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
	
	public ResultsTicketPage putButton() {
		WebDriverWait waitResPage = new WebDriverWait(driver, 30);
		waitResPage.until(ExpectedConditions.elementToBeClickable(buttonFind));
		driver.findElement(buttonFind).click();
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
//		waitResPage.until(ExpectedConditions.presenceOfElementLocated(buttonResultsNext));
		return new ResultsTicketPage(driver);
	}
}
