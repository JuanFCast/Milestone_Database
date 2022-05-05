package ui;

import java.io.IOException;

import javafx.stage.Stage;
import model.Database;

public class DatabaseGUI {
	
	private Stage mainStage;
	private Database database;
	
	
	public DatabaseGUI() throws IOException {
		database = new Database();
	}
	
	//Menu's database
	public void mainMenu() throws IOException {
		MainMenuGUI m =  new MainMenuGUI(mainStage, database);
		m.start(database.getMAXPOPULATION());
	}
	
	
	public void setMainStage(Stage s) {
		mainStage = s;
	}
	
	

}
