package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.Database;
import model.Person;
import model.SEARCH_TYPE;

public class SearchMenuGUI {

	@FXML
	private Pane mainPane;
	
	@FXML
	private ChoiceBox<SEARCH_TYPE> typeSearch;
	
	@FXML
    private TextField search;
	@FXML
    private ListView<Person> searchList;
	private Database database;
	
	public SearchMenuGUI(Pane p, Database d) throws IOException {
		mainPane = p;
		database = d;
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
		
	@FXML
	void searching(KeyEvent event) {
		if(event.getCode()==KeyCode.ENTER) {
			String e = search.getText();
			if(!e.equals("")) {
				switch (typeSearch.getValue()) {
				case ID:
					
					break;
					
				case Name:
					searchList.getItems().addAll(database.getLperName(e));
					break;
					
				case LastName:
					searchList.getItems().addAll(database.getLperFullName(e));
					break;
					
				case Fullname:
					searchList.getItems().addAll(database.getLperFullName(e));
					break;

				default:
					break;
				}
			}
		}
	}
	
	public class PleaseProvideControllerClassName {

	}
	
}
