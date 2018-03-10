package de.mavid.gui.controller;

import de.mavid.gui.view.TerritoryView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TerritoryController {
	@FXML 
	private TextField helloWorld;
	
	
	public TerritoryController() {
	}

	public static void ShowView(Stage stage) {
		try {
			new TerritoryView().start(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void buttonAction() {
		System.out.println(helloWorld.getText()); 
	}
}
