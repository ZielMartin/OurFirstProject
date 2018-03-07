package de.mavid.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application{
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}