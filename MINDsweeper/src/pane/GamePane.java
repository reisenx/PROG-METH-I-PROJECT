package pane;

import cell.*;
import control.GUIConfig;
import control.GameConfig;
import control.GameUtil;

import java.util.ArrayList;
import java.util.HashSet;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class GamePane extends GridPane {
	// Class Properties
	private static int stage;
	private int boardSize;
	private double cellSize;
	private int cellsAmount;
	private int bombsAmount;
	private int mysteryAmount;
	private int shieldAmount;
	private int defuserAmount;
	
	private ArrayList<ArrayList<Cell>> allCells;
	private ArrayList<Cell> allBombCells;
	
	// Constructor Method
	public GamePane(int stage) {
		super();
		setStage(stage);
		allCells = new ArrayList<ArrayList<Cell>>();
		allBombCells = new ArrayList<Cell>();
		boardSize = GameConfig.GRID_SIZE[getStage() - 1];
		cellsAmount = GameConfig.CELLS[getStage() - 1];
		bombsAmount = GameConfig.BOMBS[getStage() - 1];
		mysteryAmount = GameConfig.MYSTERY[getStage() - 1];
		shieldAmount = GameConfig.SHIELD[getStage() - 1];
		defuserAmount = GameConfig.DEFUSER[getStage() - 1];
		cellSize = GameConfig.CELL_SIZE[getStage() - 1];
		
		setHgap(5);
		setVgap(5);
		setPadding(new Insets(5));
		setAlignment(Pos.CENTER);
		setPrefSize(GUIConfig.GAME_WIDTH,GUIConfig.GAME_HEIGHT);
		setBorder(new Border(new BorderStroke(
				Color.LIGHTGRAY,
				BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY,
				BorderWidths.DEFAULT
				)));
		setBackground(new Background(new BackgroundFill(
				Color.WHITE,
				CornerRadii.EMPTY,
				Insets.EMPTY
				)));
		
		constructBoard();
	}
	
	// Methods
	private void constructBoard() {
		// Place NormalCell and BombCell randomly
		HashSet<Integer> bombPos = GameUtil.getRandomCellsPosition(
				getCellsAmount(),
				getBombsAmount());
		for(int i = 0; i < getBoardSize(); i++) {
			ArrayList<Cell> row = new ArrayList<Cell>();
			for(int j = 0; j < getBoardSize(); j++) {
				Cell cell;
				if(bombPos.contains((i * getBoardSize()) + j)) {
					cell = new BombCell(i, j, getCellSize(), this);
					getAllBombCells().add(cell);
				}
				else {
					cell = new NormalCell(i, j, getCellSize(), this);
				}
				row.add(cell);
				add(cell, j, i);
			}
			getAllCells().add(row);
		}
		
		// Place MysteryCell, ShieldCell and DefuserCell
		int specialCells = getMysteryAmount() + getShieldAmount() + getDefuserAmount();
		ArrayList<Integer> sequence = GameUtil.generateSequence(
				getMysteryAmount(), getShieldAmount(), getDefuserAmount());
		
		for(int i = 0; i < specialCells; i++) {
			Cell bombCell;
			ArrayList<Cell> adjCells;
			while(true) {
				bombCell = GameUtil.getRandomCell(getAllBombCells());
				adjCells = GameUtil.getAdjacentNormalCells(bombCell);
				if(!adjCells.isEmpty()) {
					break;
				}
			}
			Cell replaceCell = GameUtil.getRandomCell(adjCells);
			int type = sequence.get(i);
			replaceSpecialCell(replaceCell, type);
		}
	}
	
	public void resetBoard() {
		getChildren().clear();
		getAllCells().clear();
		getAllBombCells().clear();
		constructBoard();
	}
	
	private void replaceSpecialCell(Cell cell, int type) {
		int xPos = cell.getxPosition();
		int yPos = cell.getyPosition();
		getChildren().remove(cell);
		
		Cell specialCell = null;
		if(type == 0) {
			specialCell = new MysteryCell(xPos, yPos, getCellSize(), this);
		}
		if(type == 1) {
			specialCell = new ShieldCell(xPos, yPos, getCellSize(), this);
		}
		if(type == 2) {
			specialCell = new DefuserCell(xPos, yPos, getCellSize(), this);
		}
		getAllCells().get(xPos).set(yPos, specialCell);
		add(specialCell, yPos, xPos);
	}
	
	// Getters & Setters
	public ArrayList<ArrayList<Cell>> getAllCells() {
		return allCells;
	}
	
	public ArrayList<Cell> getAllBombCells() {
		return allBombCells;
	}

	public int getBoardSize() {
		return boardSize;
	}
	
	public double getCellSize() {
		return cellSize;
	}

	public int getCellsAmount() {
		return cellsAmount;
	}

	public int getBombsAmount() {
		return bombsAmount;
	}
	
	public int getMysteryAmount() {
		return mysteryAmount;
	}

	public int getShieldAmount() {
		return shieldAmount;
	}

	public int getDefuserAmount() {
		return defuserAmount;
	}

	public static int getStage() {
		return stage;
	}

	public static void setStage(int stage) {
		final int MIN_STAGE = 1;
		final int MAX_STAGE = 9;
		stage = Math.max(MIN_STAGE, stage);
		stage = Math.min(stage, MAX_STAGE);
		GamePane.stage = stage;
	}
}
