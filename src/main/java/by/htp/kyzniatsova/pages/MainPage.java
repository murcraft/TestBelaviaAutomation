package by.htp.kyzniatsova.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page {
<<<<<<< HEAD

	private static final String URL = "https://belavia.by/";
=======
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
>>>>>>> parent of 95c5795... Was added test for link to two destinations

	@FindBy(xpath = "//div[@class='wrapper ui-trigger-input']/a[@class='trigger']")
	private List <WebElement> fieldsCityes;
	
	@FindBy(xpath = "//ul[@id='ui-id-2']/li/a")
	private List <WebElement> departCity;

	@FindBy(xpath = "//ul[@id='ui-id-3']/li/a")
	private List <WebElement> destinationCitys;

	@FindBy(xpath = "//label[@for='JourneySpan_Ow']")
	private WebElement oneWayLabel;

	@FindBy(xpath = "//label[@for='JourneySpan_Rt']")
	private WebElement twoWaysLabel;

	@FindBy(xpath = "//i[@class='icon-calendar']")
	private WebElement dateInput;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private WebElement dateOfDepart;

	@FindBy(xpath = "//td[@data-month='7']/a[(text()='1')]")
	private WebElement dateOfMonth;

	@FindBy(xpath = "//*[@class='button btn-large btn btn-b2-green ui-corner-all']")
	private WebElement searchButton;

	private Actions actions = new Actions(driver);

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(URL);
	}

	public void setDeparture(String depature) {
		WebElement departArrow = fieldsCityes.get(0);
		departArrow.click();

		for (WebElement el : departCity) {
			if (el.getText().contains(depature)) {
				el.click();
			}
		}
	}

	public void setDestinationCity(String destination) {
		WebElement departArrow = fieldsCityes.get(1);
		departArrow.click();
		for (WebElement el : destinationCitys) {
			if (el.getText().contains(destination)) {
				el.click();
			}
		}
	}
<<<<<<< HEAD
<<<<<<< HEAD

	public void clickSearchButton() {
		searchButton.click();
=======
=======

	public void chooseRadioButtonSides() {
		driver.findElement(radioButton).click();
	}
>>>>>>> parent of 95c5795... Was added test for link to two destinations
	
	public ResultsTicketPage putButton() {
		WebDriverWait waitResPage = new WebDriverWait(driver, 30);
		waitResPage.until(ExpectedConditions.elementToBeClickable(buttonFind));
		driver.findElement(buttonFind).click();
		waitResPage.until(ExpectedConditions.visibilityOfElementLocated(buttonResultsNext));
		return new ResultsTicketPage(driver);
>>>>>>> parent of da1c59c... Were added steps for search prices
	}

	public void setOneWayTicketType() {
		oneWayLabel.click();
	}

	public void setReturnTicketType() {
		twoWaysLabel.click();
	}

	public void setDepatureDate() {
		dateInput.click();
		dateOfMonth.click();
	}

	public void setReturnDate() {
		dateOfMonth.click();
	}
	
}
