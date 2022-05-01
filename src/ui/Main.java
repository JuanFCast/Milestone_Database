package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Database;
import model.Gender;
import model.Person;

public class Main extends Application{
	
	private DatabaseGUI appController;
	private Database databaseController = new Database();

    public static void main(String []team) {
        launch(team);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		appController = new DatabaseGUI();
		appController.setMainStage(primaryStage);
		appController.mainMenu();
		System.out.println(new Person("susana", "morales", Gender.female, "4/4/4", "120", "Peruana").id());
		databaseController.generateEstatura();
		
		
	}

}