package de.mavid.gui.view;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TerritoryView extends Application {

	@Override
	public void start(Stage stage) throws Exception{
		URL resource = getClass().getResource("/fxml/TerritoryView.fxml");
		Pane root = (Pane) FXMLLoader.load(resource);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
