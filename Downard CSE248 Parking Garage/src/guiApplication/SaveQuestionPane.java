package guiApplication;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SaveQuestionPane {

	VBox vbox;
	HBox hbox;
	Label label;
	Button quicksave;
	Button nothanks;
	Main main;
	
	//--------------------------------------------------------	
	
	public SaveQuestionPane(Main main) {
		this.main = main;
		
		vbox = new VBox();
		hbox = new HBox();
		
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(30);
		vbox.setAlignment(Pos.CENTER);
		label = new Label("Save before exiting?");
		label.setFont(Font.font("Calibri",20));
		quicksave = new Button("Save");
		nothanks = new Button("No Thanks");
		hbox.getChildren().addAll(quicksave, nothanks);
		vbox.getChildren().addAll(label, hbox);
		setSave();
		setNo();
	}
	
	//--------------------------------------------------------	
	
	public VBox getvbox() {
		return this.vbox;
	}
	
	private void setSave() {
		quicksave.setOnMouseClicked(e -> {
			main.SaveWithClose();
		});
	}
	
	private void setNo() {
		nothanks.setOnMouseClicked(e -> {
			main.tempStage.close();
		});
	}
}
