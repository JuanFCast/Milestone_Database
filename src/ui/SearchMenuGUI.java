package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import model.SEARCH_TYPE;

public class SearchMenuGUI {

	@FXML
	private Pane mainPane;
	
	@FXML
	private ChoiceBox<SEARCH_TYPE> typeSearch;
	
	public SearchMenuGUI(Pane p) throws IOException {
		mainPane = p;
	}
	
	public void startMenu() throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("search_pane.fxml"));
		fxmlloader.setController(this);
    	Parent log = fxmlloader.load();
    	mainPane.getChildren().setAll(log);
    	typeSearch.getItems().addAll(SEARCH_TYPE.ID, SEARCH_TYPE.Name, SEARCH_TYPE.LastName, SEARCH_TYPE.Fullname);
	}
	
	private void searching() {
		
	}
	
	public class PleaseProvideControllerClassName {

	}
	
}
