package guiApplication;

import javafx.scene.shape.Rectangle;

public class SmartRectangle extends Rectangle{

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
