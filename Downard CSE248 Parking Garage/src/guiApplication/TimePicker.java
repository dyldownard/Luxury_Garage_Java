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
	private int initialh;
	private int initialm;
	
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
		SpinnerValueFactory<Integer> valueFactorMinute = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,55,0,5);
		
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
		setChangedH();
		setChangedM();
	}
	
	public TimePicker(int h, int m) {
		initialh = h;
		initialm = m;
		hbox = new HBox();
		label = new Label("HH:MM");
		hourspinner = new Spinner<Integer>();
		minutespinner = new Spinner<Integer>();
		conversion = new Label();
		
		hbox.setAlignment(Pos.CENTER);
		hourspinner.setPrefSize(60, 20);
		minutespinner.setPrefSize(60, 20);
		
		
		SpinnerValueFactory<Integer> valueFactorHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(h,24);
		SpinnerValueFactory<Integer> valueFactorMinute = new SpinnerValueFactory.IntegerSpinnerValueFactory(m,55,m,5);
		
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
		setChangedH(h,m);
		setChangedM(h,m);
	}
	
	
	public HBox getHBox() {
		return this.hbox;
	}
	private void setChangedH() {
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
	private void setChangedM() {
		minutespinner.setOnMouseClicked(e -> {
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
	private void setChangedH(int h, int m) {
		hourspinner.setOnMouseClicked(e -> {
			System.out.println(hourspinner.getValue() + " " + h);
			if (hourspinner.getValue() > initialh) {
				SpinnerValueFactory<Integer> valueFactorMinute;
				if (initialm <= minutespinner.getValue()) {
					valueFactorMinute = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,55,minutespinner.getValue(),5);
				}else {
					valueFactorMinute = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,55,initialm,5);
				}
				minutespinner.setValueFactory(valueFactorMinute);
			}else {
				SpinnerValueFactory<Integer> valueFactorMinute = new SpinnerValueFactory.IntegerSpinnerValueFactory(initialm,55,initialm,5);
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
	private void setChangedM(int h, int m) {
		minutespinner.setOnMouseClicked(e -> {
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
	public Spinner<Integer> getMinSpin() {
		return this.minutespinner;
	}
	public Spinner<Integer> getHourSpin() {
		return this.hourspinner;
	}
	public int getHour() {
		return this.hourspinner.getValue();
	}
	public int getMin() {
		return this.minutespinner.getValue();
	}
}
