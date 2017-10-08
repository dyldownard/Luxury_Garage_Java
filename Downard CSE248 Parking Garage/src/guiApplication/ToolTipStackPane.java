package guiApplication;

import carsPackage.Car;

import java.util.Arrays;

import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;

public class ToolTipStackPane extends StackPane {

	private Tooltip myTooltip;
	private SmartRectangle car;
	private Label myLabel;
	
	private int spotNum;
	private int specialSpotNum;
	private int floorNum;
	
	private String[] allowedTypes;
	private String actualType;
	private String spotName;
	
	public ToolTipStackPane() {
		super();
	}
	public ToolTipStackPane(int spotNum, int floorNum) {
		super();
		this.spotNum = spotNum;
		this.floorNum = floorNum;
	}
	
	public void setTooltip(String text) {
		myTooltip = new Tooltip(text);
		Tooltip.install(this, this.myTooltip);
	}
	
	public void setCar(SmartRectangle rect) {
		this.car = rect;
	}
	
	public boolean hasCar() {
		return this.car!=null;
	}
	
	public boolean isAllowed(Car myCar) {
		return Arrays.asList(allowedTypes).contains(myCar.getSpaceType());
	}
	
	public void clearTooltip() {
		Tooltip.uninstall(this, this.myTooltip);
		myTooltip = null;
	}
	
	public Tooltip getTooltip() {
		return this.myTooltip;
	}
	public int getSpotNum() {
		return spotNum;
	}
	public void setSpotNum(int spotNum) {
		this.spotNum = spotNum;
	}
	public int getFloorNum() {
		return floorNum;
	}
	public void setFloorNum(int floorNum) {
		this.floorNum = floorNum;
	}
	public String[] getAllowedTypes() {
		return allowedTypes;
	}
	public void setAllowedTypes(String[] allowedTypes) {
		this.allowedTypes = allowedTypes;
	}
	public Label getLabel() {
		return this.myLabel;
	}
	public void setLabel(Label myLabel) {
		this.myLabel = myLabel;
	}
	public void setActualType(String type) {
		this.actualType = type;
	}
	public String getActualType() {
		return this.actualType;
	}
	public void setSpotName(String name) {
		this.spotName = name;
	}
	public String getSpotName() {
		return this.spotName;
	}
	public void setSpecialSpot(int spot) {
		this.specialSpotNum = spot;
	}
	public int getSpecialSpot() {
		return this.specialSpotNum;
	}
}
