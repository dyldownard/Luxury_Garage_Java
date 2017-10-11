package guiApplication;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import basePackage.ParkingGarage;
import basePackage.QuickDate;
import carsPackage.Car;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.util.Callback;
import ticketsPackage.*;
/**
 * pane for picking cars up, regardless of method
 */
public class PickupCarPane implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4787028376788124247L;
	GridPane gpane;
	HBox methodFind;
	TextField method;
	Button Find;
	Label name;
	HBox dateTime;
	transient DatePicker datePick;
	TimePicker timePick;
	HBox hoursPer;
	Label hoursBetwix;
	Label perHour;
	Label amountDue;
	Button pay;
	
	ParkingGarage carPark;
	
	Main main;
	ToolTipStackPane parent;
	
	Ticket myTick;
	
	//--------------------------------------------------------	
	/**
	 * constructor for the 
	 * @param myCar car being picked
	 * @param parent pane where the car came from
	 * @param carPark ParkingGarage for car
	 * @param main MainGUI for later use
	 */
	public PickupCarPane(Car myCar, ToolTipStackPane parent, ParkingGarage carPark, Main main) {
		this.carPark = carPark;
		this.main = main;
		this.parent = parent;
		myTick = myCar.getTicket();
		
		
		gpane = new GridPane();
		name = new Label("Picking up " + parent.getSpotName() + " on floor " + (parent.getFloorNum() + 1));
		dateTime = new HBox();
		datePick = new DatePicker();
		if (myCar.getTicket().getDate().getMinutes() < 55) {
			timePick = new TimePicker(myCar.getTicket().getDate().getHours(), (myCar.getTicket().getDate().getMinutes() + 5), this);
		} else {
			timePick = new TimePicker((myCar.getTicket().getDate().getHours() + 1), 0, this);
		}
		timePick.setCurDate(myCar.localDate);
		hoursPer = new HBox();
		hoursBetwix = new Label();
		perHour = new Label();
		amountDue = new Label();
		pay = new Button("Pay");
		
		Callback<DatePicker, DateCell> dayCellFactory = 
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                           
                            if (item.isBefore(
                            		parent.getLocaldate().plusDays(0))
                                ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: red;");
                            }   
                    }
                };
            }
        };
		
        datePick.setDayCellFactory(dayCellFactory);
        
		name.setFont(Font.font("Calibri",20));
	    
		gpane.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE); // Default width and height
	    gpane.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
		
		name.setAlignment(Pos.CENTER);
		dateTime.getChildren().addAll(datePick, timePick.getHBox());
		dateTime.setAlignment(Pos.CENTER);
		hoursPer.getChildren().addAll(hoursBetwix, perHour);
		hoursPer.setAlignment(Pos.CENTER);
		hoursPer.setSpacing(10);
		pay.setAlignment(Pos.CENTER);

		gpane.add(name, 0, 1);
		GridPane.setHalignment(name, HPos.CENTER);
		gpane.add(dateTime, 0, 2);
		GridPane.setHalignment(dateTime, HPos.CENTER);
		gpane.add(hoursPer, 0, 3);
		GridPane.setHalignment(hoursPer, HPos.CENTER);
		gpane.add(amountDue, 0, 4);
		GridPane.setHalignment(amountDue, HPos.CENTER);
		gpane.add(pay, 0, 5);
		GridPane.setHalignment(pay, HPos.CENTER);
		gpane.setAlignment(Pos.CENTER);
		
		
		
		RowConstraints row = new RowConstraints();
	    row.setPercentHeight(100/6);
	    for (int i = 0; i < 6; i++) {
	        gpane.getRowConstraints().add(row);
	    }
	    
		pickupCar();
		setActionDate();
	}
	
	//--------------------------------------------------------	
	
	/**
	 * sets event for updating label when changing date
	 */
	private void setActionDate() {
		datePick.setOnAction(e -> {
			timePick.setFutureDate(datePick.getValue());
			updateDifference();
		});
	}

	
	//--------------------------------------------------------	
	// Time Frame will always be 1 above, this is under the assumption that you are either 1:59 or 2:01, as a Real
	// life Parking Lot company would attempt to rig it to make more money. No such thing as "on time."
	
	/**
	 * updates label based on fields given
	 */
	public void updateDifference() {
		LocalDateTime newDate = LocalDateTime.of(datePick.getValue().getYear(), datePick.getValue().getMonth(), datePick.getValue().getDayOfMonth(), timePick.getHour(), timePick.getMin());
		ZonedDateTime samezone = newDate.atZone(ZoneId.of("America/New_York"));
		QuickDate endDate = new QuickDate(samezone.toInstant().toEpochMilli());
		DecimalFormat b = new DecimalFormat("#.00");
		if (myTick instanceof MonthlyRate) {
			hoursBetwix.setText("Months: " + (myTick.getDate().compareMonths(endDate) + 1));
			perHour.setText(myTick.getRate() + " per Month");
			amountDue.setText(b.format(myTick.calculateBill(endDate)) + " USD is the amount due");
		}else if(myTick instanceof HourlyRate) {
			hoursBetwix.setText("Hours: " + (myTick.getDate().compareHours(endDate) + 1));
			perHour.setText(myTick.getRate() + " per Hour");
			amountDue.setText(b.format(myTick.calculateBill(endDate)) + " USD is the amount due");
		}else if(myTick instanceof MinutelyRate) {
			hoursBetwix.setText("Minutes: " + (myTick.getDate().compareMinutes(endDate) + 1));
			perHour.setText(myTick.getRate() + " per Minute");
			amountDue.setText(b.format(myTick.calculateBill(endDate)) + " USD is the amount due");
		}
	}
	
	//--------------------------------------------------------	
	/**
	 * event for when you press pay to destroy car from all references
	 */
	public void pickupCar() {
		pay.setOnMouseClicked(e -> {
			if (amountDue.getText().equals("") == false) {
				parent.getRealCar().PickCar();
				carPark.getCarsArray().getAr()[parent.getRealCar().getSpotGlobalArray()] = null;
				carPark.getFloorsArray().getAr()[parent.getRealCar().getFloor().getFloorNum()].getCarsAr().getAr()[parent.getRealCar().getSpotnum()] = null;
				main.tempStage.close();
			}
		});
	}
	/**
	 * gets root pane
	 * @return root pane
	 */
	public GridPane getGridPane() {
		return gpane;
	}
}
