package guiApplication;


import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import basePackage.*;
import carsPackage.Car;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Stage primaryStage;
	Stage tempStage;
	BorderPane bpane;
	MenuPane mpane;
	TabPanes tpane;
	ParkCarPane parkPane;
	PickupCarPane pickPane;
	SearchPane searchPane;
	Stage fileStage;
	SaveQuestionPane savePane;
	
	ParkingGarage CarPark;
	
	Main main;
	
	Boolean inAction;
	
	int amountTabs;
	
	int i;		// for setaction array
	int j;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		inAction = false;
		this.main = this;
		this.primaryStage = primaryStage;
		
		bpane = new BorderPane();
		
		mpane = new MenuPane(primaryStage, inAction);
		bpane.setTop(mpane.getMenu());
		
		openRecent();
	
		Platform.setImplicitExit(false);
		updateTabs();
		setEventMethods();
		
		Scene scene = new Scene(bpane, 700, 700);
		primaryStage.setTitle("Parking Lot CSE248");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
	public void updateTabs() {		
		tpane.updateGrid();
	}
	
	public void setEventMethods() {
		setCarClicked();
		setHovered();
		setUnhovered();
		setExited();
		parkValet();
		setOnTickSearch();
		setOnCarSearch();
		onSaveRequest();
		setNew();
		setAbout();
	}
	
	private void setAbout() {
		mpane.getAbout().setOnAction(e -> {
			inAction = true;
    		AboutTextPane about = new AboutTextPane(); 
    		tempStage = new Stage();
    		tempStage.setScene(new Scene(about.getVBox(), 400, 500));
    		tempStage.showAndWait();
    		inAction = false;
		});
	}
	
	private void setExited() {
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent closeEvent) {
            	if (inAction == true) {
            		closeEvent.consume();
            	}else {
            		inAction = true;
            		savePane = new SaveQuestionPane(main); 
            		tempStage = new Stage();
            		tempStage.setScene(new Scene(savePane.getvbox(), 300, 200));
            		tempStage.showAndWait();
            		Platform.exit();
            	}
            }
        });
	}
	
	private void setNew() {
		mpane.getNew().setOnAction(e -> {
			inAction = true;
    		savePane = new SaveQuestionPane(main); 
    		tempStage = new Stage();
    		tempStage.setScene(new Scene(savePane.getvbox(), 300, 200));
    		tempStage.showAndWait();
    		inAction = false;
    		ParkingGarage newPark = new ParkingGarage();
    		BuildNew(newPark);
		});
	}
	public void BuildNew() {
		CarPark.CheckTicks();
		tpane = new TabPanes(CarPark);
		bpane.setCenter(tpane.getTabPane());
	}
	
	public void BuildNew(ParkingGarage park) {
		this.CarPark = park;
		tpane = new TabPanes(CarPark);
		bpane.setCenter(tpane.getTabPane());
	}
	
	
	public void openRecent() {
		try {
			
			String dir = "Saves/";
		    File list = new File(dir);
		    File[] files = list.listFiles(new FileFilter() {          
		        public boolean accept(File file) {
		            return file.isFile();
		        }
		    });
		    long lastMod = Long.MIN_VALUE;
		    File mostrecent = null;
		    for (File file : files) {
		        if (file.lastModified() > lastMod) {
		            mostrecent = file;
		            lastMod = file.lastModified();
		        }
		    }
		    
		    if (mostrecent == null) {
		    	BuildNew(new ParkingGarage());
		    	updateTabs();
		    }else { 
			    FileInputStream filestream = new FileInputStream(mostrecent);
			    ObjectInputStream objectstream = new ObjectInputStream(filestream);
				
			    ParkingGarage newPark = (ParkingGarage) objectstream.readObject();
			    
				objectstream.close();
				filestream.close();
				this.CarPark = null;
				CarPark = newPark;
				BuildNew();
				updateTabs();
		    }
		}	catch (FileNotFoundException d) {
			System.out.println("File not found");
		} catch (ClassNotFoundException d) {

			d.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public void SaveWithClose() {
		try {
			FileChooser filesave = new FileChooser();
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("LOT Files (*.lot)", "*.lot");
			File defaultDirectory = new File("Saves");
			filesave.setInitialDirectory(defaultDirectory);
            filesave.getExtensionFilters().add(extFilter);
            CarPark.CheckTicks();
            File file = filesave.showSaveDialog(fileStage);
            if (file != null) {
				FileOutputStream f = new FileOutputStream(file);
				ObjectOutputStream o = new ObjectOutputStream(f);
	
				// Write objects to file
				o.writeObject(CarPark);
				
				o.close();
				f.close();
            }
            inAction = false;
            tempStage.close();
		}catch (FileNotFoundException d) {
			d.printStackTrace();
		}catch (IOException d) {
			d.printStackTrace();
		}
	}
	
	
	public void Save() {
		try {
			FileChooser filesave = new FileChooser();
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("LOT Files (*.lot)", "*.lot");
			File defaultDirectory = new File("Saves");
			filesave.setInitialDirectory(defaultDirectory);
            filesave.getExtensionFilters().add(extFilter);
            CarPark.CheckTicks();
            File file = filesave.showSaveDialog(fileStage);
            if (file != null) {
				FileOutputStream f = new FileOutputStream(file);
				ObjectOutputStream o = new ObjectOutputStream(f);
	
				// Write objects to file
				o.writeObject(CarPark);
				
				o.close();
				f.close();
            }
            inAction = false;
		}catch (FileNotFoundException d) {
			d.printStackTrace();
		}catch (IOException d) {
			d.printStackTrace();
		}
	}
	public void onSaveRequest() {
		mpane.getSave().setOnAction(e -> {
			Save();
		});
	}
	
	private void setOnTickSearch() {
		mpane.getTicketSearch().setOnAction(e -> {
			if (inAction == false) {
				searchPane = new SearchPane("tick", this);
				inAction = true;
				Scene tempScene = new Scene(searchPane.getVBox(), 400, 300);
				tempStage = new Stage();
				tempStage.setTitle("Search");
				tempStage.setScene(tempScene);
				tempStage.showAndWait();
				inAction = false;
			}
		});
	}
	
	private void setOnCarSearch() {
		mpane.getPlateSearch().setOnAction(e -> {
			if (inAction == false) {
				searchPane = new SearchPane("car", this);
				inAction = true;
				Scene tempScene = new Scene(searchPane.getVBox(), 400, 300);
				tempStage = new Stage();
				tempStage.setTitle("Search");
				tempStage.setScene(tempScene);
				tempStage.showAndWait();
				inAction = false;
			}
		});
	}
	
	public void SearchGo() throws InterruptedException {
		if(searchPane.isFound(CarPark) == true) {
			tempStage.close();
			Thread.sleep(1000);
			PickupCar(searchPane.getSearchResult(CarPark));
		}else {
			searchPane.getResult().setText("Could not find from entry.");
		}
	}
	
	private void setCarClicked() {
		for(int i = 0; i < tpane.getFloors().length; i++) {
			for(int j = 0; j < tpane.getFloors()[i].getStackPanes().length; j++) {
				final ToolTipStackPane actionStack = tpane.getFloors()[i].getStackPanes()[j];
				actionStack.setOnMouseClicked(e -> {
					if (actionStack.hasCar() == false && inAction == false) {
						parkPane = new ParkCarPane(actionStack.getSpotNum(), tpane.getFloors()[actionStack.getFloorNum()], actionStack);
						parkPane.setMain(this);
						Scene tempScene = new Scene(parkPane.getGridPane(), 500, 500);
						tempStage = new Stage();
						inAction = true;
						tempStage.setAlwaysOnTop(true);
						tempStage.setTitle("Park Car");
						tempStage.setScene(tempScene);
						parkPane.getDatePicker().requestFocus();
						tempStage.showAndWait();
						inAction = false;
						updateTabs();
					}else if(actionStack.hasCar() == true && inAction == false) {
						pickPane = new PickupCarPane(actionStack.getRealCar(), actionStack, CarPark, this);
						Scene tempScene = new Scene(pickPane.getGridPane(), 500, 500);
						tempStage = new Stage();
						inAction = true;
						tempStage.setAlwaysOnTop(true);
						tempStage.setTitle("Pickup Car");
						tempStage.setScene(tempScene);
						tempStage.showAndWait();
						inAction = false;
						updateTabs();
					}
				});
			}
		}
	}

	private void parkValet() {
		mpane.getValet().setOnAction(e -> {
			if (inAction == false && CarPark.isFull() == false) {
				parkPane = new ParkCarPane(-1, tpane.getFloors()[0], null);
				parkPane.setMain(this);
				Scene tempScene = new Scene(parkPane.getGridPane(), 500, 500);
				tempStage = new Stage();
				inAction = true;
				tempStage.setAlwaysOnTop(true);
				tempStage.setTitle("Park Car Valet");
				tempStage.setScene(tempScene);
				parkPane.getDatePicker().requestFocus();
				tempStage.showAndWait();
				inAction = false;
				updateTabs();
			}else if (inAction == false && CarPark.isFull() == true) {
				tempStage = new Stage();
				inAction = true;
				tempStage.setAlwaysOnTop(true);
				Label label = new Label("Parking lot is full.");
				label.setAlignment(Pos.CENTER);
				label.setFont(Font.font("Calibri",20));
				tempStage.setScene(new Scene(label, 300, 100));
				tempStage.showAndWait();
				inAction = false;
			}
		});
	}
	
	private void PickupCar(Car myCar) {
		tempStage = null;
		pickPane = new PickupCarPane(myCar, myCar.getMyPane(), CarPark, this);
		//Scene tempScene = new Scene(pickPane.getVBox(), 400, 400);
		tempStage = new Stage();
		
		inAction = true;
		tempStage.setAlwaysOnTop(true);
		tempStage.setTitle("Pickup Car - If empty resize window");
		tempStage.setScene(new Scene(pickPane.getGridPane(),400,400));
		tempStage.showAndWait();
		inAction = false;
		updateTabs();
	}
	private void setHovered() {
		for(int i = 0; i < tpane.getFloors().length; i++) {
			for(int j = 0; j < tpane.getFloors()[i].getStackPanes().length; j++) {
				final ToolTipStackPane actionStack = tpane.getFloors()[i].getStackPanes()[j];
				actionStack.setOnMouseEntered(e -> {
					actionStack.getLabel().setTextFill(Color.RED);
				});
			}
		}
	}
	private void setUnhovered() {
		for(int i = 0; i < tpane.getFloors().length; i++) {
			for(int j = 0; j < tpane.getFloors()[i].getStackPanes().length; j++) {
				final ToolTipStackPane actionStack = tpane.getFloors()[i].getStackPanes()[j];
				actionStack.setOnMouseExited(e -> {
					if (actionStack.hasCar() == true) {
						actionStack.getLabel().setTextFill(Color.WHITE);
					}else {
						actionStack.getLabel().setTextFill(Color.BLACK);
					}
				});
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
