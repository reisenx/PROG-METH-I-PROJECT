package control;

import cell.Cell;
import pane.ControlPane;
import pane.GamePane;

import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class GameController {
    // Class Properties
	private static GameController instance;
	private int clickedCells = 0;
    private int flagsRemaining;
    private int shieldAmount = 0;
    private boolean isGameStart = false;
    private boolean isGameEnd = false;
    private GamePane gamePane;
    private ControlPane controlPane;
    
    // Constructor Method
    private GameController() {}
    
    public static GameController getInstance() {
    	if(instance == null) {
    		instance = new GameController();
    	}
    	return instance;
    }
    
    // Methods
    private static void playWinSFX() {
    	MediaPlayer sfx = new MediaPlayer(new Media(
    			ClassLoader.getSystemResource(GUIConfig.SFX[5]).toString()));
    	sfx.play();
    }
    
    private void initailizeValue() {
    	clickedCells = 0;
        shieldAmount = 0;
        flagsRemaining = getGamePane().getBombsAmount();
        getControlPane().updateFlagText(getFlagsRemaining());
        getControlPane().updateCellText(getClickedCells());
        getControlPane().updateShieldText(getShieldAmount());
    }
    
    public void newGame() {
        setGameStart(true);
        setGameEnd(false);
        initailizeValue();
        getControlPane().getGameText().setText("Game Start!");
        enableAllCells();
    }

    public void restartGame() {
        setGameStart(false);
        setGameEnd(false);
        getGamePane().resetBoard();
        initailizeValue();
        getControlPane().getGameText().setText("Prepare yourself!");
        disableAllCells();
    }

    public void endGame(boolean isWin) {
        setGameStart(false);
        setGameEnd(true);
        if(isWin) {
        	getControlPane().getGameText().setText("You Win!");
        	getControlPane().getNextStageButton().setDisable(false);
        	playWinSFX();
        }
        else {
        	getControlPane().getGameText().setText("You Lose!");
        	revealBombs();
        }
        getControlPane().stopTimer();
        disableAllCells();
    }
    
    public void updateFlagRemaining(int change) {
    	final int MAX_FLAG = getGamePane().getBombsAmount();
    	
    	flagsRemaining += change;
    	flagsRemaining = Math.min(flagsRemaining, MAX_FLAG);
        getControlPane().updateFlagText(getFlagsRemaining());
    }

    public void updateCellClicked(int count) {
    	final int MIN_CLICKED = 0;
    	final int MAX_CLICKED = getGamePane().getCellsAmount() - getGamePane().getBombsAmount();
    	
    	clickedCells += count;
        clickedCells = Math.max(MIN_CLICKED, clickedCells);
        clickedCells = Math.min(clickedCells, MAX_CLICKED);
        getControlPane().updateCellText(getClickedCells());

        // Check win condition
        if (clickedCells == MAX_CLICKED) {
            endGame(true);
        }
    }
    
    public void updateShieldAmount(int change) {
    	final int MIN_SHIELD = 0;
    	final int MAX_SHIELD = getGamePane().getShieldAmount();
    	
    	shieldAmount += change;
    	shieldAmount = Math.max(MIN_SHIELD, shieldAmount);
    	shieldAmount = Math.min(shieldAmount, MAX_SHIELD);
    	getControlPane().updateShieldText(shieldAmount);
    }

    private void revealBombs() {
        for(Cell bombCell : getGamePane().getAllBombCells()) {
        	if(bombCell.isFlagged()) {
        		bombCell.flagCell();
        	}
        	bombCell.revealCell(false);
        }
    }

    private void disableAllCells() {
        for (ArrayList<Cell> row : getGamePane().getAllCells()) {
            for (Cell cell : row) {
                cell.disable();
            }
        }
    }

    private void enableAllCells() {
        for (ArrayList<Cell> row : getGamePane().getAllCells()) {
            for (Cell cell : row) {
                cell.enable();
            }
        }
    }

    // Getters & Setters
    public GamePane getGamePane() {
        return gamePane;
    }

    public void setGamePane(GamePane gamePane) {
        this.gamePane = gamePane;
    }

    public ControlPane getControlPane() {
        return controlPane;
    }

    public void setControlPane(ControlPane controlPane) {
        this.controlPane = controlPane;
    }
    
    public int getClickedCells() {
		return clickedCells;
	}

	public int getFlagsRemaining() {
		return flagsRemaining;
	}

	public int getShieldAmount() {
		return shieldAmount;
	}

	public boolean isGameStart() {
        return isGameStart;
    }

    public void setGameStart(boolean gameStart) {
        this.isGameStart = gameStart;
    }

    public boolean isGameEnd() {
        return isGameEnd;
    }

    public void setGameEnd(boolean isGameEnd) {
        this.isGameEnd = isGameEnd;
    }
}