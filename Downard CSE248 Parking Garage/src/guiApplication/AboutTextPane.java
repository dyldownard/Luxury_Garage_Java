package guiApplication;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class AboutTextPane {

	VBox vbox;
	Text credits;
	Text dash;
	Text dash2;
	
	public AboutTextPane() {
		vbox = new VBox();
		
		dash = new Text("~~~~~~~~~~~~~~");
		dash.setTextAlignment(TextAlignment.CENTER);
		dash.setFont(Font.font("Verdana", 20));
		
		credits = new Text("Dylan Downard, October 2017 SCCC\ndownd98@mail.sunysuffolk.edu");
		credits.setTextAlignment(TextAlignment.CENTER);
		credits.setWrappingWidth(400);
		credits.setFont(Font.font("Verdana", 20));
		
		dash2 = new Text("~~~~~~~~~~~~~~");
		dash2.setTextAlignment(TextAlignment.CENTER);
		dash2.setFont(Font.font("Verdana", 20));
		
		vbox.getChildren().addAll(dash, credits, dash2);
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(30);
	}

	public VBox getVBox() {
		return this.vbox;
	}
	
}
