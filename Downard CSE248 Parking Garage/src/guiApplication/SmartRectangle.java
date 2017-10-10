package guiApplication;

import java.io.Serializable;

import javafx.scene.shape.Rectangle;

public class SmartRectangle extends Rectangle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1089646282919353722L;

	@Override
	public boolean isResizable() {
		return true;
	}
	
	@Override
	public double minWidth(double height) {
		return 0.0;
	}
	
	@Override
	public double minHeight(double width) {
		return 0.0;
	}
}
