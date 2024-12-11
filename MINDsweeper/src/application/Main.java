package application;

import control.GUIConfig;
import control.GUIController;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	// Class Properties
    private static BorderPane RootPane = new BorderPane();
    
    // Methods
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        GUIController.getInstance().showHomePane();
        GUIController.getInstance().playBGM();

        Scene scene = new Scene(RootPane, GUIConfig.APP_WIDTH, GUIConfig.APP_HEIGHT);
        primaryStage.setTitle("MINDsweeper");
        primaryStage.getIcons().add(
        		new Image(ClassLoader.getSystemResource(GUIConfig.ICON).toString()
        ));
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    // Getters & Setters
    public static BorderPane getRootPane() {
    	return RootPane;
    }
}