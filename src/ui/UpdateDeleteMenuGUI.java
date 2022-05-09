package ui;

import java.io.IOException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import model.Database;
import model.Gender;
import model.Person;

public class UpdateDeleteMenuGUI {
	
	@FXML
	private Pane mainPane;
	@FXML
	private DatePicker birth_dataPicker;
	@FXML
    private ToggleGroup gender;
	@FXML
    private RadioButton female_radiobttn;
    @FXML
    private RadioButton male_radiobttn;
    @FXML
    private RadioButton other_radiobttn;
    @FXML
    private TextField height_txtField1;
	@FXML
	private TextField nacionality_txtField;
	@FXML
	private TextField name_txtField;
	@FXML
	private TextField surname_txtField;
	
	private Person personSelected;
	
	private Database database;
	

	public UpdateDeleteMenuGUI(Pane p, Database d) {
		mainPane = p;
		database = d;
	}
	
	public void startMenu() throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("delete_actualization.fxml"));
    	fxmlloader.setController(this);
    	Parent log = fxmlloader.load();
    	mainPane.getChildren().setAll(log);
	}
	
	public void constructMenu(Person p) {
		personSelected = p;
		name_txtField.setText(p.name());
		surname_txtField.setText(p.surname());
		birth_dataPicker.setValue(p.birth());
		height_txtField1.setText(p.height());
		nacionality_txtField.setText(p.nacionality());
		if(p.gender().equals(Gender.male)) {
			male_radiobttn.setSelected(true);
		} else if(p.gender().equals(Gender.female)) {
			female_radiobttn.setSelected(true);
		} else {
			other_radiobttn.setSelected(true);
		}
	}
	
	@FXML
    void delete_bttn(ActionEvent event) throws Exception {
		if(personSelected != null) {
			database.remove(personSelected);
		}
    }

    @FXML
    void update_bttn(ActionEvent event) {
		String name = name_txtField.getText();
		String surname = surname_txtField.getText();
		LocalDate birth = birth_dataPicker.getValue();
		String nacionality = nacionality_txtField.getText();
		String height = height_txtField1.getText();
		Gender g;
		if(male_radiobttn.isSelected()) {
			g = Gender.male;
		} else if(female_radiobttn.isSelected()) {
			g = Gender.female;
		} else {
			g = Gender.other;
		}
		
		Person aux = new Person(name, surname, g, birth, height, nacionality);
		if(personSelected != null) {
			aux.setID(personSelected.id());
		}
		try {
			database.update(personSelected, aux);
		} catch (Exception e) {}
    }
	
}
