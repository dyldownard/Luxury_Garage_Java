package ticketsPackage;

import basePackage.*;
import carsPackage.Car;

public class MonthlyRate implements Ticket{

	
	final static public double RATE = 2300.00D;	// 2300.00 USD PER MONTHLY (unit of time monthly)
	
	private String customerName;
	private String liscensePlate;
	private QuickDate startTime;
	
	private String ticketNum;
	private Car myCar;
	
	public MonthlyRate(String customerName, String liscensePlate, QuickDate date) {
		this.customerName = customerName;
		this.liscensePlate = liscensePlate;
		this.startTime = date;
	}
	
	
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
		return ((myCar.getMoneyMult() * RATE) * this.startTime.compareMonths(endDate)) + RATE;	// + 1 unit since you can never park it on time
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

	
}
