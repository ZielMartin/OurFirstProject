package de.mavid.main;

import java.io.IOException;
import java.net.URL;

import de.mavid.gui.model.TerritoryModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class TerritoryListCell extends ListCell<TerritoryModel> {
	private HBox content;
	
	@FXML
    private Text name;
	
	@FXML
    private Text number;

    public TerritoryListCell() {
        super();
        TerritoryListCell ref = this;
        
        URL resource = getClass().getResource("/fxml/TerritoryListCell.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(resource);
        loader.setControllerFactory(new Callback<Class<?>, Object>() {
			@Override
			public Object call(Class<?> aClass) {
				return ref;
			}
		});
        
        
        try {
			content = (HBox) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
