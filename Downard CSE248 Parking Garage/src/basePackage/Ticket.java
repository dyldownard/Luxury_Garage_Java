package basePackage;
import java.util.Date;

public class Ticket implements TicketInterfaces{

	
	private String customerName;
	private String liscensePlate;
	private String billingType;
	private Car myCar;
	private Date startTime;


	public Ticket(String name, String liscensePlate, Car myCar) {
		this.startTime = new Date();
	}
}
