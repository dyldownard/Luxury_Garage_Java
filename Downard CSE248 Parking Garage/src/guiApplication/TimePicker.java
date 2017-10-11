package guiApplication;

import java.io.Serializable;
import java.time.LocalDate;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;
/**
 * double-spinner pane that allows you to chose a time, 
 * and can refuse to go before a certain time
 */
public class TimePicker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6170856550357698165L;
	private HBox hbox;
	private Label label; 
	private Spinner<Integer> hourspinner;
	private Spinner<Integer> minutespinner;
	private Label conversion;
	private PickupCarPane parent;
	
	private LocalDate curDate;
	private LocalDate futDate;
	
	//--------------------------------------------------------	
	/**
	 * constructor for pane
	 */
	public TimePicker() {
		hbox = new HBox();
		label = new Label("HH:MM");
		hourspinner = new Spinner<Integer>();
		minutespinner = new Spinner<Integer>();
		conversion = new Label();
		
		hbox.setAlignment(Pos.CENTER);
		hourspinner.setPrefSize(60, 20);
		minutespinner.setPrefSize(60, 20);
		
		
		SpinnerValueFactory<Integer> valueFactorHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,23);
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
		setChangedH(-1,-1);
		setChangedM(-1,-1);
	}
	
	//--------------------------------------------------------	
	/**
	 * constructor for pane with time restrictions
	 * @param h hour restriction
	 * @param m minute restriction
	 * @param parent parent pane
	 */
	public TimePicker(int h, int m, PickupCarPane parent) {
		this.parent = parent;
		hbox = new HBox();
		label = new Label("HH:MM");
		hourspinner = new Spinner<Integer>();
		minutespinner = new Spinner<Integer>();
		conversion = new Label();
		
		hbox.setAlignment(Pos.CENTER);
		hourspinner.setPrefSize(60, 20);
		minutespinner.setPrefSize(60, 20);
		
		
		SpinnerValueFactory<Integer> valueFactorHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(h,23);
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
	
	//--------------------------------------------------------	
	/**
	 * checks if hour is changed to update the timestamp
	 * @param h hour
	 * @param m minute
	 */
	private void setChangedH(int h, int m) {
		hourspinner.setOnMouseClicked(e -> {
			if (h == -1) {
				if (hourspinner.getValue() > 12) {
					if (minutespinner.getValue() == 0) {
						conversion.setText((hourspinner.getValue()-12) + ":00 PM");
					}else if (minutespinner.getValue() == 5){
						conversion.setText((hourspinner.getValue()-12) + ":05 PM");
					}else {
						conversion.setText((hourspinner.getValue()-12) + ":" + minutespinner.getValue() + " PM");
					}
				}else {
					if (minutespinner.getValue() == 0) {
						conversion.setText(hourspinner.getValue() + ":00 AM");
					}else if(minutespinner.getValue() == 5){
						conversion.setText(hourspinner.getValue() + ":05 AM");
					}else {
						conversion.setText(hourspinner.getValue() + ":" + minutespinner.getValue() + " AM");
					}
				}
			}else {
				parent.updateDifference();
				if (futDate != null) {
					if ((futDate.getDayOfYear() > curDate.getDayOfYear()) && (futDate.getYear() >= curDate.getYear())) {
						SpinnerValueFactory<Integer> valueFactorMinute =  new SpinnerValueFactory.IntegerSpinnerValueFactory(0,55,minutespinner.getValue(),5);
						SpinnerValueFactory<Integer> valueFactorHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,23,hourspinner.getValue(), 1);
						minutespinner.setValueFactory(valueFactorMinute);
						hourspinner.setValueFactory(valueFactorHour);
					}else {
						if (hourspinner.getValue() <= h) {
							SpinnerValueFactory<Integer> valueFactorMinute =  new SpinnerValueFactory.IntegerSpinnerValueFactory(m,55,minutespinner.getValue(),5);
							SpinnerValueFactory<Integer> valueFactorHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(h,23,hourspinner.getValue(), 1);
							minutespinner.setValueFactory(valueFactorMinute);
							hourspinner.setValueFactory(valueFactorHour);
						}else {
							SpinnerValueFactory<Integer> valueFactorMinute =  new SpinnerValueFactory.IntegerSpinnerValueFactory(0,55,minutespinner.getValue(),5);
							SpinnerValueFactory<Integer> valueFactorHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(h,23,hourspinner.getValue(), 1);
							minutespinner.setValueFactory(valueFactorMinute);
							hourspinner.setValueFactory(valueFactorHour);
						}
					}
				}else {
					if (hourspinner.getValue() <= h) {
						SpinnerValueFactory<Integer> valueFactorMinute =  new SpinnerValueFactory.IntegerSpinnerValueFactory(m,55,minutespinner.getValue(),5);
						SpinnerValueFactory<Integer> valueFactorHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(h,23,hourspinner.getValue(), 1);
						minutespinner.setValueFactory(valueFactorMinute);
						hourspinner.setValueFactory(valueFactorHour);
					}else {
						SpinnerValueFactory<Integer> valueFactorMinute =  new SpinnerValueFactory.IntegerSpinnerValueFactory(0,55,minutespinner.getValue(),5);
						SpinnerValueFactory<Integer> valueFactorHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(h,23,hourspinner.getValue(), 1);
						minutespinner.setValueFactory(valueFactorMinute);
						hourspinner.setValueFactory(valueFactorHour);
					}
				}
				if (hourspinner.getValue() > 12) {
					if (minutespinner.getValue() == 0) {
						conversion.setText((hourspinner.getValue()-12) + ":00 PM");
					}else if (minutespinner.getValue() == 5) {
						conversion.setText((hourspinner.getValue()-12) + ":05 PM");
					}else {
						conversion.setText((hourspinner.getValue()-12) + ":" + minutespinner.getValue() + " PM");
					}
				}else {
					if (minutespinner.getValue() == 0) {
						conversion.setText(hourspinner.getValue() + ":00 AM");
					}else if(minutespinner.getValue() == 5) {
						conversion.setText(hourspinner.getValue() + ":05 AM");
					}else {
						conversion.setText(hourspinner.getValue() + ":" + minutespinner.getValue() + " AM");
					}
				}
			}
			if (parent != null) {
				parent.updateDifference();
			}
		});
	}
	/**
	 * checks if hour is changed to update the timestamp
	 * @param h hour
	 * @param m minute
	 */
	private void setChangedM(int h, int m) {
		minutespinner.setOnMouseClicked(e -> {
			if (futDate != null) {
				if ((futDate.getDayOfYear() > curDate.getDayOfYear()) && (futDate.getYear() >= curDate.getYear())) {
					SpinnerValueFactory<Integer> valueFactorMinute =  new SpinnerValueFactory.IntegerSpinnerValueFactory(0,55,minutespinner.getValue(),5);
					SpinnerValueFactory<Integer> valueFactorHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,23,hourspinner.getValue(), 1);
					minutespinner.setValueFactory(valueFactorMinute);
					hourspinner.setValueFactory(valueFactorHour);
				}else {
					if (hourspinner.getValue() <= h) {
						SpinnerValueFactory<Integer> valueFactorMinute =  new SpinnerValueFactory.IntegerSpinnerValueFactory(m,55,minutespinner.getValue(),5);
						SpinnerValueFactory<Integer> valueFactorHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(h,23,hourspinner.getValue(), 1);
						minutespinner.setValueFactory(valueFactorMinute);
						hourspinner.setValueFactory(valueFactorHour);
					}else {
						SpinnerValueFactory<Integer> valueFactorMinute =  new SpinnerValueFactory.IntegerSpinnerValueFactory(0,55,minutespinner.getValue(),5);
						SpinnerValueFactory<Integer> valueFactorHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(h,23,hourspinner.getValue(), 1);
						minutespinner.setValueFactory(valueFactorMinute);
						hourspinner.setValueFactory(valueFactorHour);
					}
				}
			}else {
				if (hourspinner.getValue() <= h) {
					SpinnerValueFactory<Integer> valueFactorMinute =  new SpinnerValueFactory.IntegerSpinnerValueFactory(m,55,minutespinner.getValue(),5);
					SpinnerValueFactory<Integer> valueFactorHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(h,23,hourspinner.getValue(), 1);
					minutespinner.setValueFactory(valueFactorMinute);
					hourspinner.setValueFactory(valueFactorHour);
				}else {
					SpinnerValueFactory<Integer> valueFactorMinute =  new SpinnerValueFactory.IntegerSpinnerValueFactory(0,55,minutespinner.getValue(),5);
					SpinnerValueFactory<Integer> valueFactorHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(h,23,hourspinner.getValue(), 1);
					minutespinner.setValueFactory(valueFactorMinute);
					hourspinner.setValueFactory(valueFactorHour);
				}
			}
			if (h == -1) {
				if (hourspinner.getValue() > 12) {
					if (minutespinner.getValue() == 0) {
						conversion.setText((hourspinner.getValue()-12) + ":00 PM");
					}else if (minutespinner.getValue() == 5){
						conversion.setText((hourspinner.getValue()-12) + ":05 PM");
					}else {
						conversion.setText((hourspinner.getValue()-12) + ":" + minutespinner.getValue() + " PM");
					}
				}else {
					if (minutespinner.getValue() == 0) {
						conversion.setText(hourspinner.getValue() + ":00 AM");
					}else if(minutespinner.getValue() == 5){
						conversion.setText(hourspinner.getValue() + ":05 AM");
					}else {
						conversion.setText(hourspinner.getValue() + ":" + minutespinner.getValue() + " AM");
					}
				}
			}else {
				if (hourspinner.getValue() > 12) {
					if (minutespinner.getValue() == 0) {
						conversion.setText((hourspinner.getValue()-12) + ":00 PM");
					}else if (minutespinner.getValue() == 5) {
						conversion.setText((hourspinner.getValue()-12) + ":05 PM");
					}else {
						conversion.setText((hourspinner.getValue()-12) + ":" + minutespinner.getValue() + " PM");
					}
				}else {
					if (minutespinner.getValue() == 0) {
						conversion.setText(hourspinner.getValue() + ":00 AM");
					}else if(minutespinner.getValue() == 5) {
						conversion.setText(hourspinner.getValue() + ":05 AM");
					}else {
						conversion.setText(hourspinner.getValue() + ":" + minutespinner.getValue() + " AM");
					}
				}
			}
			if (parent != null) {
				parent.updateDifference();
			}
		});
	}
	
	//--------------------------------------------------------	

	/**
	 * root pane
	 * @return pane 
	 */
	public HBox getHBox() {
		return this.hbox;
	}
	
	/**
	 * sets base localtime to judge if day is after
	 * @param time
	 */
	public void setCurDate(LocalDate time) {
		this.curDate = time;
	}
	
	/**
	 * sets future localtime to judge if day is after
	 * @param time
	 */
	public void setFutureDate(LocalDate time) {
		this.futDate = time;
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
