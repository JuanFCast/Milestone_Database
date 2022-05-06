package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class SearchMenu {

	private Pane mainPane;
	
	public SearchMenu(Pane p) {
		mainPane = p;
	}
	
	public void start() throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("search_pane.fxml"));
    	fxmlloader.setController(this);
    	Parent log = fxmlloader.load();
    	mainPane.getChildren().setAll(log);
	}
	
}
