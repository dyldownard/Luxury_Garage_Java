package basePackage;

import java.util.Date;

public class DateHandler {
	@SuppressWarnings("deprecation")
	public int compareHours(Date startDate, Date endDate) {
		int startTimeH = startDate.getHours();				//using deprecated method for convienence
		int endTimeH = endDate.getHours();
		
		int timeToReturn = endTimeH - startTimeH;		// Amount of time being returned after calculation.
		
		if (checkMinuteTime(startDate.getMinutes(),endDate.getMinutes())) {
			timeToReturn++;
		}

		
		
		return 0;
	}
	
	
	private boolean checkMinuteTime(int startM, int endM) {
		if (endM - startM == 0) {
			return false;			// dont bill them
		}	
		return true;				// bill them
	}
	
}
