package de.mavid.main;



import de.mavid.gui.controller.TerritoriesController;
import de.mavid.gui.controller.TerritoryController;
import javafx.application.Application;

import javafx.stage.Stage;

public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) {
    	Utility.setStage(primaryStage);
        primaryStage.setTitle("Hello World!");
        
        TerritoriesController.ShowView(primaryStage);
        
        primaryStage.show();
    }
}