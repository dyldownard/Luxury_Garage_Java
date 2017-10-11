package basePackage;

import java.util.Date;

public class QuickDate extends Date {




	/**
	 * 
	 */
	private static final long serialVersionUID = 991629730320004318L;
	/**
	 * amounts for all units of time (that we care about)
	 */
	final private int Years;
	final private int Months;
	final private int Days;
	final private int Hours;
	final private int Minutes;

	//--------------------------------------------------------	

	/**
	 * constructor from long epochTime
	 * @param date miliseconds since epoch
	 */
	public QuickDate(long date) {
		super(date);
		Years = super.getYear();
		Months = super.getMonth();
		Days = super.getDate();
		Hours = super.getHours();
		Minutes = super.getMinutes();
	}
		
	//--------------------------------------------------------	
	
	/**
	 * compares years
	 * @param endDate time to compare to
	 */
	public int compareYears(QuickDate endDate) {
		long secs = (endDate.getTime() - this.getTime()) / 1000;
		return (int) secs / 315536000;
	}
	/**
	 * compares months
	 * @param endDate time to compare to
	 */
	public int compareMonths(QuickDate endDate) {
		long secs = (endDate.getTime() - this.getTime()) / 1000;
		return (int) secs / 2592000;
	}
	/**
	 * compares weeks
	 * @param endDate time to compare to
	 */
	public int compareWeeks(QuickDate endDate) {
		long secs = (endDate.getTime() - this.getTime()) / 1000;
		return (int) secs / 604800;
	}
	/**
	 * compares days
	 * @param endDate time to compare to
	 */
	public int compareDays(QuickDate endDate) {
		long secs = (endDate.getTime() - this.getTime()) / 1000;
		return (int) secs / 86400;
	}
	/**
	 * compares hours
	 * @param endDate time to compare to
	 */
	public int compareHours(QuickDate endDate) {
		long secs = (endDate.getTime() - this.getTime()) / 1000;
		return (int) secs / 3600;
	}
	/**
	 * compares minutes
	 * @param endDate time to compare to
	 */
	public int compareMinutes(QuickDate endDate) {
		long secs = (endDate.getTime() - this.getTime()) / 1000;
		return (int) secs / 60;
	}
	
	//--------------------------------------------------------	

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
