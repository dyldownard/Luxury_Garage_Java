package guiApplication;

import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;

public class ToolTipStackPane extends StackPane {

	private Tooltip myTooltip;
	
	public void setTooltip(String text) {
		myTooltip = new Tooltip(text);
		Tooltip.install(this, this.myTooltip);
	}
	
	public void clearTooltip() {
		Tooltip.uninstall(this, this.myTooltip);
		myTooltip = null;
	}
	
	public Tooltip getTooltip() {
		return this.myTooltip;
	}
	
}
