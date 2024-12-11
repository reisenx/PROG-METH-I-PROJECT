package pane;

import control.GUIConfig;
import control.GUIController;
import control.GameConfig;
import control.GameController;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ControlPane extends StackPane {
    // Class Properties
	private Text stageText = new Text();
	private Text gameText = new Text();
	private Text timerText = new Text();
    private Text flagText = new Text();
    private Text cellText = new Text();
    private Text shieldText = new Text();
    private Button startButton = new Button();
    private Button restartButton = new Button();
    private Button nextStageButton = new Button();
    private Button backButton = new Button();
    private VBox contentBox = new VBox(20);
    
    private int time = 0;
    private Timeline timer;

    // Constructor Method
    public ControlPane() {
    	setPrefSize(GUIConfig.CONTROL_WIDTH, GUIConfig.CONTROL_HEIGHT);
        setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        contentBox.setAlignment(Pos.CENTER);
        
        createStageText();
        createGameText();
        createTimerText();
        createFlagText();
        createCellText();
        createShieldText();
        createStartButton();
        createRestartButton();
        createNextStageButton();
        createBackButton();
        
        getChildren().add(contentBox);
    }
    
	// Methods
    private void createStageText() {
    	getStageText().setText("STAGE: " + GamePane.getStage());
    	getStageText().setFont(Font.font("Trebuchet MS", 48));
    	
    	contentBox.getChildren().add(getStageText());
    }
    
    private void createGameText() {
        getGameText().setText("Prepare yourself!");
        getGameText().setFont(Font.font("Trebuchet MS", 36));
        
        contentBox.getChildren().add(getGameText());
    }
    
    private void createTimerText() {
    	timerText.setText("Time: 0");
    	timerText.setFont(Font.font("Trebuchet MS", 24));
        
        contentBox.getChildren().add(timerText);
    }
    
    private void createFlagText() {
    	final int INITIAL_FLAG = GameConfig.BOMBS[GamePane.getStage() - 1];
        getFlagText().setText("Remaining Flags x " + INITIAL_FLAG);
        getFlagText().setFont(Font.font("Trebuchet MS", 24));
        
        contentBox.getChildren().add(getFlagText());
    }

    private void createCellText() {
        getCellText().setText("Clicked cells x 0");
        getCellText().setFont(Font.font("Trebuchet MS", 24));
        
        contentBox.getChildren().add(getCellText());
    }
    
    private void createShieldText() {
    	getShieldText().setText("Shield x 0");
    	getShieldText().setFont(Font.font("Trebuchet MS", 24));
    	
    	contentBox.getChildren().add(getShieldText());
    }

    private void createStartButton() {
    	startButton.setText("Start Game");
    	startButton.setOnAction(e -> startButtonHandler());
    	GUIController.getInstance().styleButton(startButton);
        contentBox.getChildren().add(startButton);
    }

    private void createRestartButton() {
    	restartButton.setText("Restart");
    	restartButton.setOnAction(e -> restartButtonHandler());
    	restartButton.setDisable(true);
    	GUIController.getInstance().styleButton(restartButton);
        contentBox.getChildren().add(restartButton);
    }
    
    private void createNextStageButton() {
    	getNextStageButton().setText("Next Stage");
    	getNextStageButton().setOnAction(e -> {
    		GUIController.getInstance().showGamePane(GamePane.getStage() + 1);
    	});
    	getNextStageButton().setDisable(true);
    	GUIController.getInstance().styleButton(getNextStageButton());
        contentBox.getChildren().add(getNextStageButton());
    }
    
    private void createBackButton() {
    	backButton.setText("Back");
    	backButton.setOnMouseClicked(e -> GUIController.getInstance().showHomePane());
    	GUIController.getInstance().styleButton(backButton);
    	contentBox.getChildren().add(backButton);
    }

	private void startButtonHandler() {
        GameController.getInstance().newGame();
        startButton.setDisable(true);
        restartButton.setDisable(false);
        startTimer();
    }

    private void restartButtonHandler() {
        GameController.getInstance().restartGame();
        startButton.setDisable(false);
        restartButton.setDisable(true);
        stopTimer();
        resetTimer();
    }
    
    private void updateTimerText() {
        Platform.runLater(() -> timerText.setText("Time: " + time));
    }
    
    public void updateFlagText(int flagCount) {
        this.getFlagText().setText("Remaining Flags x " + flagCount);
    }

    public void updateCellText(int cellClicked) {
        this.getCellText().setText("Clicked cells x " + cellClicked);
    }
    
    public void updateShieldText(int sheidAmount) {
    	this.getShieldText().setText("Shield x " + sheidAmount);
    }
    
    public void startTimer() {
        stopTimer();
        timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            time++;
            updateTimerText();
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }
    
    public void resetTimer() {
    	time = 0;
        updateTimerText();
    }
    
    public void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
    }

    // Getters & Setters
    public Text getStageText() {
		return stageText;
	}
    
    public Text getGameText() {
        return gameText;
    }

    public Text getFlagText() {
        return flagText;
    }

    public Text getCellText() {
        return cellText;
    }
    
    public Text getShieldText() {
		return shieldText;
	}

    public Button getNextStageButton() {
		return nextStageButton;
	}
    
	public int getTime() {
		return time;
	}
}
