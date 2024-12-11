package cell;

import control.GUIConfig;
import control.GameController;
import pane.GamePane;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ShieldCell extends Cell implements SpecialCell {
	// Constructor Method
	public ShieldCell(int x, int y, double size, GamePane board) {
		super(x,y,size,board);
		setRevealImgURL(GUIConfig.SPECIAL_IMAGE[1]);
	}
	
	// Methods
	@Override
	public void revealCell(boolean playSound) {
		// The cell must not flagged or already clicked
		if(isFlagged() || isClicked()) {
			return;
		}
		
		if(playSound) {
        	playSFX();
        }
		
		updateCellImage(getRevealImgURL());
        setClicked(true);
        useSkill();
        GameController.getInstance().updateCellClicked(1);
	}
	
	@Override
	protected void playSFX() {
		MediaPlayer sfx = new MediaPlayer(new Media(
				ClassLoader.getSystemResource(GUIConfig.SFX[3]).toString()));
		sfx.play();
	}
	
	@Override
	public void useSkill() {
		GameController.getInstance().updateShieldAmount(1);
	}
	
	@Override
	public String toString() {
		return "ShieldCell (X = " + getxPosition() + ", Y = " + getyPosition() + ")";
	}
}
