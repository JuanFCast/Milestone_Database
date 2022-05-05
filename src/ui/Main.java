package ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	
	private DatabaseGUI appController;

    public static void main(String []team) {
        launch(team);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		appController = new DatabaseGUI();
		appController.setMainStage(primaryStage);
		appController.mainMenu();
		
	}

}