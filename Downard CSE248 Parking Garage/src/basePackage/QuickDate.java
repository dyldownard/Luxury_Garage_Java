package basePackage;

import java.util.Date;

@SuppressWarnings("deprecation")
public class QuickDate extends Date {

	// original date
	final private int Years;
	final private int Months;
	final private int Days;
	final private int Hours;
	final private int Minutes;
//	// vars for conversion from gregorian y/m/d/h/m to total y/m/d/h/m
//	private int totalYears;
//	private int totalMonths;
//	private int totalDays;
//	private int totalHours;
//	private int totalMinutes;
	
	
	
	public QuickDate() {
		Years = this.getYear();
		Months = this.getMonth();
		Days = this.getDate();
		Hours = this.getHours();
		Minutes = this.getMinutes();
	}

	public QuickDate(long date) {
		super(date);
		Years = this.getYear();
		Months = this.getMonth();
		Days = this.getDate();
		Hours = this.getHours();
		Minutes = this.getMinutes();
	}

	//----------------------
	
	@Deprecated
	private void calculateTotals(QuickDate endDate) {
		// reset old totals
		totalYears = 0; totalMonths = 0; totalDays = 0; totalHours = 0; totalMinutes = 0;
		// temp vars to control calculations
		int tempY = this.Years; int tempMo = this.Months; 
		int tempD = this.Days; int tempH = this.Hours; int tempMi = this.Minutes;
		
		
 		if (this.Years == endDate.Years && this.before(endDate)) {
 			while (tempMo < endDate.Months) {
				while (tempD != checkMonthtoDayRatio(tempMo, tempY)) {
					while (tempH != 24) {
						while (tempMi != 60) {
							this.totalMinutes++;
							tempMi++;
						}
						this.totalHours++;
						tempH++;
						tempMi = 0;
					}
					this.totalDays++;
					tempD++;
					tempH = 0;
				}
				this.totalMonths++;
				tempMo++;
				tempD = 0;
			}
			while (tempD < endDate.Days - 1) {
				while (tempH != 24) {
					while (tempMi != 60) {
						this.totalMinutes++;
						tempMi++;
					}
					this.totalHours++;
					tempH++;
					tempMi = 0;
				}
				this.totalDays++;
				tempD++;
				tempH = 0;
			}
			while (tempH < endDate.Hours) {
				while (tempMi != 60) {
					this.totalMinutes++;
					tempMi++;
				}
				this.totalHours++;
				tempH++;
				tempMi = 0;
			}
			while (tempMi < endDate.Minutes) {
				this.totalMinutes++;
				tempMi++;
			}
		}
		
		return;
	}
	
	@Deprecated
	private int checkMonthtoDayRatio(int month, int year) {
		
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
			|| month == 10 || month == 12) { return 31; }				// months with 31 days
		if (month == 4 || month == 6 || month == 9 || month == 11) { return 30;}	// months with 30 days
			
		if (month == 2) {				// leap year math
			if (year % 100 == 0) {
				if (year % 400 == 0 && year % 4 == 0) {
					return 29;
				}
				return 28;
			}else if (year % 4 == 0) {
				return 29;
			}
			return 28;
		}
		return 0;
	}
	
	//----------------------
	public int compareYears(QuickDate endDate) {
		long secs = (endDate.getTime() - this.getTime()) / 1000;
		return (int) secs / 315536000;
	}
	public int compareMonths(QuickDate endDate) {
		long secs = (endDate.getTime() - this.getTime()) / 1000;
		return (int) secs / 2592000;
	}
	public int compareDays(QuickDate endDate) {
		long secs = (endDate.getTime() - this.getTime()) / 1000;
		return (int) secs / 86400;
	}
	public int compareHours(QuickDate endDate) {
		long secs = (endDate.getTime() - this.getTime()) / 1000;
		return (int) secs / 3600;
	}
	public int compareMinutes(QuickDate endDate) {
		long secs = (endDate.getTime() - this.getTime()) / 1000;
		return (int) secs / 60;
	}
	
}
