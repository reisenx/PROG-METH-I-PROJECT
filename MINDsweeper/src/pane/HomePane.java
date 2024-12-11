package pane;

import control.GUIConfig;
import control.GUIController;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class HomePane extends GridPane {
    // Constructor Method
    public HomePane() {
        setPrefSize(GUIConfig.APP_WIDTH, GUIConfig.APP_HEIGHT);
        setAlignment(Pos.CENTER);
        setVgap(10);
        setHgap(10);
        
        setupBackground();
        createTitle();
        createStartButton();
        createStageSelectButton();
        createHowToPlayButton();
        createExitButton();
    }
    
    // Methods
    private void setupBackground() {
        setBackground(new Background(new BackgroundImage(
                new Image(GUIConfig.HOME_BG),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(
                        BackgroundSize.DEFAULT.getWidth(),
                        BackgroundSize.DEFAULT.getHeight(),
                        true, true, true, false
                )
        )));
    }
    
    private void createTitle() {
        Text mind = new Text("MIND");
        mind.setFont(Font.font("Impact", FontWeight.BOLD, 95));
        mind.setFill(Color.BLACK);
        
        Text sweeper = new Text("SWEEPER");
        sweeper.setFont(Font.font("Impact", FontWeight.BOLD, 55));
        sweeper.setFill(Color.BLACK);
        
        add(mind, 70, 0);
        add(sweeper, 70, 1);
    }
    
    private void createStartButton() {
        Button startButton = new Button("Start Game");
        startButton.setOnMouseClicked(e -> GUIController.getInstance().showGamePane(1));
        GUIController.getInstance().styleButton(startButton);

        add(startButton, 70, 2);
    }
    
    private void createStageSelectButton() {
        Button stageSelectButton = new Button("Select Stage");
        stageSelectButton.setOnMouseClicked(e -> GUIController.getInstance().showStagePane());
        GUIController.getInstance().styleButton(stageSelectButton);

        add(stageSelectButton, 70, 3);
    }
    
    private void createHowToPlayButton() {
        Button howToPlayButton = new Button("How to Play");
        howToPlayButton.setOnMouseClicked(e -> GUIController.getInstance().showHowToPlayPane());
        GUIController.getInstance().styleButton(howToPlayButton);

        add(howToPlayButton, 70, 4);
    }
    
    private void createExitButton() {
        Button exitButton = new Button("Exit");
        exitButton.setOnMouseClicked(e -> System.exit(0));
        GUIController.getInstance().styleButton(exitButton);

        add(exitButton, 70, 5);
    }
}
