package guiApplication;

import basePackage.*;
import carsPackage.Car;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


public class NormalFloorPane implements GUIFloor {	

	private GridPane gpane;
	private int columns;
	private int rows;
	
	private int floorNumber;
	
	private ToolTipStackPane[] parkingSpots;
	private ParkingGarage CarPark;
	
	
	public NormalFloorPane(ParkingGarage CarPark, int floor) {
		gpane = new GridPane();
		gpane.setAlignment(Pos.TOP_CENTER);
		this.CarPark = CarPark;
		this.floorNumber = floor;
		int nElms = 0;
		
		int spaces = CarPark.getFloorsArray().getAr()[floor].getAmountTotalSpaces();
		
		int calcspaces;
		
		parkingSpots = new ToolTipStackPane[spaces];
		if (spaces >= 100) {
			calcspaces = ((spaces + 12)/25)*25;
			rows = 25;
			if (calcspaces < spaces) { 
				calcspaces += 25;
			}
		}else {
			calcspaces = ((spaces + 5)/10)*10;
			rows = 10;
			if (calcspaces < spaces) { 
				calcspaces += 10;
			}
		}
		
		
		columns = calcspaces/rows;
		int extraColumns = 1;
		extraColumns += (columns-1)/2;
		columns += extraColumns;
		
		
		
		for (int i = 0; i < columns; i++) {
			if ((i - 1)%3 != 0) {
				for (int z = 0; z < rows; z++) {
					if (nElms!=spaces) {
						
						ToolTipStackPane pane = new ToolTipStackPane();
						if(i%3 == 0) {
							pane.setStyle("-fx-border-style:  solid none solid solid");
						}else {
							pane.setStyle("-fx-border-style: solid solid solid none");
						}
						gpane.add(pane, i, z);
						parkingSpots[nElms++] = pane;
						GridPane.setHalignment(pane, HPos.CENTER);
						pane.setAlignment(Pos.CENTER);
					}
				}
			}
			
		}

		
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
		Floor floor = CarPark.getFloorsArray().getAr()[floorNumber];
		Car[] Cars = floor.getCarsAr().getAr();
		System.out.println(floor.getCarsAr());
		for (int i = 0; i < floor.getAmountTotalSpaces(); i++) {
			if ((Cars[i] == null) && (parkingSpots[i].getChildren().isEmpty() == false)) {// if there is no car but gui shows car
				parkingSpots[i].getChildren().clear();
				parkingSpots[i].clearTooltip();
			}else if ((Cars[i] != null) && (parkingSpots[i].getChildren().isEmpty() == true)) {// if there is car but gui says no car
				SmartRectangle rect = new SmartRectangle();//put car in gui
				rect.setStroke(Cars[i].getColor());
				rect.setFill(Cars[i].getColor());
				rect.widthProperty().bind(parkingSpots[i].widthProperty().subtract(10));
				rect.heightProperty().bind(parkingSpots[51].heightProperty().subtract(8));
				parkingSpots[i].getChildren().add(rect);
				parkingSpots[i].setTooltip(Cars[i].getModel());
			}
		}
		
		
	}
	
	public GridPane getGridPane() {
		return this.gpane;
		
	}
}
