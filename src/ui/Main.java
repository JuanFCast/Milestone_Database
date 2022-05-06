package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	
	private DatabaseGUI appController;

    public static void main(String []team) {
        launch(team);
    }

	@Override
	public void start(Stage primaryStage) {
		try {
			appController = new DatabaseGUI();
			appController.setMainStage(primaryStage);
			appController.mainMenu();;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}