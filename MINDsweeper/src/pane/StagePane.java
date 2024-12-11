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

public class StagePane extends GridPane {
    public StagePane() {
        setPrefSize(GUIConfig.APP_WIDTH, GUIConfig.APP_HEIGHT);
        setAlignment(Pos.CENTER);
        setHgap(30);
        setVgap(30);
        
        setupBackground();
        createTitle();
        createAllStageButtons();
        createBackButton();
    }

    private void setupBackground() {
        setBackground(new Background(new BackgroundImage(
            new Image(ClassLoader.getSystemResource(GUIConfig.STAGE_BG).toString()),
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            new BackgroundSize(1080, 720, false, false, false, false)
        )));
    }

    private void createTitle() {
        Text title = new Text("Select Stage:");
        title.setFont(Font.font("Impact", FontWeight.BOLD, 80));
        title.setFill(Color.BLACK);
        add(title, 0, 0, 3, 1);
    }

    private Button createStageButton(String text, int stage) {
        Button button = new Button(text);
        GUIController.getInstance().styleButton(button);
        button.setOnMouseClicked(e -> GUIController.getInstance().showGamePane(stage));
        return button;
    }

    private void createAllStageButtons() {
        for (int i = 1; i <= 9; i++) {
            Button stageButton = createStageButton(String.valueOf(i), i);
            add(stageButton, (i - 1) % 3, 1 + (i - 1) / 3);
        }
    }

    private void createBackButton() {
        Button backButton = new Button("Back");
        GUIController.getInstance().styleButton(backButton);
        backButton.setOnMouseClicked(e -> GUIController.getInstance().showHomePane());
        add(backButton, 1, 4);
    }
}
