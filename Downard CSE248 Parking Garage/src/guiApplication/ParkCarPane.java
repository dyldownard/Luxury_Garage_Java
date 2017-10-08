package guiApplication;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import carsPackage.*;
import basePackage.ParkingGarage;
import basePackage.QuickDate;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import ticketsPackage.Ticket;

public class ParkCarPane {

	private GridPane gpane;
	private StackPane parktypepane;
	private Label parktype;
	private HBox namemake;
	private HBox modelyearplate;
	private HBox CarTypeColorBox;
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
	private ComboBox<String> ColorBox;
	private ComboBox<String> TicketType;
	private Button Park;
	private Main mainGUI;
	
	private int spot;
	private GUIFloor floor;
	
	
	public ParkCarPane(int spot, GUIFloor floor) {
		this.spot = spot;
		this.floor = floor;
		
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
		ColorBox = new ComboBox<String>();
		CarTypeColorBox = new HBox();
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
		
		
		CarTypeColorBox.getChildren().addAll(CarType,ColorBox);
		CarTypeColorBox.setAlignment(Pos.CENTER);
		CarTypeColorBox.setPadding(new Insets(10));
		CarTypeColorBox.setSpacing(10);
		
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
		gpane.add(CarTypeColorBox, 0, 3);
		gpane.add(dateTime, 0, 4);
		gpane.add(TicketTypePark, 0, 5);
		
		name.setPromptText("Name (First Last)");
		make.setPromptText("Make (Honda)");
		model.setPromptText("Model (Civic)");
		year.setPromptText("Year (19XX,20XX)");
		plate.setPromptText("Plate (ABC-####)");
		datePick.setPromptText("MM/DD/YYYY");
		
		
		ColorBox.getItems().addAll(
			"Black",
			"White",
			"Red",
			"Blue",
			"Gray"
		);
		
		ColorBox.setPromptText("ColorBox");
		
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
		setParkGo();
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
	
	public void setMain(Main MainGUI) {
		this.mainGUI = MainGUI;
	}
	
	private String checkItems() {
		if (name.getText().equals("") == true) {
			return "Fill out Name field";
		}
		if (make.getText().equals("") == true) {
			return "Fill out Make field";
		}
		if (model.getText().equals("") == true) {
			return "Fill out Model field";
		}
		if (year.getText().equals("") == true) {
			return "Fill out Year field";
		}
		if (plate.getText().equals("") == true) {
			return "Fill out Plate field";
		}
		if (CarType.getSelectionModel().isEmpty() == true) {
			return "Select Car Type";
		}
		if (ColorBox.getSelectionModel().isEmpty() == true) {
			return "Select ColorBox";
		}
		if (datePick.getValue() == null) {
			return "Select a Date";
		}
		if (TicketType.getSelectionModel().isEmpty() == true) {
			return "Select a Ticket type";
		}
		return "";
	}
	
	private void setParkGo() {
		this.getPark().setOnMouseClicked(e -> {
			//check for all fields have values
			if (checkItems().equals("")) {
				try {
					Color newCol = Color.BLACK;
					if (ColorBox.getValue() == "Black") {
						newCol = Color.BLACK;
					}else if(ColorBox.getValue() == "White") {
						newCol = Color.WHITE;
					}else if(ColorBox.getValue() == "Red") {
						newCol = Color.RED;
					}else if(ColorBox.getValue() == "Blue") {
						newCol = Color.BLUE;
					}else if(ColorBox.getValue() == "Gray") {
						newCol = Color.GRAY;
					}
					
					LocalDateTime newDate = LocalDateTime.of(datePick.getValue().getYear(), datePick.getValue().getMonth(), datePick.getValue().getDayOfMonth(), timePick.getHour(), timePick.getMin());
					ZoneOffset zoneOffset = ZoneId.systemDefault().getRules().getOffset(newDate);
					String myclass = CarType.getValue().replaceAll("\\s+", "");
					Class<?> myCar = Class.forName("carsPackage." + myclass);
					Constructor<?> create = myCar.getConstructor(String.class,String.class, String.class, String.class, Color.class, int.class);
					Object realCar = create.newInstance(model.getText(), make.getText(), year.getText(), plate.getText(), newCol, (spot-1));
					
					myclass = TicketType.getValue().replaceAll("\\s+", "");
					Class<?> myTicket = Class.forName("ticketsPackage." + myclass);
					create = myTicket.getConstructor(String.class, String.class, QuickDate.class);
					Object realTick = create.newInstance(name.getText(), plate.getText(), new QuickDate(newDate.toEpochSecond(zoneOffset)));
					
					if (spot <= 0) {
						System.out.println(floor.getGarage().parkValet((Car) realCar, (Ticket) realTick));
					} else {
						System.out.println(floor.getGarage().parkCar((Car) realCar, (Ticket) realTick));
					}
					
					
					
				} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
					System.out.println("one of the 20 different exceptions triggered. good job.");
					e1.printStackTrace();
				}
				mainGUI.updateTabs();
				mainGUI.tempStage.close();
			}else {
				parktype.setText(checkItems());
			}
			
			
			
		});
	}
}
