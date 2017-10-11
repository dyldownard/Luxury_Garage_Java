package guiApplication;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Random;

import carsPackage.*;
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
import ticketsPackage.*;
/**
 * universal controller to park cars, valet or not
 */
public class ParkCarPane implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6329106506803959803L;
	private GridPane gpane;
	private StackPane parktypepane;
	private Label parktype;
	private HBox namemake;
	private HBox modelyearplate;
	private HBox CarTypeColorBox;
	private HBox dateTime;
	private HBox TicketTypePark;
	private HBox pricePerXBox;
	private HBox ticketBox;
	private Label ticketnum;
	private TextField name;
	private TextField make;
	private TextField model;
	private TextField year;
	private TextField plate;
	private Label pricePerX;
	private transient DatePicker datePick;
	private TimePicker timePick;
	private ComboBox<String> CarType;
	private ComboBox<String> ColorBox;
	private ComboBox<String> TicketType;
	private Button Park;
	private Main mainGUI;
	
	private String ticketNum;
	
	private int spot;
	private GUIFloor floor;
	private ToolTipStackPane pane;
	
	//--------------------------------------------------------	
	/**
	 * constructor for pane
	 * @param spot spot being parked in, >0 if it is valet
	 * @param floor floor originated from
	 * @param pane pane being used
	 */
	public ParkCarPane(int spot, GUIFloor floor, ToolTipStackPane pane) {
		this.spot = spot;
		this.floor = floor;
		this.pane = pane;
		
		gpane = new GridPane();
		parktypepane = new StackPane();
		name = new TextField();
		make = new TextField();
		namemake = new HBox();
		model = new TextField();
		year = new TextField();
		plate = new TextField();
		modelyearplate = new HBox();
		ticketBox = new HBox();
		ticketnum = new Label();
		CarType = new ComboBox<String>();
		ColorBox = new ComboBox<String>();
		CarTypeColorBox = new HBox();
		datePick = new DatePicker();
		timePick = new TimePicker();
		dateTime = new HBox();
		TicketType = new ComboBox<String>();
		Park = new Button("Park Car");
		TicketTypePark = new HBox();
		pricePerX = new Label();
		pricePerXBox = new HBox();
		
		
		gpane.setAlignment(Pos.CENTER);
		parktypepane.setAlignment(Pos.CENTER);
		
		for (int i = 0; i < 9; i++) {
			RowConstraints row = new RowConstraints();
			row.setPercentHeight(100/7);
			gpane.getRowConstraints().add(row);
		}
		
		String tickChars = "1234567890";
		StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < 5; i++) {
	        sb.append(tickChars.charAt(random.nextInt(tickChars.length())));
	    }
		
	    ticketNum = sb.toString();
	    ticketnum.setText("Your Ticket # is: " + ticketNum);
	    ticketnum.setFont(Font.font("Calibri", 20));
	    ticketBox.getChildren().add(ticketnum);
	    ticketBox.setAlignment(Pos.CENTER);
	    
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
		
		pricePerXBox.getChildren().add(pricePerX);
		pricePerXBox.setAlignment(Pos.CENTER);

		
		gpane.add(parktypepane, 0, 0);
		gpane.add(ticketBox, 0, 1);
		gpane.add(namemake, 0, 2);
		gpane.add(modelyearplate, 0, 3);
		gpane.add(CarTypeColorBox, 0, 4);
		gpane.add(dateTime, 0, 5);
		gpane.add(TicketTypePark, 0, 6);
		gpane.add(pricePerXBox, 0, 7);
		
		name.setPromptText("Name (First Last)");
		make.setPromptText("Make (Honda)");
		model.setPromptText("Model (Civic)");
		year.setPromptText("Year (19XX,20XX)");
		plate.setPromptText("Plate (ABC-####)");
		datePick.setPromptText("MM/DD/YYYY");
		
		pricePerX.setFont(Font.font("Calibri",20));
		
		ColorBox.getItems().addAll(
			"Black",
			"White",
			"Red",
			"Blue",
			"Gray"
		);
		
		ColorBox.setPromptText("ColorBox");
		
		TicketType.getItems().addAll(
			floor.getGarage().TICKET_TYPES
		);		
		TicketType.setPromptText("Ticket Type");
		
		if (spot > 0) {
			parktype= new Label("Attempting to Park Car in spot " + pane.getSpotName() + " on floor " + (floor.getFloorNum() + 1));
			parktype.setFont(Font.font("Calibri",20));
			CarType.getItems().addAll(
				floor.getStackPanes()[spot - 1].getAllowedTypes()
			);
		}else {
			parktype= new Label("Valet Parking Service at No Extra Charge");
			parktype.setFont(Font.font("Calibri",20));
			CarType.getItems().addAll(
				floor.getGarage().CAR_TYPES
			);
		}
		CarType.setPromptText("Car Type");
		parktypepane.getChildren().add(parktype);
		CarType.requestFocus();
		setParkGo();
		setTicketChange();
		setCarChange();
	}
	
	//--------------------------------------------------------	
	/**
	 * gets root pane
	 * @return root gridpane
	 */
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
	
	//--------------------------------------------------------	
	/** 
	 * checks if all items are filled out in order to make a car correctly
	 * @return true/false based on items
	 */
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
	
	//--------------------------------------------------------	
	/**
	 * updates price on GUI based on user input
	 */
	private void UpdatePrice() {
		if (CarType.getSelectionModel().isEmpty() == false && TicketType.getSelectionModel().isEmpty() == false) {
			String tick;
			double amount = 0;
			String tickType = TicketType.getValue().replaceAll("\\s+", "");
			switch (tickType) {
				case "HourlyRate": tick = "per Hour"; amount = HourlyRate.RATE; break;
				case "MinutelyRate": tick = "per Minute"; amount = MinutelyRate.RATE; break;
				case "MonthlyRate": tick = "per Month"; amount = MonthlyRate.RATE; break;
				default: tick = "Error"; amount = 0; break;
			}
			String carType = CarType.getValue().replaceAll("\\s+" , "");
			switch(carType) {
				case "Bus": amount = amount * Bus.MONEY_MULT; break;
				case "Handicap": amount = amount * Handicap.MONEY_MULT; break;
				case "Motorcycle": amount = amount * Motorcycle.MONEY_MULT; break;
				case "PickupTruck": amount = amount * PickupTruck.MONEY_MULT; break;
				case "Sedan": amount = amount * Sedan.MONEY_MULT; break;
				case "Van": amount = amount * Van.MONEY_MULT; break;
				case "WorkTruck": amount = amount * WorkTruck.MONEY_MULT; break;
				default: amount = 0; break;
			}
			DecimalFormat b = new DecimalFormat("#.00");
			pricePerX.setText("The price is " + b.format(amount) + " USD " + tick);
		}
	}
	
	//--------------------------------------------------------	
	/**
	 * event for setting ticket to update price
	 */
	private void setTicketChange() {
		TicketType.setOnAction(e -> {
			UpdatePrice();
		});
	}
	
	/**
	 * event for setting car to update price
	 */
	private void setCarChange() {
		CarType.setOnAction(e -> {
			UpdatePrice();
		});
	}
	
	/**
	 * cannot cast and use method at same time, cheat by sending casted object to method
	 * gives ticket a ticketnumber
	 * @param realTick ticket to be assigned a number
	 */
	private void giveTicketNumber(Ticket realTick, ToolTipStackPane pane) {
		System.out.println("Ticket: " + ticketNum + " @ " + pane.getSpotName());
		realTick.setTickNum(ticketNum);
	}
	/**
	 * cannot cast and use method at same time, cheat by sending casted object to method
	 * @param realCar car to get pane from
	 * @return pane 
	 */
	private ToolTipStackPane getPanefromCar(Car realCar) {
		return realCar.getMyPane();
	}
	/**
	 * cannot cast and use method at same time, cheat by sending casted object to method
	 * @param realCar car to be assigned a color
	 * @param newCol color to be assigned
	 */
	private void giveColor(Car realCar, Color newCol) {
		realCar.setColor(newCol, ColorBox.getValue());
	}
	
	//--------------------------------------------------------	
	/**
	 * attempts to park the car based on the fields
	 * it isn't -possible- to actually throw the exceptions based on user choice. it can only fail if someone edits/adds code incorrectly
	 */
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
					ZonedDateTime samezone = newDate.atZone(ZoneId.of("America/New_York"));
					String myclass = CarType.getValue().replaceAll("\\s+", "");
					Class<?> myCar = Class.forName("carsPackage." + myclass);
					Constructor<?> create = myCar.getConstructor(String.class,String.class, String.class, String.class, Color.class, int.class);
					Object realCar = create.newInstance(model.getText(), make.getText(), year.getText(), plate.getText(), newCol, (spot-1));
					
					myclass = TicketType.getValue().replaceAll("\\s+", "");
					Class<?> myTicket = Class.forName("ticketsPackage." + myclass);
					create = myTicket.getConstructor(String.class, String.class, QuickDate.class);
					Object realTick = create.newInstance(name.getText(), plate.getText(), new QuickDate(samezone.toInstant().toEpochMilli()));
				
					
					
					if (spot < 0) {
						floor.getGarage().parkValet((Car) realCar,(Ticket) realTick);
						mainGUI.updateTabs();
						pane = getPanefromCar((Car) realCar);
						giveColor((Car) realCar, newCol);
					} else {
						floor.getGarage().parkCar((Car) realCar,(Ticket) realTick, floor, (spot - 1), pane);
						giveColor((Car) realCar, newCol);
					}
					
					
					
					pane.setRealCar((Car) realCar);
					pane.setLocaldate(datePick.getValue());
					giveTicketNumber((Ticket) realTick, pane);
					
				} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
					System.out.println("cannot be triggered by user error, only programmer's error via Car/Tickets set up wrong.");
					e1.printStackTrace();
				}
				mainGUI.tempStage.close();
			}else {
				parktype.setText(checkItems());
			}
			
		});
	}
}
