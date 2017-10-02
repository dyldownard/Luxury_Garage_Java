package basePackage;

public interface CarInterfaces extends WorkTruck, PickupTruck, Van, Sedan, Motorcycle, Bus, Handicap {}

// CONTENTS: 
//Car Type Interfaces
//-types of car i.e. truck, van, sedan


//		 Required Layout:
// -!- (double) moneyMult - How much more they have to pay per unit of time compared to base pay
// -!- (String) spaceType - what type of spot they require i.e. sedans go in normal motorcycle goes in small bus goes in large
//-Types = Small, Normal, Large;

/*	-VEHICLES-	*/

interface WorkTruck {
	double moneyMult = 5.0;
	String spaceType = "Large";
}

interface PickupTruck {
	double moneyMult = 3;
	String spaceType = "Normal";
}

interface Van {
	double moneyMult = 2.5;
	String spaceType = "Normal";
}

interface Sedan {
	double moneyMult = 1;
	String spaceType = "Normal";
}

interface Motorcycle {
	double moneyMult = 0.85;
	String spaceType = "Small";
}

interface Bus {
	double moneyMult = 4.0;
	String spaceType = "Small";
}

interface Handicap {
	double moneyMult = 0.99;
	String spaceType = "Normal";	// i will go on the assumption that a bus cannot be considered "handicapped"
									// and/or a huge work truck cannot be handicapped, neither can a motorcycle
}