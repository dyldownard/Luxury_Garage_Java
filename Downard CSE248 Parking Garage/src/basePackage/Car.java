package basePackage;

public class Car implements CarInterfaces {

	
	private Ticket tick;
	private boolean tickpermbool = true;	// boolean to simplify ticket or permit check. true == ticket, false == permit
	private String model; private String make; private String year; private String platenum;
	private int spotnum;
	
	public Car(String model) {
		this.model = model;
	}
	
	
	
}
