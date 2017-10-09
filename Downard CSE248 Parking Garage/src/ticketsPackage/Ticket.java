package ticketsPackage;

import basePackage.*;
import carsPackage.Car;

public interface Ticket {

	void setTicket(Ticket tick);
	Ticket setCar(Car myCar);
	Car getCar();
	String getName();
	double calculateBill(QuickDate endDate);
	double calcBill();
	double getRate();
	QuickDate getDate();
	
}
