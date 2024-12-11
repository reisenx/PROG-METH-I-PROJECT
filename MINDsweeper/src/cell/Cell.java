package cell;

import control.GUIConfig;
import control.GameController;
import pane.GamePane;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public abstract class Cell extends Pane {
	// Class Properties
	private int xPosition;
	private int yPosition;
	private boolean isClicked;
	private boolean isFlagged;
	private String coverImgURL;
	private String revealImgURL;
	private GamePane board;

	// Constructor Method
	public Cell(int x, int y, double size, GamePane board) {
		super();
		setxPosition(x);
		setyPosition(y);
		setClicked(false);
		setFlagged(false);
		setCoverImgURL(GUIConfig.CELL_COVER_IMAGE);
		setRevealImgURL(GUIConfig.CELL_IMAGE[0]);
		setPrefSize(size,size);
		setBoard(board);
		updateCellImage(getCoverImgURL());
		
		addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				// This method must do nothing before the game starts
				if(GameController.getInstance().isGameStart()) {
					if(e.getButton() == MouseButton.PRIMARY) {
						revealCell(true);
					}
					else if(e.getButton() == MouseButton.SECONDARY) {
						flagCell();
					}
				}
			}
		});
	}
	
	// Methods
	public abstract void revealCell(boolean playSound);
	protected abstract void playSFX();
	
	public void enable() {
		setDisable(false);
	}
	
	public void disable() {
		setDisable(true);
	}
	
	protected void updateCellImage(String URL) {
		Image image = new Image(ClassLoader.getSystemResource(URL).toString());
        ImageView imageView = new ImageView(image);
        
        imageView.setFitWidth(getWidth());
        imageView.setFitHeight(getHeight());

        BackgroundImage imageBackground = new BackgroundImage(
            image,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false)
        );
        setBackground(new Background(imageBackground));
	}
	
	public void flagCell() {
	    if(isClicked()) {
	        return;
	    }
	    
	    if(!isFlagged()) {
	        setCoverImgURL(GUIConfig.FLAG_COVER_IMAGE);
	    	GameController.getInstance().updateFlagRemaining(-1);
	        setFlagged(true);
	    }
	    else {
	    	setCoverImgURL(GUIConfig.CELL_COVER_IMAGE);
	    	GameController.getInstance().updateFlagRemaining(1);
	        setFlagged(false);
	    }
	    updateCellImage(getCoverImgURL());
	}
	
	public String toString() {
		return "Cell (X = " + getxPosition() + ", Y = " + getyPosition() + ")";
	}
	
	// Getter & Setter
	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public String getCoverImgURL() {
		return coverImgURL;
	}

	public void setCoverImgURL(String coverImgURL) {
		this.coverImgURL = coverImgURL;
	}

	public String getRevealImgURL() {
		return revealImgURL;
	}

	public void setRevealImgURL(String revealImgURL) {
		this.revealImgURL = revealImgURL;
	}

	public boolean isFlagged() {
		return isFlagged;
	}

	public void setFlagged(boolean isFlagged) {
		this.isFlagged = isFlagged;
	}

	public boolean isClicked() {
		return isClicked;
	}

	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}

	public GamePane getBoard() {
		return board;
	}

	public void setBoard(GamePane board) {
		this.board = board;
	}
}
