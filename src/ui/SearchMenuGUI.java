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
import javafx.scene.input.MouseEvent;
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
    	typeSearch.getItems().addAll(SEARCH_TYPE.ID, SEARCH_TYPE.Name, SEARCH_TYPE.LastName, SEARCH_TYPE.FullName);
	}
		
	@FXML
	void searching(KeyEvent event) {
		searchList.getItems().clear();
		if(event.getCode()==KeyCode.ENTER) {
			String e = search.getText();
			if(!e.equals("")) {
				switch (typeSearch.getValue()) {
				case ID:
					searchList.getItems().addAll(database.getLperID(e));
					break;
				case Name:
					searchList.getItems().addAll(database.getLperName(e));
					break;
				case LastName:
					searchList.getItems().addAll(database.getLperSurName(e));
					break;
				case FullName:
					searchList.getItems().addAll(database.getLperFullName(e));
					break;
				default:
					break;
				}
			}
		}
	}
	
	@FXML
	void readValue(MouseEvent event) throws IOException {
		if(searchList.getItems().size() <= 10) {
			Person p = searchList.getSelectionModel().getSelectedItem();
			UpdateDeleteMenuGUI ud = new UpdateDeleteMenuGUI(mainPane, database);
			ud.startMenu();
			ud.constructMenu(p);
		}	
	}

	public class PleaseProvideControllerClassName {

	}
	
}
