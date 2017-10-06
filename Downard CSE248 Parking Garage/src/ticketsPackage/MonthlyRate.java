package ticketsPackage;

import basePackage.*;
import carsPackage.Car;

public class MonthlyRate implements Ticket{

	
	private double rate = 230.00D;	// 230.00 USD PER MONTHLY (unit of time monthly)
	
	private String customerName;
	private String liscensePlate;
	private QuickDate startTime;
	
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
		return (myCar.getMoneyMult() * this.rate) * this.startTime.compareMinutes(endDate);
	}

	@Override
	public double calcBill() {
		return (myCar.getMoneyMult() * this.rate) * 1;
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


	public QuickDate getStartTime() {
		return startTime;
	}


	public Car getMyCar() {
		return myCar;
	}


	@Override
	public void setTicket(Ticket tick) {
	}

	
}
