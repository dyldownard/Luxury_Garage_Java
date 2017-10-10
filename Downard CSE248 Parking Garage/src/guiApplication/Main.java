package guiApplication;

import basePackage.*;
import carsPackage.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ticketsPackage.*;

public class Main extends Application {
	
	Stage primaryStage;
	Stage tempStage;
	BorderPane bpane;
	MenuPane mpane;
	TabPanes tpane;
	ParkCarPane parkPane;
	PickupCarPane pickPane;
	
	ParkingGarage CarPark;
	
	Boolean inAction;
	
	int amountTabs;
	
	int i;		// for setaction array
	int j;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
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
		inAction = false;
		setCarClicked();
		setHovered();
		setUnhovered();
		setExited();
	}
	
	private void setExited() {
		primaryStage.setOnCloseRequest(e -> {
			Platform.exit();
		});
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
						tempStage.setTitle("Park Car");
						tempStage.setScene(tempScene);
						parkPane.getDatePicker().requestFocus();
						tempStage.showAndWait();
						inAction = false;
					}else if(actionStack.hasCar() == true && inAction == false) {
						pickPane = new PickupCarPane(actionStack.getRealCar(), actionStack);
						
						Scene tempScene = new Scene(pickPane.getBorderPane(), 500, 500);
						tempStage = new Stage();
						inAction = true;
						tempStage.setTitle("Pickup Car");
						tempStage.setScene(tempScene);
						tempStage.showAndWait();
						inAction = false;
					}
				});
			}
		}
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
