package de.mavid.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TerritoriesModel {
	private ObservableList<TerritoryModel> territories;

	public TerritoriesModel() {
		this.territories = FXCollections.observableArrayList();
		TerritoryModel x = new TerritoryModel();
		x.setName("x");
		TerritoryModel y = new TerritoryModel();
		y.setName("y");
		
		this.territories.addAll(x, y);
	}
	
	public ObservableList<TerritoryModel> getTerritories() {
		return territories;
	}

	public void setTerritories(ObservableList<TerritoryModel> territories) {
		this.territories = territories;
	}
	
}
