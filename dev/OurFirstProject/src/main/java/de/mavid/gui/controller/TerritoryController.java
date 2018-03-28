package de.mavid.gui.controller;

import de.mavid.gui.model.TerritoryModel;
import de.mavid.gui.view.TerritoryView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class TerritoryController implements Initializable {
	private TerritoryModel model;

	@FXML
	private TextField number;
	@FXML
	private TextField name;
	
	
	public TerritoryController(TerritoryModel model) {
		this.model = model;
	}

	public static void ShowView(Stage stage) {
		try {
			new TerritoryView().start(stage, new TerritoryModel());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ShowView(Stage stage, TerritoryModel model) {
		try {
			new TerritoryView().start(stage, model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.number.textProperty().bindBidirectional(this.model.numberProperty(), new StringConverter<Number>() {
			@Override
			public String toString(Number number) {
				return number + "";
			}

			@Override
			public Number fromString(String string) {
				return Long.valueOf(string);
			}
		});
	}
}
