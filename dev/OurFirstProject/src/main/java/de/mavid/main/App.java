package de.mavid.main;

import java.io.IOException;
import java.net.URL;

import de.mavid.gui.controller.TerritoryController;
import de.mavid.gui.view.TerritoryView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application{
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        primaryStage.show();
        
        TerritoryController.ShowView(primaryStage);
    }
}