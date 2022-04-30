package ui;

import java.io.IOException;

import javafx.stage.Stage;
import model.Database;

public class DatabaseGUI {
	
	private Stage mainStage;
	private Database database;
	
	
	public DatabaseGUI() {
		
	}
	
	//Menu's database
	public void mainMenu() throws IOException {
		MainMenuGUI m =  new MainMenuGUI(mainStage);
		m.start();
	}
	
	
	public void setMainStage(Stage s) {
		mainStage = s;
	}

}
