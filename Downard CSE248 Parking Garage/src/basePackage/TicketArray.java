package basePackage;

import ticketsPackage.Ticket;

public class TicketArray {

	private Ticket[] aR;
	private int nElms;
	
	public TicketArray(int amount) {
		nElms = 0;
		aR = new Ticket[amount];
	}
	
	
	
	
	public Ticket createTicket(String name, String liscensePlate, int time, Car myCar) {
		if (isFull()!=false) {
			//aR[nElms++] =  new DepTicket(name, liscensePlate, time);
		}
		return null;
	}
	
	
	public boolean isFull() {
		return (nElms==aR.length);
	}
	
}
