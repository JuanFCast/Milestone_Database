package ui;

import java.io.IOException;

import javafx.stage.Stage;
import model.Database;

public class DatabaseGUI {
	
	private Stage mainStage;
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
		GeneralPaneGUI p = new GeneralPaneGUI(mainStage);
		p.startMenu();
	}
	
//	public void searchMenu() throws IOException {
//		SearchMenuGUI sm = new SearchMenuGUI(mainPane);
//		sm.startMenu();
//	}
//	
//	public void updateRemoveMenu() throws IOException {
//		UpdateDeleteMenuGUI ud = new UpdateDeleteMenuGUI(mainPane);
//		ud.startMenu();
//	}
	
	public void setMainStage(Stage s) {
		mainStage = s;
	}
}
