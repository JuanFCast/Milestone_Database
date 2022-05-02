package ui;

import java.io.IOException;
import java.util.function.UnaryOperator;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.stage.Stage;

public class MainMenuGUI {
	@FXML
    private TextField data_txtField;
    @FXML
    private Button generate_bttn;

    //Stage
	private Stage mainStage;

	//Constructor
	public MainMenuGUI(Stage s) throws IOException{
		mainStage = s;
	}

	//Methods
	public void start(double m) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("database_main_menu.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.setTitle("STARTER MENU");
		mainStage.show();
		data_txtField.setText("" + (int) m);;
	}
	
	@FXML
	public void initialize() {
		UnaryOperator<Change> integerFilter = change -> {
			String input = change.getText();
			if (input.matches("[0-9]*")) { 
				return change;
			}
			return null;
		};

		data_txtField.setTextFormatter(new TextFormatter<String>(integerFilter));	 
	}





}
