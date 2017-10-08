package guiApplication;

import basePackage.*;
import carsPackage.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	
	Stage tempStage;
	BorderPane bpane;
	MenuPane mpane;
	TabPanes tpane;
	ParkCarPane parkPane;
	
	ParkingGarage CarPark;
	
	int amountTabs;
	
	int i;		// for setaction array
	int j;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		CarPark = new ParkingGarage();
		
		bpane = new BorderPane();
		mpane = new MenuPane();
		tpane = new TabPanes(CarPark);
		bpane.setTop(mpane.getBar());
		bpane.setCenter(tpane.getTabPane());
		
//		for (int i = 0; i < 35; i++) {
//			Car sed = new Sedan("Sedan", "Sedan", "Sedan", "sedan", new Color(Math.random(),Math.random(),Math.random(), 1), 1);
//			CarPark.parkValet(sed);
//		}
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
	}
	
	private void setCarClicked() {
		for(int i = 0; i < tpane.getFloors().length; i++) {
			for(int j = 0; j < tpane.getFloors()[i].getStackPanes().length; j++) {
				final ToolTipStackPane actionStack = tpane.getFloors()[i].getStackPanes()[j];
				
				actionStack.setOnMouseClicked(e -> {
					if (actionStack.hasCar() == false) {
						parkPane = new ParkCarPane(actionStack.getSpotNum(), tpane.getFloors()[actionStack.getFloorNum()]);
						parkPane.setMain(this);
						Scene tempScene = new Scene(parkPane.getGridPane(), 500, 500);
						tempStage = new Stage();
						
						tempStage.setTitle("Test");
						tempStage.setScene(tempScene);
						parkPane.getDatePicker().requestFocus();
						tempStage.showAndWait();
					}else {
						
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
