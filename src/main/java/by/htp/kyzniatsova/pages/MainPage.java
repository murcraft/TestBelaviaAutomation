package by.htp.kyzniatsova.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page {
	private final Logger logger = LogManager.getRootLogger();
	private final String URL = "https://belavia.by/";
	private final String fromDestination = "ÌÈÍÑÊ";
	private final String toDestination = "ÐÈÃÀ";
	
	private final By tabLocator = By.cssSelector("#navtab > ul > li:nth-child(1) > a");
	private final By inputFromLocator = By.cssSelector("#OriginLocation_Combobox");
	private final By inputToLocator = By.cssSelector("#DestinationLocation_Combobox");
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
	private final By dropdownDestination = By.xpath("//div[@id='ibe']/form/div[1]/div[1]/div/a");
	private final By dropdownDestinationTo = By.xpath("//div[@id='ibe']/form/div[1]/div[2]/div/a");
	
	private final By inputLeftCalendar = By.xpath("//div[@id='step-2']/div[2]/div[1]/div/a");
	private final By getTableTd = By.xpath("//div[@id='calendar']/div/div[contains(@class,'ui-datepicker-group-first')]/table/descendant::td/a");

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
	
	public void chooseDestination() {
		driver.findElement(radioButton).click();
	
	}
	
	public String chooseMonthRight() {
		driver.findElement(inputDateTo).click();
		return driver.findElement(getLeftMonthYear).getText();
	}
	
	public String chooseMonthLeft() {
		driver.findElement(inputDateTo).click();
		return driver.findElement(getRightMonthYear).getText();
	}
	
	
	public void parseDates() {
		WebDriverWait waitDate = new WebDriverWait(driver, 10);
		waitDate.withTimeout(5, TimeUnit.SECONDS);
		driver.findElement(inputLeftCalendar).click();
		List<WebElement> list = driver.findElements(getTableTd);
		for(WebElement td : list) {
			waitDate.withTimeout(30, TimeUnit.SECONDS);
			System.out.println(td.getText());
		}
	}
	
	public void chooseDate(String date) {
		WebDriverWait waitDate = new WebDriverWait(driver, 10);
		waitDate.withTimeout(5, TimeUnit.SECONDS);
//		driver.findElement(inputLeftCalendar).click();
		List<WebElement> list = driver.findElements(getTableTd);
		for(WebElement td : list) {
			waitDate.withTimeout(30, TimeUnit.SECONDS);
			if(td.getText().equals(date)) {
				waitDate.withTimeout(30, TimeUnit.SECONDS);
				td.click();
				break;
			}
		}

	}

	
	public SearchResultsPage putButton() {
		driver.findElement(buttonFind).click();
		WebDriverWait waitResPage = new WebDriverWait(driver, 30);
		waitResPage.pollingEvery(30, TimeUnit.SECONDS);
		return new SearchResultsPage(driver);
	}
}
