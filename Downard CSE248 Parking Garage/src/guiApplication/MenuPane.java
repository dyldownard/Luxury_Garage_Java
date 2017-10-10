package guiApplication;

import java.io.Serializable;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuPane implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1936241993618090380L;

	private MenuBar bar;
	
	private Menu File;
	private Menu Edit;
	private Menu Help;
	
	private Menu pickup;
	
	private MenuItem newPark;
	private MenuItem open;
	private MenuItem save;
	private MenuItem valet;
	private MenuItem pTicket;
	private MenuItem pPlate;
	private MenuItem about;
	
	private Button doIt;
	
	//private Stage primaryStage;
	Boolean inAction; 
	
	//--------------------------------------------------------	
	
	public MenuPane(Stage primaryStage, Boolean action){
		//this.primaryStage = primaryStage;
		inAction = action;
		
		bar = new MenuBar();
		
		File = new Menu("File");
		Edit = new Menu("Edit");
		Help = new Menu("Help");
		
		pickup = new Menu("Pick-Up Car");
		
		newPark = new MenuItem("New");
		open = new MenuItem("Open");
		save = new MenuItem("Save as");
		valet = new MenuItem("Valet Park Car");
		pTicket = new MenuItem("Search by Ticket");
		pPlate = new MenuItem("Search by Plate");
		about = new MenuItem("About");
		
		File.getItems().addAll(newPark, open, save);
		Edit.getItems().addAll(valet, pickup);
		Help.getItems().add(about);
		
		pickup.getItems().addAll(pTicket, pPlate);
		
		bar.getMenus().addAll(File,Edit,Help);
		
		onNew();
	}
	
	//--------------------------------------------------------	
	
	private void onNew() {
		newPark.setOnAction(e -> {
			if (inAction.booleanValue() == false) {
				inAction = true;
				VBox vbox = new VBox();
				Label popLabel = new Label("This will delete your current work. Do you want to save?");
				doIt = new Button("Proceed");
				popLabel.setFont(Font.font("Calibri",20));
				
				vbox.getChildren().addAll(popLabel, doIt);
				vbox.setAlignment(Pos.CENTER);
				vbox.setSpacing(20);
	
				Stage popStage = new Stage();
				popStage.setAlwaysOnTop(true);
				popStage.setTitle("WARNING");
				Scene popScene = new Scene(vbox, 500, 100);
				popStage.setScene(popScene);
				popStage.showAndWait();
				inAction = false;
			}
		});
	}
	
	//--------------------------------------------------------		
	
	public MenuBar getMenu() {
		return this.bar;
	}
	
	public MenuItem getValet() {
		return this.valet;
	}
	
	public MenuItem getTicketSearch() {
		return this.pTicket;
	}
	
	public MenuItem getPlateSearch() {
		return this.pPlate;
	}
	
	public MenuItem getSave() {
		return this.save;
	}
	
	public MenuItem getNew() {
		return this.newPark;
	}
	
	public MenuItem getAbout() {
		return this.about;
	}
	public MenuItem getOpen() {
		return this.open;
	}
}