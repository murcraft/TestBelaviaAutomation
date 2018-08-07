package by.htp.kyzniatsova.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketsTablePage extends Page {
	
	private final By dateInColumns = By.xpath("//div[@class='h-outbound hidden-xs clear']/div");
	private final By ticketsInColumns = By.xpath("//div[@class='b-matrix clear']/div");
	private final By ticketPrices = By.xpath("//div[@class='details']/div[@class='price']");
	private final By ticketsInputs = By.xpath("//div[@class='details']/div/div/input");
	private final By ticketsAllColumns = By.xpath("//div[@class='details']");
	
	
	private final By nextButton = By.xpath("//div[@class='col-mb-6 text-right']/button");
	
	
	private WebDriverWait wait = new WebDriverWait(driver, 10);
	private String fieldDateRow = "";
	private String fieldDateColumn;

	public TicketsTablePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public String getFieldDateRow() {
		return fieldDateRow;
	}

	public void setFieldDateRow(String fieldDateRow) {
		this.fieldDateRow = fieldDateRow;
	}
	
	public String getFieldDateColumn() {
		return fieldDateColumn;
	}

	public void setFieldDateColumn(String fieldDateColumn) {
		this.fieldDateColumn = fieldDateColumn;
	}

	public void clickOnTicket(String availibleDate) {
		List<WebElement> dateFields = driver.findElements(dateInColumns);
		dateFields.remove(0);
		List<WebElement> tickets = driver.findElements(ticketsInColumns);
		
		for (int i = 0; i < dateFields.size(); i++) {
			if (dateFields.get(i).getAttribute("id").contains(fieldDateRow)) {
				WebElement price = tickets.get(i).findElement(By.className("price"));
				if (price != null) {
					price.click();
					wait.until(ExpectedConditions.attributeToBe(price, "class", "price selected"));
					clickOnNextButton();
					break;
				}
			}
		}
	}

	public void clickOnTicketFieldInRow(String date) {
		List<WebElement> dates = driver.findElements(dateInColumns);
		dates.remove(0);
		List<WebElement> tickets = driver.findElements(ticketPrices);
		Pattern pattern = Pattern.compile("(\\d{2}-?){3}");
		for (int j = 0; j < dates.size(); j++) {
			if (dates.get(j).getAttribute("id").contains(date)) {
				String[] splitDates = date.split("_");
				if (splitDates.length > 1) {
					date = splitDates[1];
				}
				for (int k = 0; k < tickets.size(); k++) {
					WebElement input = tickets.get(k).findElement(By.tagName("input"));
					String dateValue = input.getAttribute("value");
					Matcher matcher = pattern.matcher(dateValue);
					matcher.find();
					dateValue = matcher.group(0);
					if (dateValue.contains(dateValue)) {
						if (input != null) {
							tickets.get(k).click();
							wait.until(ExpectedConditions.attributeToBe(tickets.get(k), "class", "price selected"));
							clickOnNextButton();
							j = dates.size();
							break;
						}
					}
				}
			}
		}
	}

	public void clickOnTicketFieldInColumn(String date) {
		List<WebElement> dates = driver.findElements(dateInColumns);
		dates.remove(0);
		List<WebElement> datesInColumns = driver.findElements(dateInColumns);
		dates.remove(0);
		List<WebElement> tickets = driver.findElements(ticketsInputs);
		for (int i = 0; i < dates.size(); i++) {
			if (dates.get(i).getAttribute("id").contains(fieldDateRow)) {
				for (int j = 0; j < datesInColumns.size(); j++) {
					if (datesInColumns.get(j).getAttribute("id").contains(date)) {
						String[] splitDate = date.split("_");
						if (splitDate.length > 1) {
							date = splitDate[1];
						}
						for (int k = 0; k < tickets.size(); k++) {
							if (tickets.get(k).getAttribute("value").contains(date)) {
								WebElement cost = tickets.get(k).findElement(By.xpath("parent::*/parent::*"));
								if (cost != null) {
									cost.click();
									wait.until(ExpectedConditions.attributeToBe(cost, "class", "price selected"));
									clickOnNextButton();
									j = datesInColumns.size();
									i = dates.size();
									break;
								}
							}
						}
					}
				}
			}
		}

	}
	public String getNextDateInRowOnClick(Calendar lastDateOnClick) {
		List<WebElement> dates = driver.findElements(dateInColumns);
		dates.remove(0);
		
		String lastDate = "";
		
		List<WebElement> tickets = driver.findElements(ticketsAllColumns);
		for (int i = 0; i < dates.size(); i++) {
			String dateValue = dates.get(i).getAttribute("id");
			String[] splitDate = dateValue.split("_");
			if (splitDate.length > 1) {
				dateValue = splitDate[1];
			}
			SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
			Calendar currDate = new GregorianCalendar();
			try {
				currDate.setTime(format.parse(dateValue));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (currDate.after(lastDateOnClick)) {
				List<WebElement> elements = tickets.get(i).findElements(By.tagName("div"));
				for (int j = 0; j < elements.size(); j++) {
					if (elements.get(j).getAttribute("class").equals("price")) {
						lastDate = dates.get(i).getAttribute("id");
						lastDateOnClick.setTime(currDate.getTime());
						i = dates.size();
						break;
					}
				}
			}
		}
		return lastDate;
	}

	public String getNextDateInColumnOnClick(Calendar lastDate) {
		String lastDateState = "";
		List<WebElement> dates = driver.findElements(dateInColumns);
		dates.remove(0);
		for (int i = dates.size() - 1; i >= 0; i--) {
			String dateValue = dates.get(i).getAttribute("id");
			String[] splitDates = dateValue.split("_");
			if (splitDates.length > 1) {
				dateValue = splitDates[1];
			}
			SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd");
			Calendar currParsingDate = new GregorianCalendar();
			try {
				currParsingDate.setTime(formatter.parse(dateValue));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (currParsingDate.before(lastDate)) {
				List<WebElement> element = driver.findElements(ticketPrices);
				for (int j = 0; j < element.size(); j++) {
					if (element.get(j).getAttribute("class").equals("price")) {
						WebElement elWithPrice = element.get(j).findElement(By.tagName("input"));
						if (elWithPrice.getAttribute("value").contains(dateValue)) {
							lastDateState = dates.get(i).getAttribute("id");
							lastDate.setTime(currParsingDate.getTime());
							i = -1;
							break;
						}
					}
				}
			}
		}
		return lastDateState;
	}

	public void clickOnNextButton() {
		driver.findElement(nextButton).click();
	}

	@Override
	public void openPage() {
		
	}

}
