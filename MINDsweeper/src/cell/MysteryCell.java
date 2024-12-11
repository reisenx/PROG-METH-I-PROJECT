package cell;

import control.GUIConfig;
import control.GameController;
import pane.GamePane;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MysteryCell extends Cell implements SpecialCell{
	// Constructor Method
	public MysteryCell(int x, int y, double size, GamePane board) {
		super(x,y,size,board);
		useSkill();
	}
	
	// Method
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
        GameController.getInstance().updateCellClicked(1);
	}
	
	@Override
	protected void playSFX() {
		MediaPlayer sfx = new MediaPlayer(new Media(
				ClassLoader.getSystemResource(GUIConfig.SFX[2]).toString()));
		sfx.play();
	}
	
	@Override
	public void useSkill() {
		this.setRevealImgURL(GUIConfig.SPECIAL_IMAGE[0]);
	}
	
	@Override
	public String toString() {
		return "MysteryCell (X = " + getxPosition() + ", Y = " + getyPosition() + ")";
	}
}
