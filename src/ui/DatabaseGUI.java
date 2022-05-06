package ui;

import java.io.IOException;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Database;

public class DatabaseGUI {
	
	private Stage mainStage;
	private Pane mainPane;
	private Database database;
	
	//Constructor
	public DatabaseGUI() throws IOException {
		database = new Database();
	}
	
	//Menu's database
	public void mainMenu() throws IOException {
		MainMenuGUI m =  new MainMenuGUI(mainStage, this, database);
		m.startMenu(database.getMAXPOPULATION());
	}
	
	public void generalMenu() throws IOException {
		GeneralPane p = new GeneralPane(mainStage, mainPane);
		p.start();
	}
	
	public void searchMenu() throws IOException {
		SearchMenu m =  new SearchMenu(mainPane);
		m.start();
	}
	
	public void setMainStage(Stage s) {
		mainStage = s;
	}
}
