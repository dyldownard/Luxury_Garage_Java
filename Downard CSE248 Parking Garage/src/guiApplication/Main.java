package guiApplication;

import basePackage.*;
import carsPackage.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	
	
	BorderPane bpane;
	MenuPane mpane;
	TabPanes tpane;
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
		
		for (int i = 0; i < 143; i++) {
			Car sed = new Sedan("Sedan", "Sedan", "Sedan", "sedan", new Color(Math.random(),Math.random(),Math.random(), 1), 1);
			CarPark.parkValet(sed);
		}
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
	}
	
	private void setCarClicked() {
		for(int i = 0; i < tpane.getFloors().length; i++) {
			for(int j = 0; j < tpane.getFloors()[i].getStackPanes().length; j++) {
				final ToolTipStackPane actionStack = tpane.getFloors()[i].getStackPanes()[j];
				
				actionStack.setOnMouseClicked(e -> {
					GridPane temppane = new GridPane();
					Scene tempScene = new Scene(temppane, 500, 500);
					Stage tempStage = new Stage();
					tempStage.setTitle("Test");
					tempStage.setScene(tempScene);
					tempStage.show();
				});
			}
		}
	}
	
//	private void setPark() {
//		mpane.getAbout().setOnAction(e -> { 
//			Scene aboutTemp = new Scene(aboutPane, 400, 550);
//			
//			Stage aboutStage = new Stage();
//			aboutStage.setTitle("About");
//			aboutStage.setScene(aboutTemp);
//			aboutStage.show();
//		});
//	}
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
