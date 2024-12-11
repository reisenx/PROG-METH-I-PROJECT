package control;

import cell.BombCell;
import cell.Cell;
import cell.NormalCell;
import cell.SpecialCell;
import pane.GamePane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class GameUtil {
	
	// Random numbers for assigning BombCell
	public static HashSet<Integer> getRandomCellsPosition(int range, int amount) {
		HashSet<Integer> randomNumbers = new HashSet<Integer>();
		Random rand = new Random();
		if(amount > range) {
			return randomNumbers;
		}
		
		while(randomNumbers.size() < amount) {
			randomNumbers.add(rand.nextInt(range));
		}
		return randomNumbers;
	}
	
	// Random a cell from the ArrayList
	public static Cell getRandomCell(ArrayList<Cell> allCells) {
		Random rand = new Random();
		int randInt = rand.nextInt(allCells.size());
		return allCells.get(randInt);
	}
	
	// Random multiple cells from the ArrayList
	public static ArrayList<Cell> getRandomMultipleCells(ArrayList<Cell> allCells, int amount) {
		ArrayList<Cell> randomCells = new ArrayList<Cell>();
		if(amount > allCells.size()) {
			return randomCells;
		}
		
		HashSet<Integer> randomPosition = getRandomCellsPosition(allCells.size(), amount);
		for(int idx : randomPosition) {
			randomCells.add(allCells.get(idx));
		}
		return randomCells;
	}
	
	// Generate sequence for assigning MysteryCell, ShieldCell and DefuserCell
	public static ArrayList<Integer> generateSequence(int mystery, int shield, int defuser) {
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		for(int i = 0; i < mystery; i++) {
			sequence.add(0);
		}
		for(int i = 0; i < shield; i++) {
			sequence.add(1);
		}
		for(int i = 0; i < defuser; i++) {
			sequence.add(2);
		}
		Collections.shuffle(sequence);
		return sequence;
	}
	
	// Get all adjacent cells of the current cell
	public static ArrayList<Cell> getAdjacentCells(Cell cell) {
		final int MIN_OFFSET = -1;
		final int MAX_OFFSET = 1;
		
		int xPos = cell.getxPosition();
		int yPos = cell.getyPosition();
		GamePane board = cell.getBoard();
		ArrayList<ArrayList<Cell>> allCells = board.getAllCells();
		
		ArrayList<Cell> adjacentCells = new ArrayList<Cell>();
		for(int dx = MIN_OFFSET; dx <= MAX_OFFSET; dx++) {
			for(int dy = MIN_OFFSET; dy <= MAX_OFFSET; dy++) {
				// Do not include the current cell
				if(dx == 0 && dy == 0) {
					continue;
				}
				// Get adjacent cell position
				int adjXPos = xPos + dx;
				int adjYPos = yPos + dy;
				if(isValidCell(adjXPos, adjYPos, board)) {
					Cell currentCell = allCells.get(adjXPos).get(adjYPos);
					adjacentCells.add(currentCell);
				}
			}
		}
		return adjacentCells;
	}
	
	// Get all normal adjacent cells of the current cell
	public static ArrayList<Cell> getAdjacentNormalCells(Cell cell) {
		ArrayList<Cell> adjacentNormalCells = getAdjacentCells(cell);
		adjacentNormalCells.removeIf(adjCell -> !(adjCell instanceof NormalCell));
		return adjacentNormalCells;
	}
	
	// Get all not flagged cell in the ArrayList
	public static ArrayList<Cell> getUnflaggedCells(ArrayList<Cell> allCells) {
		ArrayList<Cell> unflaggedCells = allCells;
		unflaggedCells.removeIf(cell -> cell.isFlagged());
		return unflaggedCells;
	}
	
	// Count bombs on adjacent cells
	public static int countBomb(Cell cell) {
		int count = 0;
		ArrayList<Cell> adjacentCells = getAdjacentCells(cell);
		for(Cell currentCell : adjacentCells) {
			if(currentCell instanceof BombCell) {
				count++;
			}
		}
		return count;
	}
	
	// Count special on adjacent cells
	public static int countSpecial(Cell cell) {
		int count = 0;
		ArrayList<Cell> adjacentCells = getAdjacentCells(cell);
		for(Cell currentCell : adjacentCells) {
			if(currentCell instanceof SpecialCell) {
				count++;
			}
		}
		return count;
	}
	
	// Check if the bomb is valid
	public static boolean isValidCell(int x, int y, GamePane board) {
		int boardSize = board.getBoardSize();
		// Validate cell position
		if(x < 0 || y < 0 || x >= boardSize || y >= boardSize) {
			return false;
		}
		return true;
	}
}
