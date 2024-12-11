package pane;

import control.GUIConfig;
import control.GUIController;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class HowToPlayPane extends GridPane{
	// Constructor Method
	public HowToPlayPane(){
		setAlignment(Pos.CENTER_RIGHT);
		setPrefSize(GUIConfig.APP_WIDTH,GUIConfig.APP_HEIGHT);
		setPadding(new Insets(20, 20, 20, 20));
		
		setupHowToPlay();
		createTitle();
		createBackButton();
	}
	
	// Methods
	private void setupHowToPlay() {
		setBackground(new Background(new BackgroundFill(
		        Color.web("#ffffff"),
		        CornerRadii.EMPTY,
		        Insets.EMPTY
		)));
		
		Image howToPlayImage = new Image(ClassLoader.getSystemResource(GUIConfig.HOW_TO_IMAGE).toString());
	    ImageView howToPlayImageView = new ImageView(howToPlayImage);
	    howToPlayImageView.setFitWidth(1080); 
        howToPlayImageView.setPreserveRatio(true); 

	    add(howToPlayImageView, 0, 1);
	}
	
	private void createTitle() {
		Text title = new Text("How to Play:");
		title.setFont(Font.font("Impact", FontWeight.BOLD, 80));
		title.setFill(Color.BLACK);
		add(title, 0, 0);
	}
	
	private void createBackButton() {
		Button backButton = new Button("Back");
		backButton.setOnMouseClicked(e -> GUIController.getInstance().showHomePane());
		GUIController.getInstance().styleButton(backButton);
		add(backButton, 0, 2);
	}
}
