package cell;

import control.GUIConfig;
import control.GameController;
import control.GameUtil;
import pane.GamePane;

import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class NormalCell extends Cell{
	// Constructor Method
	public NormalCell(int x, int y, double size, GamePane board) {
		super(x,y,size,board);
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
		
		// Set image of a cell
		int adjacentBombs = GameUtil.countBomb(this);
		int adjacentSpecial = GameUtil.countSpecial(this);
		int idx = adjacentBombs + adjacentSpecial;
		
		if(adjacentSpecial == 0) {
			setRevealImgURL(GUIConfig.CELL_IMAGE[idx]);
		}
		else {
			setRevealImgURL(GUIConfig.SPECIAL_CELL_IMAGE[idx]);
		}
		
		updateCellImage(getRevealImgURL());
        setClicked(true);
        GameController.getInstance().updateCellClicked(1);
        
        // If the current cell has adjacent bombCell or specialCell, stop the recursion
        if(adjacentBombs > 0 || adjacentSpecial > 0) {
        	return;
        }
        
        // Call recursive function to open all adjacent empty cell of current cell
        ArrayList<Cell> adjacentCells = GameUtil.getAdjacentNormalCells(this);
        for(Cell adjCell : adjacentCells) {
        	if(!adjCell.isFlagged() && !adjCell.isClicked()) {
        		adjCell.revealCell(false);
        	}
        }
	}
	
	@Override
	protected void playSFX() {
		MediaPlayer sfx = new MediaPlayer(new Media(
				ClassLoader.getSystemResource(GUIConfig.SFX[0]).toString()));
		sfx.play();
	}
	
	@Override
	public String toString() {
		return "NormalCell (X = " + getxPosition() + ", Y = " + getyPosition() + ")";
	}
}
