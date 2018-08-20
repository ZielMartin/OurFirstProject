package de.mavid.data.controller;

import de.mavid.data.Entities.Territory;
import de.mavid.gui.model.TerritoryModel;

public class TerritoryAdapter {
	
	public Territory get(TerritoryModel guiModel) {
		Territory bean = new Territory();
		bean.setId(guiModel.getId());
		bean.setName(guiModel.getName());
		bean.setNumber(guiModel.getNumber());
		return bean;
	}
	
	public TerritoryModel get(Territory bean) {
		TerritoryModel guiModel = new TerritoryModel();
		guiModel.setId(bean.getId());
		guiModel.setName(bean.getName());
		guiModel.setNumber(bean.getNumber());
		return guiModel;
	}
}
