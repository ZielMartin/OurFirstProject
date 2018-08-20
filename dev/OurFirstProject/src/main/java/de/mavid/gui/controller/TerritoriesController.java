package de.mavid.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import de.mavid.gui.model.TerritoriesModel;
import de.mavid.gui.model.TerritoryModel;
import de.mavid.gui.view.TerritoriesView;
import de.mavid.gui.view.TerritoryView;
import de.mavid.main.TerritoryListCell;
import de.mavid.main.Utility;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TerritoriesController implements Initializable {
	private TerritoriesModel model;
	
	@FXML
	private BorderPane border;
	
	private ListView<TerritoryModel> list;
	
	public TerritoriesController(TerritoriesModel model) {
		this.model = model;
	}

	public static void ShowView() {
		ShowView(new TerritoriesModel());
	}

	public static void ShowView(TerritoriesModel model) {
		try {
			new TerritoriesView().start(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openNewTerritoryView() {
		TerritoryController.ShowView();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list = new ListView<>(model.getTerritories());
		border.setCenter(list);
		this.list.setCellFactory(new Callback<ListView<TerritoryModel>, ListCell<TerritoryModel>>() {
			
			@Override
			public ListCell<TerritoryModel> call(ListView<TerritoryModel> param) {
				return new TerritoryListCell();
			}
		});
		
		this.list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TerritoryModel>() {

		    @Override
		    public void changed(ObservableValue<? extends TerritoryModel> observable, TerritoryModel oldValue, TerritoryModel newValue) {
		        TerritoryController.ShowView(newValue);
		    }
		});

	}

}
