package guiApplication;

import java.io.Serializable;

import basePackage.ParkingGarage;
import carsPackage.Car;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SearchPane implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1207032711600758933L;
	VBox vbox;
	HBox box;
	Label type;
	TextField searchby;
	Button search;
	Label result;
	Main main;
	
	//--------------------------------------------------------	
	
	public SearchPane(String giventype, Main main) {
		this.main = main;
		
		vbox = new VBox();
		box = new HBox();
		type = new Label();
		searchby = new TextField();
		search = new Button("Search");
		result = new Label();
		
		searchby.setPromptText("Search Value");
		search.setPadding(new Insets(20));
		result.setFont(Font.font("Calibri", 20));
		type.setFont(Font.font("Calibri", 20));
		
		if (giventype.equals("tick")) {
			type.setText("Ticket#:");
		}else {
			type.setText("Plate#:");
		}
		
		vbox.setAlignment(Pos.CENTER);
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);
		vbox.setSpacing(20);
		
		box.getChildren().addAll(type, searchby, search);
		vbox.getChildren().addAll(box, result);
		
		setOnSearchGo();
	}
	
	//--------------------------------------------------------	
	
	public Car getSearchResult(ParkingGarage park) {
		
		if (type.getText().equals("Ticket#:")) {
			if (park.searchTicket(searchby.getText()) == null ) { System.out.println("weird"); }
			return park.searchTicket(searchby.getText());
		}else {
			return park.searchCar(searchby.getText());
		}
	}
	
	//--------------------------------------------------------	
	
	public boolean isFound(ParkingGarage park) {
		if (type.getText().equals("Ticket#:")) {
			if (park.searchTicket(searchby.getText()) == null) {
				return false;
			}
		}else {
			if (park.searchCar(searchby.getText()) == null) {
				return false;
			}
		}
		return true;
	}
	
	//--------------------------------------------------------	
	
	private void setOnSearchGo() {
		search.setOnMouseClicked(e -> {
			try {
				main.SearchGo();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		});
	}
	
	//--------------------------------------------------------	
	
	public VBox getVBox() {
		return this.vbox;
	}
	public Label getResult() {
		return this.result;
	}
	
	public Button getGo() {
		return this.search;
	}
}
