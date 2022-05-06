package ui;

import java.io.IOException;
import java.util.function.UnaryOperator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.stage.Stage;
import model.Database;

public class MainMenuGUI {
	@FXML
    private TextField data_txtField;
    @FXML
    private Button generate_bttn;
    @FXML
    private ProgressBar progress_bar;

    //Stage
	private Stage mainStage;
	private Database data;
	private DatabaseGUI controller;

	//Constructor
	public MainMenuGUI(Stage s, DatabaseGUI c, Database d) throws IOException{
		mainStage = s;
		controller = c;
		data = d;
	}

	//Methods
	public void startMenu(double m) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("database_main_menu.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.setTitle("STARTER MENU");
		mainStage.show();
		data_txtField.setText("" + (int) m);;
	}
	
	public void progressMenu() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("progress_bar.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.setTitle("STARTER MENU");
		mainStage.show();
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
	
	@FXML
    public void generateDataBase(ActionEvent event) throws IOException, InterruptedException {
		double d = Double.parseDouble(data_txtField.getText());
		progressMenu();
		int indicator = (int) (1/d);
		
		Thread t = new Thread() {
			public void run() {
				for(int i = 0; i < d; i++) {
					try {
						data.generate();
					} catch (IOException e) {
						e.printStackTrace();
					}
					progress_bar.setProgress(indicator);
				}
			}
		};
		
		t.start();
		t.join();
		controller.generalMenu();
	}
}
