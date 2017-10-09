package ticketsPackage;

import basePackage.*;
import carsPackage.Car;

public class HourlyRate implements Ticket{

	
	private double rate = 10.00D;	// 10.00 USD PER HOUR (unit of time hourly)
	
	private String customerName;
	private String liscensePlate;
	private QuickDate startTime;
	
	private Car myCar;
	
	public HourlyRate(String customerName, String liscensePlate, QuickDate date) {
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
		return (myCar.getMoneyMult() * this.rate) * this.startTime.compareHours(endDate);
	}

	@Override
	public double calcBill() {
		return (myCar.getMoneyMult() * this.rate) * 1.5;
	}

	public double getRate() {
		return rate;
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
	public void setTicket(Ticket tick) {
	}


	@Override
	public String getName() {
		return this.customerName;
	}


	@Override
	public QuickDate getDate() {
		return this.startTime;
	}

	
}
