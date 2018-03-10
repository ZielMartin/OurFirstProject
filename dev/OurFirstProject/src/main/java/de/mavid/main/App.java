package de.mavid.main;



import de.mavid.gui.controller.TerritoryController;
import javafx.application.Application;

import javafx.stage.Stage;

public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        
        TerritoryController.ShowView(primaryStage);
        
        primaryStage.show();
    }
}