package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class SearchMenuGUI {

	private Pane mainPane;
	
	public SearchMenuGUI(Pane p) {
		mainPane = p;
	}
	
	public void startMenu() throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("search_pane.fxml"));
    	fxmlloader.setController(this);
    	Parent log = fxmlloader.load();
    	mainPane.getChildren().setAll(log);
	}
	
}
