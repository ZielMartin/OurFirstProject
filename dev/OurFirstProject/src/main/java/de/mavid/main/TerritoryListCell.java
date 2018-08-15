package de.mavid.main;

import de.mavid.gui.model.TerritoryModel;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class TerritoryListCell extends ListCell<TerritoryModel> {
	private HBox content;
    private Text name;
    private Text number;

    public TerritoryListCell() {
        super();
        name = new Text();
        number = new Text();
        VBox vBox = new VBox(name, number);
        content = new HBox(new Label("[Graphic]"), vBox);
        content.setSpacing(10);
    }

    @Override
    protected void updateItem(TerritoryModel item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null && !empty) { // <== test for null item and empty parameter
            name.setText(item.getName());
            number.setText(item.getNumber() + "");
            setGraphic(content);
        } else {
            setGraphic(null);
        }
    }
}
