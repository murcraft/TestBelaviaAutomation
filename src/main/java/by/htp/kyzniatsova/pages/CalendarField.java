package by.htp.kyzniatsova.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarField extends MainPage {

	private final By inputLeftCalendar = By.xpath("//div[@id='step-2']/div[2]/div[1]/div/a");
	private final By getTableTd = By.xpath("//div[@id='calendar']/div/div[contains(@class,'ui-datepicker-group-first')]/table/descendant::td/a");
	
	WebDriverWait wait;
	
	public CalendarField(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	
	public void parseDates() {
		wait.until(ExpectedConditions.elementToBeClickable(inputLeftCalendar));
		driver.findElement(inputLeftCalendar).click();
		List<WebElement> list = driver.findElements(getTableTd);
		for(WebElement td : list) {
			System.out.println(td.getText());
		}
	}
	
	public void chooseDate() {
		List<WebElement> list = driver.findElements(getTableTd);
		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat format = new SimpleDateFormat("dd");
		String date = format.format(calendar.getTime());
		String day = String.valueOf(Integer.parseInt(date));
		for(WebElement td : list) {
			if(td.getText().contains(day)) {
				td.click();
				break;
			}
		}
	}

}
