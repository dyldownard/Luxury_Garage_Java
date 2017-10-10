package ticketsPackage;

import basePackage.*;
import carsPackage.Car;

public class HourlyRate implements Ticket{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1991745572749878514L;

	final static public double RATE = 10.00D;	// 10.00 USD PER HOUR (unit of time hourly)
	
	private String customerName;
	private String liscensePlate;
	private QuickDate startTime;
	
	private int ticketSpotGlobal;
	private String ticketNum;
	private Car myCar;
	
	//--------------------------------------------------------	
	
	public HourlyRate(String customerName, String liscensePlate, QuickDate date) {
		this.customerName = customerName;
		this.liscensePlate = liscensePlate;
		this.startTime = date;
	}
	
	//--------------------------------------------------------	
	
	@Override
	public Ticket setCar(Car myCar) {
		this.myCar = myCar;
		return this;
	}

	@Override
	public Car getCar() {
		return myCar;
	}

	@Override
	public double calculateBill(QuickDate endDate) {
		return ((myCar.getMoneyMult() * RATE) * this.startTime.compareHours(endDate)) + RATE;	// + 1 unit since you can never park it on time
	}


	public double getRate() {
		return RATE;
	}


	public String getCustomerName() {
		return customerName;
	}


	public String getLiscensePlate() {
		return liscensePlate;
	}


	public Car getMyCar() {
		return myCar;
	}

	@Override
	public String getName() {
		return this.customerName;
	}


	@Override
	public QuickDate getDate() {
		return this.startTime;
	}
	@Override
	public void setTickNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}


	@Override
	public String getTickNum() {
		return this.ticketNum;
	}
	
	@Override
	public void setTicketGlobal(int spot) {
		this.ticketSpotGlobal = spot;
	}


	@Override
	public int getTicketSpot() {
		return this.ticketSpotGlobal;
	}
	
}
