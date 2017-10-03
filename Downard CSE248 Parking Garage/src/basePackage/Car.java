package basePackage;

public abstract class Car {

	
	private Ticket tick;
	private String model; private String make; private String year; private String platenum;
	private int spotnum;
	private String spaceType;
	private double moneyMult;
	
	public Car(String model, String make, String year, String platenum, int spotnum, String spaceType, double moneyMult) {
		this.model = model;
		this.make = make;
		this.year = year;
		this.platenum = platenum;
		this.spotnum = spotnum;
		this.spaceType = spaceType;
		this.moneyMult = moneyMult;
	}
	
	public void setTicket(Ticket tick) {
		this.tick = tick;
		tick.setCar(this);
	}
	
	
	public String getSpaceType() {
		return this.spaceType;
	}
	
	
}
