package basePackage;


public class TestApplication {

	public static void main(String[] args) {
		ParkingGarage garage = new ParkingGarage();
		
		
		/*
		QuickDate qD1 = new QuickDate();
		QuickDate qD2 = new QuickDate(1510741240000L);
		System.out.println(qD1 + "\n" + qD2);
		System.out.println(qD1.compareYears(qD2) + " " + qD1.compareMonths(qD2) + " " + qD1.compareDays(qD2) + " " + qD1.compareHours(qD2));
		WorkTruck truck = new WorkTruck(null, null, null, null, 0);
		System.out.println((truck instanceof Car) + " " + (truck instanceof WorkTruck));
		*/
		for (int i = 0; i < 305; i++) {garage.parkValet(new Sedan("Sedan", "Sedan", "Sedan", "sedan", 1));}
		garage.printGarage();
		
	}
	
}
