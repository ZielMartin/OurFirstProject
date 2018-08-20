package de.mavid.main;



import de.mavid.data.DataAccess;
import de.mavid.data.Entities.Territory;
import de.mavid.gui.controller.TerritoriesController;
import de.mavid.gui.controller.TerritoryController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) {
    	Utility.setStage(primaryStage);
    	
    	primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				if(event.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST) {
					System.out.println("CLOSE REQUEST");
					DataAccess.destroy();
				}
			}
		});
    	
        primaryStage.setTitle("Hello World!");
        
        TerritoriesController.ShowView();
        
        primaryStage.show();
    }
}