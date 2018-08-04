package by.htp.kyzniatsova.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page {

	private static final String URL = "https://belavia.by/";

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

	public void clickSearchButton() {
		searchButton.click();
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
