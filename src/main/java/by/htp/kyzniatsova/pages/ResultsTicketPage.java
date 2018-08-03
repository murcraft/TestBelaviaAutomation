package by.htp.kyzniatsova.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.kyzniatsova.entity.Ticket;

public class ResultsTicketPage extends Page {
	
	private final By returnButton = By.xpath("//div/button[contains(@class,'btn btn-default ui-corner-all cancel')]");

	private final By linkCalendar = By.xpath("//div[@class='hdr']/descendant::div[contains(@class,'text-right')]/a");
	private final By labelElement = By.xpath("//div[contains(@class,'fare')]/label");
	private final By inputElement = By.xpath("//div[@class='fare-avail ui-corner-all']/div[contains(@class,'fare')]/input");

	private final By inputBefore = By.xpath("//div[contains(@class,'fare')]/label/preceding-sibling::input");
	private final By inputFromMain = By.cssSelector("#OriginLocation_Combobox");
	
	private final By valueDay = By.xpath("//div[@class='hdr']/.//h3");
	private final By valueTime = By.xpath("//div[@class='departure']//strong");

	private Ticket ticket = new Ticket();

	public ResultsTicketPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
	}
	
	public String checkEmptyTicket() {
		if(existsElement(valueDay)) {
			String day = driver.findElement(valueDay).getText();
			return day;
		}
		return null;
	}
	
	
	public void searchTicketPrices() {
		if(checkEmptyTicket() != null) {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
			System.out.println(checkEmptyTicket());
		System.out.println(getFlightTime());
		List<WebElement> elements = driver.findElements(labelElement);
		for(WebElement label : elements) {
			if(existsElement(inputElement)){
				System.out.println(label.getText());
			}
		}
		searchTicketClasses();
		}
		
	}
	
	public void searchTicketClasses() {
		if(checkEmptyTicket() != null) {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> elements = driver.findElements(inputElement);
		for(WebElement input : elements) {
			if(existsElement(inputElement)){
				System.out.println(input.getAttribute("id"));
			}
		}
		}
		
	}
	
	private boolean existsElement(By id) {
	    try {
	        driver.findElement(id);
	        return true;
	    } catch (NoSuchElementException e) {
	    	return false;
	    }
	}
	
	public String getFlightTime() {
		String time = driver.findElement(valueTime).getText();
		return time;
	}
	
	public MainPage ClickReturnButton() {
		WebDriverWait waitResPage = new WebDriverWait(driver, 30);
		waitResPage.until(ExpectedConditions.elementToBeClickable(returnButton));
		driver.findElement(returnButton).click();
		waitResPage.until(ExpectedConditions.visibilityOfElementLocated(inputFromMain));
		return new MainPage(driver);
	}
	
	
	
	
	

}
