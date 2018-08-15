package de.mavid.gui.model;

import java.util.List;

import de.mavid.data.DataAccess;
import de.mavid.data.Entities.Territory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TerritoriesModel {
	private ObservableList<TerritoryModel> territories;

	public TerritoriesModel() {
		this.territories = FXCollections.observableArrayList();
		
		List<Territory> l = DataAccess.getInstance().getAll(Territory.class);
		
		for(Territory t : l) {
			TerritoryModel tM = new TerritoryModel();
			tM.setName(t.getName());
			tM.setNumber(t.getNumber());
			this.territories.add(tM);
		}
	}
	
	public ObservableList<TerritoryModel> getTerritories() {
		return territories;
	}

	public void setTerritories(ObservableList<TerritoryModel> territories) {
		this.territories = territories;
	}
	
}
