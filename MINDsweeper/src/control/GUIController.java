package control;

import application.Main;
import pane.ControlPane;
import pane.GamePane;
import pane.HomePane;
import pane.HowToPlayPane;
import pane.StagePane;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GUIController {
	// Class Properties
	private static GUIController instance;
	private static final MediaPlayer BGM = new MediaPlayer(new Media(
			ClassLoader.getSystemResource(GUIConfig.BGM).toString()
	));
	
	// Constructor Method
	private GUIController() {};
	
	public static GUIController getInstance() {
		if(instance == null) {
			instance = new GUIController();
		}
		return instance;
	}
	
	// Methods
	public void playBGM() {
		BGM.setCycleCount(MediaPlayer.INDEFINITE);
        BGM.play();
	}
	
	public void showHomePane() {
        HomePane homePane = new HomePane();
        Main.getRootPane().setCenter(homePane);
        Main.getRootPane().setTop(null); 
    }

    public void showStagePane() {
        StagePane stagePane = new StagePane();
        Main.getRootPane().setCenter(stagePane);
        Main.getRootPane().setTop(null); 
    }
    
    public void showHowToPlayPane() {
    	HowToPlayPane howToPlayPane = new HowToPlayPane();
    	Main.getRootPane().setCenter(howToPlayPane);
    	Main.getRootPane().setTop(null); 
    }
    
    public void showGamePane(int stage) {
    	HBox gameControlPane = new HBox();
        gameControlPane.setPadding(new Insets(10));
        gameControlPane.setPrefSize(GUIConfig.APP_WIDTH, GUIConfig.APP_HEIGHT);
        
        GamePane gamePane = new GamePane(stage);
        ControlPane controlPane = new ControlPane();
        
        GameController.getInstance().setGamePane(gamePane);
        GameController.getInstance().setControlPane(controlPane);
        gameControlPane.getChildren().add(gamePane);
        gameControlPane.getChildren().add(controlPane);

        Main.getRootPane().setCenter(gameControlPane);
        Main.getRootPane().setTop(null); 
    }
    
    public void styleButton(Button button) {
    	button.setTextFill(Color.WHITE);
        button.setFont(Font.font("Trebuchet MS", 28));
        button.setPrefSize(200, 50);
    	
    	button.setBackground(new Background(new BackgroundFill(
                Color.web("#848484"),
                new CornerRadii(10),
                Insets.EMPTY
        )));
    	
        button.setOnMouseEntered(e -> {
            button.setBackground(new Background(new BackgroundFill(
                    Color.web("#dadada"),
                    new CornerRadii(10),
                    Insets.EMPTY
            )));
            button.setTextFill(Color.BLACK);
        });

        button.setOnMouseExited(e -> {
            button.setBackground(new Background(new BackgroundFill(
                    Color.web("#848484"),
                    new CornerRadii(10),
                    Insets.EMPTY
            )));
            button.setTextFill(Color.WHITE);
        });
    }
}
