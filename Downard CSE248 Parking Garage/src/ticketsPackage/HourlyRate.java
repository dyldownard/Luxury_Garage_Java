package ticketsPackage;

import basePackage.*;
import carsPackage.Car;
/**
 * billing rate based on hour
 */
public class HourlyRate implements Ticket{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1991745572749878514L;
	/**
	 * RATE Amount of USD per unit of time
	 */
	final static public double RATE = 10.00D;	// 10.00 USD PER HOUR (unit of time hourly)
	
	private String customerName;
	private String liscensePlate;
	private QuickDate startTime;
	
	private int ticketSpotGlobal;
	private String ticketNum;
	private Car myCar;
	
	//--------------------------------------------------------	
	
	/**
	 * constructor
	 * @param customerName name of customer
	 * @param liscensePlate plate#
	 * @param date date of park
	 */
	public HourlyRate(String customerName, String liscensePlate, QuickDate date) {
		this.customerName = customerName;
		this.liscensePlate = liscensePlate;
		this.startTime = date;
	}
	
	//--------------------------------------------------------	
	
	/* (non-Javadoc)
	 * @see ticketsPackage.Ticket#setCar(carsPackage.Car)
	 */
	@Override
	public Ticket setCar(Car myCar) {
		this.myCar = myCar;
		return this;
	}

	/* (non-Javadoc)
	 * @see ticketsPackage.Ticket#getCar()
	 */
	@Override
	public Car getCar() {
		return myCar;
	}

	/* (non-Javadoc)
	 * @see ticketsPackage.Ticket#calculateBill(basePackage.QuickDate)
	 */
	@Override
	public double calculateBill(QuickDate endDate) {
		return ((myCar.getMoneyMult() * RATE) * this.startTime.compareHours(endDate)) + RATE;	// + 1 unit since you can never park it on time
	}


	/* (non-Javadoc)
	 * @see ticketsPackage.Ticket#getRate()
	 */
	public double getRate() {
		return RATE;
	}


	/**
	 * @return
	 */
	public String getCustomerName() {
		return customerName;
	}


	/**
	 * @return
	 */
	public String getLiscensePlate() {
		return liscensePlate;
	}


	/**
	 * @return
	 */
	public Car getMyCar() {
		return myCar;
	}

	/* (non-Javadoc)
	 * @see ticketsPackage.Ticket#getName()
	 */
	@Override
	public String getName() {
		return this.customerName;
	}


	/* (non-Javadoc)
	 * @see ticketsPackage.Ticket#getDate()
	 */
	@Override
	public QuickDate getDate() {
		return this.startTime;
	}
	/* (non-Javadoc)
	 * @see ticketsPackage.Ticket#setTickNum(java.lang.String)
	 */
	@Override
	public void setTickNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}


	/* (non-Javadoc)
	 * @see ticketsPackage.Ticket#getTickNum()
	 */
	@Override
	public String getTickNum() {
		return this.ticketNum;
	}
	
	/* (non-Javadoc)
	 * @see ticketsPackage.Ticket#setTicketGlobal(int)
	 */
	@Override
	public void setTicketGlobal(int spot) {
		this.ticketSpotGlobal = spot;
	}


	/* (non-Javadoc)
	 * @see ticketsPackage.Ticket#getTicketSpot()
	 */
	@Override
	public int getTicketSpot() {
		return this.ticketSpotGlobal;
	}
	
}
