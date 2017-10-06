package guiApplication;

import basePackage.*;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class NormalFloorPane implements GUIFloor {	

	private GridPane gpane;
	private int columns;
	private int rows;
	
	private int floorNumber;
	
	private StackPane[] parkingSpots;
	private ParkingGarage CarPark;
	
	
	public NormalFloorPane(ParkingGarage CarPark, int floor) {
		gpane = new GridPane();
		gpane.setAlignment(Pos.TOP_CENTER);
		this.CarPark = CarPark;
		this.floorNumber = floor;
		int nElms = 0;
		
		int spaces = 167;
		
		int calcspaces;
		
		parkingSpots = new StackPane[spaces];
		if (spaces >= 100) {
			calcspaces = ((spaces + 15)/30)*30;
			rows = 30;
			if (calcspaces < spaces) { 
				calcspaces += 30;
			}
		}else {
			calcspaces = ((spaces + 5)/10)*10;
			rows = 10;
			if (calcspaces < spaces) { 
				calcspaces += 10;
			}
		}
		
		
		
		System.out.println(calcspaces);
		
		columns = calcspaces/rows;
		int extraColumns = 1;
		extraColumns += (columns-1)/2;
		columns += extraColumns;
		
		
		
		for (int i = 0; i < columns; i++) {
			if ((i - 1)%3 != 0) {
				for (int z = 0; z < rows; z++) {
					if (nElms!=spaces) {
						
						StackPane pane = new StackPane();
						if(i%3 == 0) {
							pane.setStyle("-fx-border-style:  solid none solid solid");
						}else {
							pane.setStyle("-fx-border-style: solid solid solid none");
						}
						gpane.add(pane, i, z);
						parkingSpots[nElms++] = pane;
						GridPane.setHalignment(pane, HPos.CENTER);
					}
				}
			}
			
		}
		SmartRectangle rect = new SmartRectangle();
		rect.setStroke(Color.AQUA);
		rect.widthProperty().bind(parkingSpots[51].widthProperty().subtract(3));
		rect.heightProperty().bind(parkingSpots[51].heightProperty().subtract(3));
		parkingSpots[51].getChildren().add(rect);
		parkingSpots[51].setAlignment(Pos.CENTER);
		
		ColumnConstraints column = new ColumnConstraints();
		RowConstraints row = new RowConstraints();
	    column.setPercentWidth(100/columns);
	    row.setPercentHeight(100/rows);
	    for (int i = 0; i < columns; i++) {
	        gpane.getColumnConstraints().add(column);
	    }
	    for (int i = 0; i < rows; i++) {
	    	 gpane.getRowConstraints().add(row);
	    }
	    
		//gpane.setGridLinesVisible(true);
	    
		gpane.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE); // Default width and height
	    gpane.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

	}
	
	@Override
	public void updateGrid() {
		int amountCars = CarPark.
	}
	
	public GridPane getGridPane() {
		return this.gpane;
		
	}
}
