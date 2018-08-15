package de.mavid.main;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point2D;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Utility {

	private static Stage stage = null;

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Utility.stage = stage;
	}

	public static void showTooltip(Control control, String tooltipText, ImageView tooltipGraphic) {
		Point2D p = control.localToScene(0.0, 0.0);

		final Tooltip customTooltip = new Tooltip();
		customTooltip.setText(tooltipText);

		control.setTooltip(customTooltip);
		customTooltip.setAutoHide(true);

		customTooltip.show(Utility.stage, p.getX() + control.getScene().getX() + control.getScene().getWindow().getX(),
				p.getY() + control.getScene().getY() + control.getScene().getWindow().getY());

	}

	public static void makeTextfieldNumbersOnly(TextField textfield) {
		textfield.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					Utility.showTooltip(textfield, "nur Zahlen", null);
					textfield.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
	}
}
