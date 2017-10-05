package ticketsPackage;

import basePackage.*;

public interface Ticket {

	void setTicket(Ticket tick);
	Ticket setCar(Car myCar);
	Car getCar();
	
	double calculateBill(QuickDate endDate);
	double calcBill();
	
}
