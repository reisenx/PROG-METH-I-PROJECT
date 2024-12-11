package control;

public class GameConfig {
	public static final int[] GRID_SIZE = {
			9,9,9,
			16,16,16,
			25,25,25
	};
	public static final int[] CELLS = {
			81,81,81,
			256,256,256,
			625,625,625
	};
	public static final double[] CELL_SIZE = {
			80,80,80,
			45,45,45,
			28.8,28.8,28.8
	};
	public static final int[] BOMBS = {
			10,10,10,
			40,40,40,
			120,120,120
	};
	public static final int[] MYSTERY = {
			0,7,8,
			0,12,14,
			0,20,23
	};
	public static final int[] SHIELD = {
			1,1,0,
			2,2,0,
			3,3,0
	};
	public static final int[] DEFUSER = {
			1,0,0,
			2,0,0,
			3,0,0
	};
}
