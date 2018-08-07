package by.htp.kyzniatsova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page {

	private final String URL = "https://belavia.by/";
	
	private final By tabLocator = By.cssSelector("#navtab > ul > li:nth-child(1) > a");
	private final By buttonFind = By.cssSelector("#step-2 > div:nth-child(4) > div > button");
	private final By radioButton = By.xpath("//div[@id='step-2']/div[1]/div/label[1]");

	private final By getSupportLink = By.xpath("//div[@id='footer']/div[1]/div/div[1]/div[2]/a");
	private final By buttonResultsNext = By.xpath("//button[contains(@class, 'btn btn-b2-green')]");


	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@Override
	public void openPage() {
		driver.navigate().to(URL);
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
	
	public String getSiteName() {
		String supportLink = driver.findElement(getSupportLink).getText();
		return supportLink;
	}
}
