package guiApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import basePackage.QuickDate;
import carsPackage.Car;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Callback;
import ticketsPackage.*;

public class PickupCarPane {

	BorderPane bpane;
	HBox methodFind;
	TextField method;
	Button Find;
	VBox vbox;
	Label name;
	HBox dateTime;
	DatePicker datePick;
	TimePicker timePick;
	HBox hoursPer;
	Label hoursBetwix;
	Label perHour;
	Label amountDue;
	Button pay;
	
	Ticket myTick;
	// TODO make 3; one accepts Car (click on gui), One search by Plate#, one by Ticket#
	
	public PickupCarPane(Car myCar, ToolTipStackPane parent) {
		System.out.println(myCar.getMake());
		myTick = myCar.getTicket();
		
		bpane = new BorderPane();
		vbox = new VBox();
		name = new Label("Picking up " + parent.getSpotName() + " on floor " + (parent.getFloorNum() + 1));
		dateTime = new HBox();
		datePick = new DatePicker();
		if (myCar.getTicket().getDate().getMinutes() < 55) {
			timePick = new TimePicker(myCar.getTicket().getDate().getHours(), (myCar.getTicket().getDate().getMinutes() + 5));
		} else {
			timePick = new TimePicker((myCar.getTicket().getDate().getHours() + 1), 0);
		}
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
                            		parent.getLocaldate().getValue().plusDays(0))
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
		
		vbox.getChildren().addAll(name, dateTime, hoursPer, amountDue, pay);
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(20);
		dateTime.getChildren().addAll(datePick, timePick.getHBox());
		dateTime.setAlignment(Pos.CENTER);
		hoursPer.getChildren().addAll(hoursBetwix, perHour);
		hoursPer.setAlignment(Pos.CENTER);
		bpane.setCenter(vbox);
		
		
		BorderPane.setAlignment(vbox, Pos.CENTER);
		
		setActionTimeM();
		setActionTimeH();
		setActionDate();
	}
	
	
	
	private void setActionTimeM() {
		timePick.getMinSpin().setOnMouseClicked(e -> {
			updateDifference();
		});
	}
	
	private void setActionTimeH() {
		timePick.getHourSpin().setOnMouseClicked(e -> {
			updateDifference();
		});
	}
	
	private void setActionDate() {
		datePick.setOnAction(e -> {
			updateDifference();
		});
	}
	
	// Time Frame will always be 1 above, this is under the assumption that you are either 1:59 or 2:01, as a Real
	// life Parking Lot company would attempt to rig it to make more money. No such thing as "on time."
	
	private void updateDifference() {
		LocalDateTime newDate = LocalDateTime.of(datePick.getValue().getYear(), datePick.getValue().getMonth(), datePick.getValue().getDayOfMonth(), timePick.getHour(), timePick.getMin());
		ZonedDateTime samezone = newDate.atZone(ZoneId.of("America/New_York"));
		QuickDate endDate = new QuickDate(samezone.toInstant().toEpochMilli());
		if (myTick instanceof MonthlyRate) {
			hoursBetwix.setText("Months: " + (myTick.getDate().compareMonths(endDate) + 1));
			perHour.setText(myTick.getRate() + " per Month");
			amountDue.setText(myTick.calcBill() + "USD is the amount due");
		}else if(myTick instanceof HourlyRate) {
			hoursBetwix.setText("Hours: " + (myTick.getDate().compareHours(endDate) + 1));
			perHour.setText(myTick.getRate() + " per Hour");
			amountDue.setText(myTick.calcBill() + "USD is the amount due");
		}else if(myTick instanceof MinutelyRate) {
			hoursBetwix.setText("Minutes: " + (myTick.getDate().compareMinutes(endDate) + 1));
			perHour.setText(myTick.getRate() + " per Minute");
			amountDue.setText(myTick.calcBill() + "USD is the amount due");
		}
	}
	
	
	public BorderPane getBorderPane() {
		return bpane;
	}
	
	
	
}
