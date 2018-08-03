package by.htp.kyzniatsova.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar extends MainPage {

	private final By inputDateTo = By.xpath("//div[@id='step-2']/div[2]/div[1]/div/a");
	private final By getLeftMonthYear = By.xpath("//div[@id='calendar']/div/div[1]/div/div");
	private final By getRightMonthYear = By.xpath("//div[@id='calendar']/div/div[2]/div/div");
	private final By getPreviousCalendarMonth = By.xpath("//div[@id='calendar']/div/div[1]/div/a");
	private final By getNextCalendarMonth = By.xpath("//div[@id='calendar']/div/div[2]/div/a");
	private final By getDayOfMonth = By.xpath("//*[@id='calendar']/div/div[1]/table/tbody/tr[1]/td[3]/a");
	
	private final By inputLeftCalendar = By.xpath("//div[@id='step-2']/div[2]/div[1]/div/a");
	private final By getTableTd = By.xpath("//div[@id='calendar']/div/div[contains(@class,'ui-datepicker-group-first')]/table/descendant::td/a");
	
	public Calendar(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
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
		waitDate.until(ExpectedConditions.elementToBeClickable(inputLeftCalendar));
		driver.findElement(inputLeftCalendar).click();
		List<WebElement> list = driver.findElements(getTableTd);
		for(WebElement td : list) {
			System.out.println(td.getText());
		}
	}
	
	public void chooseDate(String date) {
		WebDriverWait waitDate = new WebDriverWait(driver, 10);
		waitDate.until(ExpectedConditions.elementToBeClickable(getTableTd));
		List<WebElement> list = driver.findElements(getTableTd);
		for(WebElement td : list) {
			if(td.getText().equals(date)) {
				td.click();
				break;
			}
		}
	}

}
