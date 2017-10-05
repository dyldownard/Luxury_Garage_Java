package guiApplication;

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
	TabPane tpane;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		bpane = new BorderPane();
		mpane = new MenuPane();
		tpane = new TabPane();
		Tab tab = new Tab();
		 tab.setText("new tab");
		Tab tab2 = new Tab();
		 tab2.setText("lol");
		 tab.setContent(new Rectangle(200,200, Color.LIGHTSTEELBLUE));
		 tab2.setContent(new Rectangle(200,200, Color.BEIGE));
		 tpane.getTabs().addAll(tab,tab2);
		bpane.setTop(mpane.getBar());
		bpane.setCenter(tpane);
		
		
		Scene scene = new Scene(bpane, 500, 500);
		primaryStage.setTitle("Parking Lot CSE248");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
	
	
	
	
	public void updateTabs() {		//updates tabs of all floors 
		
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
