package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GeneralPane {
	
	private Pane mainPane;
	private Stage mainStage;
	
	public GeneralPane(Stage s, Pane p) {
		mainPane = p;
		mainStage = s;
	}

	public void start() throws IOException {
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
		SearchMenu sm = new SearchMenu(mainPane);
		sm.start();
    }

    @FXML
    private void updateMenu(ActionEvent event) {

    }
	
	
}
