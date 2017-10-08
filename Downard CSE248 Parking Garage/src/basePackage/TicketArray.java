package basePackage;

import carsPackage.Car;
import ticketsPackage.Ticket;

public class TicketArray {

	private Ticket[] aR;
	private int nElms;
	
	public TicketArray(int amount) {
		nElms = 0;
		aR = new Ticket[amount];
	}
	
	public Ticket addTicket(Ticket tick) {
		if (isFull()!=false) {
			aR[nElms++] =  tick;
		}
		return null;
	}
	
	
	public boolean isFull() {
		return (nElms==aR.length);
	}
	
}
