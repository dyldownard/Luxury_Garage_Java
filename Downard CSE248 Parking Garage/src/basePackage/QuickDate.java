package basePackage;

import java.util.Date;

@SuppressWarnings("deprecation")
public class QuickDate extends Date {

	private static final long serialVersionUID = 2308350077349978096L;
	
	// original date
	final private int Years;
	final private int Months;
	final private int Days;
	final private int Hours;
	final private int Minutes;

	@Deprecated
	public QuickDate() {
		Years = super.getYear();
		Months = super.getMonth();
		Days = super.getDate();
		Hours = super.getHours();
		Minutes = super.getMinutes();
	}

	public QuickDate(long date) {
		super(date);
		Years = super.getYear();
		Months = super.getMonth();
		Days = super.getDate();
		Hours = super.getHours();
		Minutes = super.getMinutes();
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
	public int compareWeeks(QuickDate endDate) {
		long secs = (endDate.getTime() - this.getTime()) / 1000;
		return (int) secs / 604800;
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

	public int getYears() {
		return Years;
	}

	public int getMonths() {
		return Months;
	}

	public int getDays() {
		return Days;
	}

	public int getHours() {
		return Hours;
	}

	public int getMinutes() {
		return Minutes;
	}
	
}
