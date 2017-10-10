package ticketsPackage;

import java.io.Serializable;

import basePackage.*;
import carsPackage.Car;

public interface Ticket extends Serializable{

	Ticket setCar(Car myCar);
	Car getCar();
	String getName();
	double calculateBill(QuickDate endDate);
	double getRate();
	QuickDate getDate();
	void setTickNum(String ticketNum);
	String getTickNum();
}
