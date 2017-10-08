package guiApplication;

import basePackage.Floor;
import basePackage.ParkingGarage;
import carsPackage.Car;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class GroundFloorPane implements GUIFloor{

	
	private GridPane gpane;
	private int columns;
	private int rows;
	
	private int floorNumber;
	
	private ToolTipStackPane[] parkingSpots;
	private ToolTipStackPane[] carSpots;
	private ToolTipStackPane[] busSpots;
	private ToolTipStackPane[] handiSpots;
	private ToolTipStackPane[] motoSpots;
	private ParkingGarage CarPark;
	
	private String[] allowedNormalTypes = {"Sedan","Pickup Truck", "Van", "Motorcylce","Handicapped"};
	private String[] allowedLargeTypes = {"Bus", "Work Truck"};
	private String[] allowedMotorTypes = {"Motorcycle"};
	private String[] allowedHandiTypes = {"Handicapped"};

	
	public GroundFloorPane(ParkingGarage CarPark, int floor) {
		gpane = new GridPane();
		gpane.setAlignment(Pos.TOP_CENTER);
		this.CarPark = CarPark;
		this.floorNumber = floor;
		
		
		int spaces = CarPark.getFloorsArray().getAr()[floor].getAmountTotalSpaces();
		int busSpaces = CarPark.getFloorsArray().getAr()[floor].getBusAmount();
		int handiSpaces = CarPark.getFloorsArray().getAr()[floor].getHandiAmount();
		int motoSpaces = CarPark.getFloorsArray().getAr()[floor].getMotoAmount();
		int calcspaces;
		
		parkingSpots = new ToolTipStackPane[spaces + busSpaces + handiSpaces + motoSpaces];
		carSpots = new ToolTipStackPane[spaces];
		busSpots = new ToolTipStackPane[busSpaces];
		handiSpots = new ToolTipStackPane[handiSpaces];
		motoSpots = new ToolTipStackPane[motoSpaces];
		
		
		calcspaces = ((spaces + 10)/20)*20;
		rows = 20;
		if (calcspaces < spaces) { 
			calcspaces += 20;
		}
		
		columns = calcspaces/rows;
		int extraColumns = 1;		// needs 1 for end
		extraColumns += (columns-1)/2;
		columns += extraColumns + 4;	// extra 4 for beginning
		
		int nElms = 0;
		int cElms = 0;
		int hElms = 0;
		int bElms = 0;
		int mElms = 0;
		
		for (int i = 0; i < columns; i++) {
			if (i < 4) {	// specials
				for(int z = 0; z < rows; z++) {
					
					if (i == 0 && z < 15) {
						ToolTipStackPane pane = new ToolTipStackPane();
						Label label = new Label();
						pane.setStyle("-fx-border-style: solid none solid solid");
						gpane.add(pane, i, z);
						pane.setAllowedTypes(allowedHandiTypes);
						parkingSpots[nElms++] = pane;
						handiSpots[hElms++] = pane;
						label.setText(hElms + "H");
						pane.setLabel(label);
						pane.setActualType("Handicapped");
						pane.getChildren().add(label);
						pane.setSpotNum(nElms);
						pane.setSpecialSpot(hElms);
						pane.setSpotName(hElms + "H");
						pane.setFloorNum(this.floorNumber);
						GridPane.setHalignment(pane, HPos.CENTER);
						pane.setAlignment(Pos.CENTER);
					}else if(i == 0 && z >=15) {
						ToolTipStackPane pane = new ToolTipStackPane();
						Label label = new Label();
						pane.setStyle("-fx-border-style: solid none solid solid");
						gpane.add(pane, i, z, 2, 1);	// ColSpan = 2 for Buses being twice as big
						pane.setAllowedTypes(allowedLargeTypes);
						parkingSpots[nElms++] = pane;
						busSpots[bElms++] = pane;
						label.setText(bElms + "B");
						pane.setLabel(label);
						pane.setActualType("Large");
						pane.getChildren().add(label);
						pane.setSpotNum(nElms);
						pane.setSpecialSpot(bElms);
						pane.setSpotName(bElms + "B");
						pane.setFloorNum(this.floorNumber);
						GridPane.setHalignment(pane, HPos.CENTER);
						pane.setAlignment(Pos.CENTER);
					}else if(i == 3 && z < 15) {
						ToolTipStackPane pane = new ToolTipStackPane();
						Label label = new Label();
						pane.setStyle("-fx-border-style: solid solid solid none");
						gpane.add(pane, i, z);
						pane.setAllowedTypes(allowedMotorTypes);
						parkingSpots[nElms++] = pane;
						motoSpots[mElms++] = pane;
						label.setText(hElms + "M");
						pane.setLabel(label);
						pane.setActualType("Motorcycle");
						pane.getChildren().add(label);
						pane.setSpotNum(nElms);
						pane.setSpecialSpot(mElms);
						pane.setSpotName(mElms + "M");
						pane.setFloorNum(this.floorNumber);
						GridPane.setHalignment(pane, HPos.CENTER);
						pane.setAlignment(Pos.CENTER);
					}
				}
			}else {	// normals
				if ((i-2)%3 != 0) {
					for (int z = 0; z < rows; z++) {
						if (nElms!=parkingSpots.length) {
							ToolTipStackPane pane = new ToolTipStackPane();
							Label label = new Label();
							if((i-4)%(3) == 0) {
								pane.setStyle("-fx-border-style:  solid none solid solid");
							}else {
								pane.setStyle("-fx-border-style: solid solid solid none");
							}
							gpane.add(pane, i, z);
							pane.setAllowedTypes(allowedNormalTypes);	// all spots in this lot are the same;
							parkingSpots[nElms++] = pane;
							carSpots[cElms++] = pane;
							label.setText(cElms + "C");
							pane.setLabel(label);
							pane.setActualType("Normal");
							pane.getChildren().add(label);
							pane.setSpotNum(nElms);
							pane.setSpecialSpot(cElms);
							pane.setSpotName(cElms + "C");
							pane.setFloorNum(this.floorNumber);
							GridPane.setHalignment(pane, HPos.CENTER);
							pane.setAlignment(Pos.CENTER);
						}
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
		System.out.println(floor.getCarsAr());					// REMOVE
		//update each seperately, normal cars first:
		Car[] NormalCars = floor.getCarsAr().getAr();
		for (int i = 0; i < floor.getAmountCars(); i++) {
			if ((NormalCars[i] == null) && (carSpots[i].hasCar() == true)) {// if there is no car but gui shows car
				carSpots[i].getChildren().clear();
				carSpots[i].clearTooltip();
				carSpots[i].setCar(null);
				Label label = new Label((i + 1) + "C");
				carSpots[i].setLabel(label);
				carSpots[i].getChildren().add(label);
			}else if ((NormalCars[i] != null) && (carSpots[i].hasCar() == false)) {// if there is car but gui says no car
				carSpots[i].getChildren().clear();
				SmartRectangle rect = new SmartRectangle();//put car in gui
				rect.setStroke(NormalCars[i].getColor());
				rect.setFill(NormalCars[i].getColor());
				rect.widthProperty().bind(carSpots[i].widthProperty().subtract(10));
				rect.heightProperty().bind(carSpots[i].heightProperty().subtract(8));
				Label label = new Label((i + 1) + "C");
				label.setStyle("-fx-background-color: black");
				label.setTextFill(Color.WHITE);
				carSpots[i].setLabel(label);
				carSpots[i].getChildren().addAll(rect, label);
				carSpots[i].setTooltip(NormalCars[i].getModel());
				carSpots[i].setCar(rect);
			}
		}
		Car[] Motorcycles = floor.getMotoAr().getAr();
		for (int i = 0; i < floor.getMotoAmount(); i++) {
			if ((Motorcycles[i] == null) && (motoSpots[i].hasCar() == true)) {// if there is no car but gui shows car
				motoSpots[i].getChildren().clear();
				motoSpots[i].clearTooltip();
				motoSpots[i].setCar(null);
				Label label = new Label((i + 1) + "C");
				motoSpots[i].setLabel(label);
				motoSpots[i].getChildren().add(label);
			}else if ((Motorcycles[i] != null) && (motoSpots[i].hasCar() == false)) {// if there is car but gui says no car
				motoSpots[i].getChildren().clear();
				SmartRectangle rect = new SmartRectangle();//put car in gui
				rect.setStroke(Motorcycles[i].getColor());
				rect.setFill(Motorcycles[i].getColor());
				rect.widthProperty().bind(motoSpots[i].widthProperty().subtract(10));
				rect.heightProperty().bind(motoSpots[i].heightProperty().subtract(8));
				Label label = new Label((i + 1) + "M");
				label.setStyle("-fx-background-color: black");
				label.setTextFill(Color.WHITE);
				motoSpots[i].setLabel(label);
				motoSpots[i].getChildren().addAll(rect, label);
				motoSpots[i].setTooltip(Motorcycles[i].getModel());
				motoSpots[i].setCar(rect);
			}
		}
		Car[] Handicaps = floor.getHandiAr().getAr();
		for (int i = 0; i < floor.getHandiAmount(); i++) {
			if ((Handicaps[i] == null) && (handiSpots[i].hasCar() == true)) {// if there is no car but gui shows car
				handiSpots[i].getChildren().clear();
				handiSpots[i].clearTooltip();
				handiSpots[i].setCar(null);
				Label label = new Label((i + 1) + "C");
				handiSpots[i].setLabel(label);
				handiSpots[i].getChildren().add(label);
			}else if ((Handicaps[i] != null) && (handiSpots[i].hasCar() == false)) {// if there is car but gui says no car
				handiSpots[i].getChildren().clear();
				SmartRectangle rect = new SmartRectangle();//put car in gui
				rect.setStroke(Handicaps[i].getColor());
				rect.setFill(Handicaps[i].getColor());
				rect.widthProperty().bind(handiSpots[i].widthProperty().subtract(10));
				rect.heightProperty().bind(handiSpots[i].heightProperty().subtract(8));
				Label label = new Label((i + 1) + "H");
				label.setStyle("-fx-background-color: black");
				label.setTextFill(Color.WHITE);
				handiSpots[i].setLabel(label);
				handiSpots[i].getChildren().addAll(rect, label);
				handiSpots[i].setTooltip(Handicaps[i].getModel());
				handiSpots[i].setCar(rect);
			}
		}
		Car[] Buses = floor.getBusAr().getAr();
		for (int i = 0; i < floor.getBusAmount(); i++) {
			if ((Buses[i] == null) && (busSpots[i].hasCar() == true)) {// if there is no car but gui shows car
				busSpots[i].getChildren().clear();
				busSpots[i].clearTooltip();
				busSpots[i].setCar(null);
				Label label = new Label((i + 1) + "C");
				busSpots[i].setLabel(label);
				busSpots[i].getChildren().add(label);
			}else if ((Buses[i] != null) && (busSpots[i].hasCar() == false)) {// if there is car but gui says no car
				busSpots[i].getChildren().clear();
				SmartRectangle rect = new SmartRectangle();//put car in gui
				rect.setStroke(Buses[i].getColor());
				rect.setFill(Buses[i].getColor());
				rect.widthProperty().bind(busSpots[i].widthProperty().subtract(10));
				rect.heightProperty().bind(busSpots[i].heightProperty().subtract(8));
				Label label = new Label((i + 1) + "B");
				label.setStyle("-fx-background-color: black");
				label.setTextFill(Color.WHITE);
				busSpots[i].setLabel(label);
				busSpots[i].getChildren().addAll(rect, label);
				busSpots[i].setTooltip(Buses[i].getModel());
				busSpots[i].setCar(rect);
			}
		}		
	}

	@Override
	public ToolTipStackPane[] getStackPanes() {
		return this.parkingSpots;
	}

	@Override
	public int getFloorNum() {
		return this.floorNumber;
	}

	@Override
	public ParkingGarage getGarage() {
		return this.CarPark;
	}

	public GridPane getGridPane() {
		return this.gpane;
	}

}
