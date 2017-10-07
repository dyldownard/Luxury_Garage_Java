package guiApplication;

import basePackage.ParkingGarage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class ParkCarPane {

	private GridPane gpane;
	private StackPane parktypepane;
	private Label parktype;
	private HBox namemake;
	private HBox modelyearplate;
	private HBox CarTypeColor;
	private HBox dateTime;
	private HBox TicketTypePark;
	private TextField name;
	private TextField make;
	private TextField model;
	private TextField year;
	private TextField plate;
	private DatePicker datePick;
	private TimePicker timePick;
	private ComboBox<String> CarType;
	private ComboBox<String> Color;
	private ComboBox<String> TicketType;
	private Button Park;
	
	
	public ParkCarPane(int spot, GUIFloor floor) {
		
		gpane = new GridPane();
		parktypepane = new StackPane();
		name = new TextField();
//		name.setFocusTraversable(false);
		make = new TextField();
//		make.setFocusTraversable(false);
		namemake = new HBox();
		model = new TextField();
//		model.setFocusTraversable(false);
		year = new TextField();
		//year.setFocusTraversable(false);
		plate = new TextField();
		//plate.setFocusTraversable(false);
		modelyearplate = new HBox();
		CarType = new ComboBox<String>();
		Color = new ComboBox<String>();
		CarTypeColor = new HBox();
		datePick = new DatePicker();
		timePick = new TimePicker(5,30);
		dateTime = new HBox();
		TicketType = new ComboBox<String>();
		Park = new Button("Park Car");
		TicketTypePark = new HBox();
		
		gpane.setAlignment(Pos.CENTER);
		parktypepane.setAlignment(Pos.CENTER);
		
		for (int i = 0; i < 7; i++) {
			RowConstraints row = new RowConstraints();
			row.setPercentHeight(100/7);
			gpane.getRowConstraints().add(row);
		}
		
		
		namemake.getChildren().addAll(name,make);
		namemake.setAlignment(Pos.CENTER);
		namemake.setPadding(new Insets(10));
		namemake.setSpacing(10);
		
		modelyearplate.getChildren().addAll(model,year,plate);
		modelyearplate.setAlignment(Pos.CENTER);
		modelyearplate.setPadding(new Insets(10));
		modelyearplate.setSpacing(10);
		
		
		CarTypeColor.getChildren().addAll(CarType,Color);
		CarTypeColor.setAlignment(Pos.CENTER);
		CarTypeColor.setPadding(new Insets(10));
		CarTypeColor.setSpacing(10);
		
		dateTime.getChildren().addAll(datePick, timePick.getHBox());
		dateTime.setAlignment(Pos.CENTER);
		dateTime.setPadding(new Insets(10));
		dateTime.setSpacing(10);
		
		TicketTypePark.getChildren().addAll(TicketType, Park);
		TicketTypePark.setAlignment(Pos.CENTER);
		TicketTypePark.setPadding(new Insets(10));
		TicketTypePark.setSpacing(10);
		
		gpane.add(parktypepane, 0, 0);
		gpane.add(namemake, 0, 1);
		gpane.add(modelyearplate, 0, 2);
		gpane.add(CarTypeColor, 0, 3);
		gpane.add(dateTime, 0, 4);
		gpane.add(TicketTypePark, 0, 5);
		
		name.setPromptText("Name (First Last)");
		make.setPromptText("Make (Honda)");
		model.setPromptText("Model (Civic");
		year.setPromptText("Year (19XX,20XX)");
		plate.setPromptText("Plate (ABC-####)");
		
		Color.getItems().addAll(
			"Black",
			"White",
			"Red",
			"Blue",
			"Gray"
		);
		Color.setPromptText("Color");
		
		TicketType.getItems().addAll(
			ParkingGarage.TICKET_TYPES
		);		
		TicketType.setPromptText("Ticket Type");
		
		if (spot > 0) {
			parktype= new Label("Attempting to Park Car in spot " + spot + " on floor " + (floor.getFloorNum() + 1));
			parktype.setFont(Font.font("Calibri",20));
			CarType.getItems().addAll(
				floor.getStackPanes()[spot - 1].getAllowedTypes()
			);
		}else {
			CarType.getItems().addAll(
				ParkingGarage.CAR_TYPES
			);
		}
		CarType.setPromptText("Car Type");
		parktypepane.getChildren().add(parktype);
		CarType.requestFocus();
	}
	
	
	public GridPane getGridPane() {
		return this.gpane;
	}
	
	public Button getPark() {
		return this.Park;
	}
	
	public DatePicker getDatePicker() {
		return this.datePick;
	}
}
