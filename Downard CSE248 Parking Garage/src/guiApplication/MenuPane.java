package guiApplication;

import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;

public class MenuPane {

	private MenuBar bar;
	
	private Menu file;
	private Menu edit;
	private Menu help;
	
	private CustomMenuItem open;
	private MenuItem saveAs;
	
	private MenuItem generate;
	private CustomMenuItem clear;
	
	private MenuItem about;

	
	public MenuPane() {
		bar = new MenuBar();
		file = new Menu("File");
		edit = new Menu("Edit");
		help = new Menu("Help");
		open = new CustomMenuItem(new Label("Open"));
		Tooltip openText = new Tooltip("Adds a selected file to the MasterList");
		Tooltip.install(open.getContent(), openText);
		saveAs = new MenuItem("Save As");
		generate = new MenuItem("Generate");
		clear = new CustomMenuItem(new Label("Clear"));
		about = new MenuItem("About");
		Tooltip clearWarning = new Tooltip("This clears the masterlist");
		Tooltip.install(clear.getContent(), clearWarning);
		
		
		file.getItems().addAll(open, saveAs);
		edit.getItems().addAll(generate, clear);
		help.getItems().addAll(about);
		
		bar.getMenus().addAll(file, edit, help);
	}
	
	public MenuBar getBar() {
		return bar;
	}
	
	public CustomMenuItem getOpen() {
		return open;
	}
	
	public Menu getFile() {
		return file;
	}
	
	public MenuItem getGenerate() {
		return generate;
	}
	
	public CustomMenuItem getClear() {
		return clear;
	}
	
	public MenuItem getSave() {
		return saveAs;
	}
	
	public MenuItem getAbout() {
		return about;
	}
	
}
