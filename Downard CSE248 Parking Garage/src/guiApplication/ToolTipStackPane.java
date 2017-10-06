package guiApplication;

import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class ToolTipStackPane extends StackPane {

	private Tooltip myTooltip;
	private SmartRectangle car;
	
	private int spotNum;
	private int floorNum;
	
	
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
	
}
