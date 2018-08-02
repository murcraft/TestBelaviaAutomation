package by.htp.kyzniatsova.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends Page {
	
	private final By textContainer = By.xpath("//div[contains(@class,'fare')]/label");
	private final By nextButton = By.xpath("//div[contains(@class,'bottom-buttons')]/descendant::button[@value='next']");
	private final By inputElement = By.xpath("//input[contains(@id,'LowFareMatrixDataModels')]");

	public SearchResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
	}
	
	public void  searchText() {
		List<WebElement> elements = driver.findElements(inputElement);
		for(WebElement label : elements) {
			System.out.println(label.getText());
		}
	}
	
	private boolean existsElement(String id) {
	    try {
	        driver.findElement(By.id(id));
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	}
	
	

}
