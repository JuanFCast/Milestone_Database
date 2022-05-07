package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class UpdateDeleteMenuGUI {
	
	@FXML
	private Pane mainPane;

	public UpdateDeleteMenuGUI(Pane p) {
		mainPane = p;
	}
	
	public void startMenu() throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("delete_actualization.fxml"));
    	fxmlloader.setController(this);
    	Parent log = fxmlloader.load();
    	mainPane.getChildren().setAll(log);
	}
}
