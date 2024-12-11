package cell;

import control.GUIConfig;
import control.GameController;
import pane.GamePane;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BombCell extends Cell {
	// Constructor Method
	public BombCell(int x, int y, double size, GamePane board) {
		super(x,y,size,board);
		setRevealImgURL(GUIConfig.BOMB_IMAGE);
	}
	
	// Methods
	@Override
	public void revealCell(boolean playSound) {
		if(isFlagged() || isClicked()) {
			return;
		}
		
		updateCellImage(getRevealImgURL());
        setClicked(true);
        if(playSound) {
        	playSFX();
        }
        
        if(GameController.getInstance().getShieldAmount() == 0) {
        	GameController.getInstance().endGame(false);
        }
        else {
        	GameController.getInstance().updateShieldAmount(-1);	
        }
	}
	
	@Override
	protected void playSFX() {
		MediaPlayer sfx = new MediaPlayer(new Media(
				ClassLoader.getSystemResource(GUIConfig.SFX[1]).toString()));
		sfx.play();
	}
	
	@Override
	public String toString() {
		return "BombCell (X = " + getxPosition() + ", Y = " + getyPosition() + ")";
	}
}
