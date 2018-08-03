package by.htp.kyzniatsova.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.kyzniatsova.entity.Ticket;

public class ResultsTicketPage extends Page {
	
	private final By textContainer = By.xpath("//div[contains(@class,'fare')]/label");
	private final By nextButton = By.xpath("//div[contains(@class,'bottom-buttons')]/.//button[@value='next']");
	private final By inputElement = By.xpath("//div[@class='fare-avail ui-corner-all']/div[contains(@class,'fare')]/input");
	private final By linkCalendar = By.xpath("//div[@class='hdr']/descendant::div[contains(@class,'text-right')]/a");
	private final By labelElement = By.xpath("//div[contains(@class,'fare')]/label");
	private final By divInputElement = By.xpath("//div[@class='fare-avail ui-corner-all']/div[contains(@class,'fare')]");
	private final String inputEl = "//div[@class='fare-avail ui-corner-all']/div[contains(@class,'fare')]/input";
	
	private final By labelBefore = By.xpath("//div[contains(@class,'fare')]/label/following-sibling::*");
	
	//preceding-sibling::
	private Ticket ticket = new Ticket();

	public ResultsTicketPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
	}
	
	public void  searchText() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		System.out.println(driver.findElement(linkCalendar).getText());
		
		List<WebElement> elements = driver.findElements(inputElement);
		for(WebElement label : elements) {
			
			if(existsElement(inputEl)){
//				WebElement el = driver.findElement(By.id("progress"));
//				wait.until(ExpectedConditions.elementToBeClickable(label));
//				el..click();
				System.out.println(label.getAttribute("id"));
				System.out.println(label.getAttribute("value"));
				
			}


			
		}
	}
	
	private boolean existsElement(String id) {
	    try {
	        driver.findElement(By.xpath(id));
	        return true;
	    }catch (WebDriverException we) {
	    	return false;
	    }
	}
	
	

}
