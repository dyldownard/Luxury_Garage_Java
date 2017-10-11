package ticketsPackage;

import java.io.Serializable;

import basePackage.*;
import carsPackage.Car;
/**
 * Ticket interface for array simplicity
 */
public interface Ticket extends Serializable{

	/**
	 * sets car to ticket
	 * @param myCar car to set
	 * @return ticket to set in car
	 */
	Ticket setCar(Car myCar);
	/**
	 * gets car from ticket
	 * @return ticket's car
	 */
	Car getCar();
	/**
	 * @return name of customer
	 */
	String getName();
	/**
	 * calculates bill based on several factors
	 * @param endDate date to base off of
	 * @return double amount
	 */
	double calculateBill(QuickDate endDate);
	/**
	 * gets the rate of the ticket
	 * @return double amount per unit of time
	 */
	double getRate();
	/**
	 * gets date for comparisons
	 * @return date
	 */
	QuickDate getDate();
	/**
	 * sets ticket number
	 * @param ticketNum ticketnum
	 */
	void setTickNum(String ticketNum);
	/**
	 * returns ticket num
	 * @return ticketnum
	 */
	String getTickNum();
	/**
	 * sets the ticket's spot in the array of ParkingGarage, probably going to deprecate/remove
	 * @param spot
	 */
	void setTicketGlobal(int spot);
	/** 
	 * gets the ticket's spot in the array of ParkingGarage, probably going to deprecate/remove
	 * @return
	 */
	int getTicketSpot();
}
