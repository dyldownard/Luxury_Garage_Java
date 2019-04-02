# Luxury_Garage_Java
Teacher-assigned project on building a parking garage ground-up in Java.

README:


@Author Dylan T. Downard, CSE 248 Prof. Chen
@Email dyldownard@outlook.com
@github https://github.com/battlebutts



Warning:

For some reason, when using Search to pick up your car, the Scene will appear blank. Resizing it by 1px minimum will fix this.

After hours of debugging, I gave up on it and figured it was some odd Java bug.



Mission Statement - The purpose of this program is to be able to park cars in a malleable parking lot.
The parkinglot should be modular and be able to change with ease. The parkinglot takes in cars by either
valet (places in next available logical spot) or by choosing a spot. After this, the GUI grid updates the(all) floor(s).
You may search for cars via their ticket's number (Given at time of parking) or by their license plate. You may save, open and create
new parkinglots, and when the program starts it loads the most recently modified version. The Tabs represent the floors of
the parkinglot, and each gui floor has their own backend floor.


Things I missed:
- Went with simulated time instead of real time
- Did not implement an invoice system. Easily could implement going forward, just didn't think of it
- could not debug singular stage/scene debug on pickup car from searching ticket/plate


Layout:



File -

	New - Opens new ParkingGarage

	Save - Saves current Garage

	Open - Loads saved file

Edit -

	Valet - Parks car in first available spot

	Pickup Car -

		Search by Ticket - searches for your car VIA your ticket number

		Search by Plate - searches for your car VIA your license plate

Help -

	About - my information





How to work:

Very obvious you park and pick up cars. Just remember to attempt to write down your ticket# for searching. There is also a print in the console for your ticket number with respective space.
