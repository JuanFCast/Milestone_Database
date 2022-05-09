package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Database;

public class GeneralPaneGUI {
	
	private Stage mainStage;
	@FXML
	private Pane mainPane;
	public Database database;
	
	public GeneralPaneGUI(Stage s, Database d) {
		mainStage = s;
		database = d;
	}

	public void startMenu() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainPane.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.setTitle("GENERAL MENU");
		mainStage.show();
	}
	
	@FXML
    private void searchMenu(ActionEvent event) throws IOException {
		SearchMenuGUI sm = new SearchMenuGUI(mainPane, database);
		sm.startMenu();
    }

    @FXML
    private void updateRemoveMenu(ActionEvent event) throws IOException {
    	UpdateDeleteMenuGUI ud = new UpdateDeleteMenuGUI(mainPane);
		ud.startMenu();
    }
	
}
