package guiApplication;


import basePackage.*;
import carsPackage.Car;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
	
	Stage primaryStage;
	Stage tempStage;
	BorderPane bpane;
	MenuPane mpane;
	TabPanes tpane;
	ParkCarPane parkPane;
	PickupCarPane pickPane;
	SearchPane searchPane;
	
	ParkingGarage CarPark;
	
	Boolean inAction;
	
	int amountTabs;
	
	int i;		// for setaction array
	int j;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		inAction = false;
		this.primaryStage = primaryStage;
	
		CarPark = new ParkingGarage();
		
		bpane = new BorderPane();
		tpane = new TabPanes(CarPark);
		mpane = new MenuPane(primaryStage, inAction);
		bpane.setTop(mpane.getMenu());
		bpane.setCenter(tpane.getTabPane());
		
		
		
//		for (int i = 0; i < 130; i++) {
//			Car sed = new Sedan("Sedan", "Sedan", "Sedan", "sedan", new Color(Math.random(),Math.random(),Math.random(), 1), 1);
//			Ticket tick = new HourlyRate("Ted", "Bundy", new QuickDate());
//			CarPark.parkValet(sed, tick);
//		}
		
		
//		Ticket tick = new HourlyRate("Ted", "Bundy", new QuickDate());
//		Car sed = new Sedan("Sedan", "Sedan", "Sedan", "sedan", new Color(Math.random(),Math.random(),Math.random(), 1), 1);
//		CarPark.parkValet(sed, tick);
//		updateTabs();
//		sed.PickCar();
//		System.out.println(sed.getFloor().getFloorNum() + "  " + sed.getFloor().getAmountCars());
//		CarPark.getFloorsArray().getAr()[sed.getFloor().getFloorNum()].getCarsAr().getAr()[sed.getSpotnum()] = null;
//
//		sed = null;
//		
//		System.gc();
		Platform.setImplicitExit(false);
		updateTabs();
		setEventMethods();
		
		openSetup();
		
		
		
		
		Scene scene = new Scene(bpane, 700, 700);
		primaryStage.setTitle("Parking Lot CSE248");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
	public void openSetup() {
		//TODO opens up most recent file, into view
	}
	
	public void updateTabs() {		
		tpane.updateGrid();
	}
	
	public void setEventMethods() {
		setCarClicked();
		setHovered();
		setUnhovered();
		setExited();
		parkValet();
		setOnTickSearch();
		setOnCarSearch();
	}
	
	private void setExited() {
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent closeEvent) {
            	if (inAction == true) {
            		closeEvent.consume();
            	}else {
            		Platform.exit();
            	}
            }
        });
	}
	
	
	
	public void onSaveRequest() {
		
	}
	
	private void setOnTickSearch() {
		mpane.getTicketSearch().setOnAction(e -> {
			if (inAction == false) {
				searchPane = new SearchPane("tick", this);
				inAction = true;
				Scene tempScene = new Scene(searchPane.getVBox(), 400, 300);
				tempStage = new Stage();
				tempStage.setTitle("Search");
				tempStage.setScene(tempScene);
				tempStage.showAndWait();
				inAction = false;
			}
		});
	}
	
	private void setOnCarSearch() {
		mpane.getPlateSearch().setOnAction(e -> {
			if (inAction == false) {
				searchPane = new SearchPane("car", this);
				inAction = true;
				Scene tempScene = new Scene(searchPane.getVBox(), 400, 300);
				tempStage = new Stage();
				tempStage.setTitle("Search");
				tempStage.setScene(tempScene);
				tempStage.showAndWait();
				inAction = false;
			}
		});
	}
	
	public void SearchGo() throws InterruptedException {
		if(searchPane.isFound(CarPark) == true) {
			tempStage.close();
			Thread.sleep(1000);
			PickupCar(searchPane.getSearchResult(CarPark));
		}else {
			searchPane.getResult().setText("Could not find from entry.");
		}
	}
	
	private void setCarClicked() {
		for(int i = 0; i < tpane.getFloors().length; i++) {
			for(int j = 0; j < tpane.getFloors()[i].getStackPanes().length; j++) {
				final ToolTipStackPane actionStack = tpane.getFloors()[i].getStackPanes()[j];
				actionStack.setOnMouseClicked(e -> {
					if (actionStack.hasCar() == false && inAction == false) {
						parkPane = new ParkCarPane(actionStack.getSpotNum(), tpane.getFloors()[actionStack.getFloorNum()], actionStack);
						parkPane.setMain(this);
						Scene tempScene = new Scene(parkPane.getGridPane(), 500, 500);
						tempStage = new Stage();
						inAction = true;
						tempStage.setAlwaysOnTop(true);
						tempStage.setTitle("Park Car");
						tempStage.setScene(tempScene);
						parkPane.getDatePicker().requestFocus();
						tempStage.showAndWait();
						inAction = false;
						updateTabs();
					}else if(actionStack.hasCar() == true && inAction == false) {
						pickPane = new PickupCarPane(actionStack.getRealCar(), actionStack, CarPark, this);
						Scene tempScene = new Scene(pickPane.getGridPane(), 500, 500);
						tempStage = new Stage();
						inAction = true;
						tempStage.setAlwaysOnTop(true);
						tempStage.setTitle("Pickup Car");
						tempStage.setScene(tempScene);
						tempStage.showAndWait();
						inAction = false;
						updateTabs();
					}
				});
			}
		}
	}

	private void parkValet() {
		mpane.getValet().setOnAction(e -> {
			if (inAction == false && CarPark.isFull() == false) {
				parkPane = new ParkCarPane(-1, tpane.getFloors()[0], null);
				parkPane.setMain(this);
				Scene tempScene = new Scene(parkPane.getGridPane(), 500, 500);
				tempStage = new Stage();
				inAction = true;
				tempStage.setAlwaysOnTop(true);
				tempStage.setTitle("Park Car Valet");
				tempStage.setScene(tempScene);
				parkPane.getDatePicker().requestFocus();
				tempStage.showAndWait();
				inAction = false;
				updateTabs();
			}else if (inAction == false && CarPark.isFull() == true) {
				tempStage = new Stage();
				inAction = true;
				tempStage.setAlwaysOnTop(true);
				Label label = new Label("Parking lot is full.");
				label.setAlignment(Pos.CENTER);
				label.setFont(Font.font("Calibri",20));
				tempStage.setScene(new Scene(label, 300, 100));
				tempStage.showAndWait();
				inAction = false;
			}
		});
	}
	
	private void PickupCar(Car myCar) {
		tempStage = null;
		pickPane = new PickupCarPane(myCar, myCar.getMyPane(), CarPark, this);
		//Scene tempScene = new Scene(pickPane.getVBox(), 400, 400);
		tempStage = new Stage();
		
		inAction = true;
		tempStage.setAlwaysOnTop(true);
		tempStage.setTitle("Pickup Car");
		tempStage.setScene(new Scene(pickPane.getGridPane(),400,400));
		tempStage.showAndWait();
		inAction = false;
		updateTabs();
	}
	private void setHovered() {
		for(int i = 0; i < tpane.getFloors().length; i++) {
			for(int j = 0; j < tpane.getFloors()[i].getStackPanes().length; j++) {
				final ToolTipStackPane actionStack = tpane.getFloors()[i].getStackPanes()[j];
				actionStack.setOnMouseEntered(e -> {
					actionStack.getLabel().setTextFill(Color.RED);
				});
			}
		}
	}
	private void setUnhovered() {
		for(int i = 0; i < tpane.getFloors().length; i++) {
			for(int j = 0; j < tpane.getFloors()[i].getStackPanes().length; j++) {
				final ToolTipStackPane actionStack = tpane.getFloors()[i].getStackPanes()[j];
				actionStack.setOnMouseExited(e -> {
					if (actionStack.hasCar() == true) {
						actionStack.getLabel().setTextFill(Color.WHITE);
					}else {
						actionStack.getLabel().setTextFill(Color.BLACK);
					}
				});
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
