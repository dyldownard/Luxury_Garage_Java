package basePackage;


public class TestApplication {

	public static void main(String[] args) {
		ParkingGarage garage = new ParkingGarage();
		garage.printGarage();	// for testing
		
		QuickDate qD1 = new QuickDate(1506545430000L);
		QuickDate qD2 = new QuickDate(1510741240000L);
		System.out.println(qD1 + "\n" + qD2);
		System.out.println(qD1.compareYears(qD2) + " " + qD1.compareMonths(qD2) + " " + qD1.compareDays(qD2) + " " + qD1.compareHours(qD2));
		
	}
	
}
