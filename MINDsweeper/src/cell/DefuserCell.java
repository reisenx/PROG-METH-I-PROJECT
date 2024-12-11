package cell;

import control.GUIConfig;
import control.GameController;
import control.GameUtil;
import pane.GamePane;

import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class DefuserCell extends Cell implements SpecialCell {
	// Constructor Method
	public DefuserCell(int x, int y, double size, GamePane board) {
		super(x,y,size,board);
		setRevealImgURL(GUIConfig.SPECIAL_IMAGE[2]);
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
				ClassLoader.getSystemResource(GUIConfig.SFX[4]).toString()));
		sfx.play();
	}
	
	@Override
	public void useSkill() {
		ArrayList<Cell> bombs = getBoard().getAllBombCells();
		bombs = GameUtil.getUnflaggedCells(bombs);
		if(bombs.size() == 0) {
			return;
		}
		if(bombs.size() >= 3) {
			bombs = GameUtil.getRandomMultipleCells(bombs, 3);
		}
		for(Cell bomb : bombs) {
			bomb.flagCell();
		}
	}
	
	@Override
	public String toString() {
		return "DefuserCell (X = " + getxPosition() + ", Y = " + getyPosition() + ")";
	}
}
