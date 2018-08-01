package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends Page {
	
	private final By textContainer = By.xpath("//*[@id=\"matrix\"]/div[2]/div/div[2]/div/div[2]");

	public SearchResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
	}
	
	public void  searchText() {
		List<WebElement> elements = driver.findElements(textContainer);
		
		for(WebElement div : elements) {
			WebElement el = div.findElement(By.xpath("//*[@id=\"matrix\"]/div[6]/div/div[2]/div/label"));
			System.out.println(el.getText());
		}
	}

}
