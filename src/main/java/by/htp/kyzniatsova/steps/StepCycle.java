package by.htp.kyzniatsova.steps;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class StepCycle extends SearchOneWayStep {
	
	SearchOneWayStep stepneWay = new SearchOneWayStep();
	
	public int getDayOfMonth(int year, int month) {
		Calendar myCal = (Calendar)Calendar.getInstance().clone();
		myCal.set(year, month, 1);
		int maxDay = myCal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return maxDay;
	}
	
	public int getCurrentDay() {
		GregorianCalendar cal = new GregorianCalendar();
		return cal.get(Calendar.DATE);
	}

	public void cycleSteps(int year, int month) {
		int date1 = getCurrentDay();
		String date = "" + getCurrentDay();
		for(int i = date1; i <= getDayOfMonth(year, month); i++) {
			chooseDate(date); 
			clickButtonSearch(); 
			searchTickets();
			clickOnBackOnMain();
		}
	}
	
	
}
