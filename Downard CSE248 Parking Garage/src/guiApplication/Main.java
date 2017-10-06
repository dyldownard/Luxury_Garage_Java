package guiApplication;

import basePackage.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	
	
	BorderPane bpane;
	MenuPane mpane;
	TabPanes tpane;
	ParkingGarage CarPark;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		CarPark = new ParkingGarage();
		
		bpane = new BorderPane();
		mpane = new MenuPane();
		tpane = new TabPanes(CarPark);
		bpane.setTop(mpane.getBar());
		bpane.setCenter(tpane.getTabPane());
		
		
		openSetup();
		
		
		
		
		Scene scene = new Scene(bpane, 700, 500);
		primaryStage.setTitle("Parking Lot CSE248");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
	public void openSetup() {
		//TODO opens up most recent file, into view
	}
	
	
	
	public void updateTabs() {		
		//TODO updates tabs of all floors 
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
