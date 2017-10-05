package ticketsPackage;

import basePackage.*;

public class MinutelyRate implements Ticket{

	
	private double rate = 1.10D;	// 1.10 USD PER MINUTE (unit of time minutes)
	
	private String customerName;
	private String liscensePlate;
	private QuickDate startTime;
	
	private Car myCar;
	
	public MinutelyRate(String customerName, String liscensePlate, QuickDate date) {
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
