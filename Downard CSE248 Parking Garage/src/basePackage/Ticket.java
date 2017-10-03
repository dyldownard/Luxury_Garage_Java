package basePackage;

public class Ticket implements TicketInterfaces{

	
	private String customerName;
	private String liscensePlate;
	private Car myCar;
	private QuickDate startTime;

	
	
	public Ticket(String customerName, String liscensePlate, QuickDate date) {
		this.startTime = date;
		this.customerName = customerName;
		this.liscensePlate = liscensePlate;
	}


	public void setCar(Car car) {
		this.myCar = car;
	}
}
