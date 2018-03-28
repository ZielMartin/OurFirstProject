package de.mavid.gui.view;

import java.io.IOException;
import java.net.URL;

import de.mavid.gui.controller.TerritoryController;
import de.mavid.gui.model.TerritoryModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TerritoryView {

	public void start(Stage stage, TerritoryModel model) {
		URL resource = getClass().getResource("/fxml/TerritoryView.fxml");
		Pane root = null;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(resource);
			loader.setControllerFactory(new Callback<Class<?>, Object>() {
				@Override
				public Object call(Class<?> aClass) {
					return new TerritoryController(model);
				}
			});
			root = (Pane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);

		stage.setMinWidth(root.minWidth(-1));
		stage.setMinHeight(root.minHeight(-1));
	}

}
