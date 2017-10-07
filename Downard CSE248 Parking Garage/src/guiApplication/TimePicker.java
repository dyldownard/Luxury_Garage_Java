package guiApplication;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;

public class TimePicker {

	private HBox hbox;
	private Label label; 
	private Spinner<Integer> hourspinner;
	private Spinner<Integer> minutespinner;
	private Label conversion;
	
	public TimePicker() {
		hbox = new HBox();
		label = new Label("HH:MM");
		hourspinner = new Spinner<Integer>();
		minutespinner = new Spinner<Integer>();
		conversion = new Label();
		
		hbox.setAlignment(Pos.CENTER);
		hourspinner.setPrefSize(60, 20);
		minutespinner.setPrefSize(60, 20);
		
		
		SpinnerValueFactory<Integer> valueFactorHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,24);
		SpinnerValueFactory<Integer> valueFactorMinute = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,60,0,5);
		
		hourspinner.setValueFactory(valueFactorHour);
		minutespinner.setValueFactory(valueFactorMinute);
		
		if (hourspinner.getValue() > 12) {
			if (minutespinner.getValue() == 0) {
				conversion.setText((hourspinner.getValue()-12) + ":00 PM");
			}else {
				conversion.setText((hourspinner.getValue()-12) + ":" + minutespinner.getValue() + " PM");
			}
		}else {
			if (minutespinner.getValue() == 0) {
				conversion.setText(hourspinner.getValue() + ":00 AM");
			}else {
				conversion.setText(hourspinner.getValue() + ":" + minutespinner.getValue() + " AM");
			}
		}
		
		hbox.getChildren().addAll(label, hourspinner,minutespinner, conversion);
		setChanged();
	}
	
	public TimePicker(int h, int m) {
		hbox = new HBox();
		label = new Label("HH:MM");
		hourspinner = new Spinner<Integer>();
		minutespinner = new Spinner<Integer>();
		conversion = new Label();
		
		hbox.setAlignment(Pos.CENTER);
		hourspinner.setPrefSize(60, 20);
		minutespinner.setPrefSize(60, 20);
		
		
		SpinnerValueFactory<Integer> valueFactorHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(h,24);
		SpinnerValueFactory<Integer> valueFactorMinute = new SpinnerValueFactory.IntegerSpinnerValueFactory(m,60,m,5);
		
		hourspinner.setValueFactory(valueFactorHour);
		minutespinner.setValueFactory(valueFactorMinute);
		
		if (hourspinner.getValue() > 12) {
			if (minutespinner.getValue() == 0) {
				conversion.setText((hourspinner.getValue()-12) + ":00 PM");
			}else {
				conversion.setText((hourspinner.getValue()-12) + ":" + minutespinner.getValue() + " PM");
			}
		}else {
			if (minutespinner.getValue() == 0) {
				conversion.setText(hourspinner.getValue() + ":00 AM");
			}else {
				conversion.setText(hourspinner.getValue() + ":" + minutespinner.getValue() + " AM");
			}
		}
		
		
		hbox.getChildren().addAll(label, hourspinner,minutespinner, conversion);
		setChanged(h,m);
	}
	
	
	public HBox getHBox() {
		return this.hbox;
	}
	private void setChanged() {
		hourspinner.setOnMouseClicked(e -> {
			if (hourspinner.getValue() > 12) {
				if (minutespinner.getValue() == 0) {
					conversion.setText((hourspinner.getValue()-12) + ":00 PM");
				}else {
					conversion.setText((hourspinner.getValue()-12) + ":" + minutespinner.getValue() + " PM");
				}
			}else {
				if (minutespinner.getValue() == 0) {
					conversion.setText(hourspinner.getValue() + ":00 AM");
				}else {
					conversion.setText(hourspinner.getValue() + ":" + minutespinner.getValue() + " AM");
				}
			}
		});
	}
	
	private void setChanged(int h, int m) {
		hourspinner.setOnMouseClicked(e -> {
			if (hourspinner.getValue() > h) {
				SpinnerValueFactory<Integer> valueFactorMinute;
				if (m <= minutespinner.getValue()) {
					valueFactorMinute = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,60,minutespinner.getValue(),5);
				}else {
					valueFactorMinute = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,60,m,5);
				}
				minutespinner.setValueFactory(valueFactorMinute);
			}else {
				SpinnerValueFactory<Integer> valueFactorMinute = new SpinnerValueFactory.IntegerSpinnerValueFactory(m,60,m,5);
				minutespinner.setValueFactory(valueFactorMinute);
			}
			if (hourspinner.getValue() > 12) {
				if (minutespinner.getValue() == 0) {
					conversion.setText((hourspinner.getValue()-12) + ":00 PM");
				}else {
					conversion.setText((hourspinner.getValue()-12) + ":" + minutespinner.getValue() + " PM");
				}
			}else {
				if (minutespinner.getValue() == 0) {
					conversion.setText(hourspinner.getValue() + ":00 AM");
				}else {
					conversion.setText(hourspinner.getValue() + ":" + minutespinner.getValue() + " AM");
				}
			}
		});
	}
}
