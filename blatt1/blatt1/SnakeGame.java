package blatt1;

import blatt1.support.GameBoard;
import blatt1.support.SnakePlayground;

public class SnakeGame {
	public static final int STEP_DELAY = 200;
	public static final int SIZE_COLS = 20;
	public static final int SIZE_ROWS = 20;
	
	public static void main(String[] args) {
		GameBoard gameBoard;
		
		// TODO: Ersetzen Sie dies mit ihrer Implementierung des Interfaces GameBoard
//		gameBoard = new GameBoardImplDummy();
		gameBoard = new GameBoardImpl(SIZE_COLS, SIZE_ROWS);
		
		SnakePlayground playground = new SnakePlayground(gameBoard, STEP_DELAY);
		playground.setSize(800, 600);
		playground.setVisible(true);
	}
}
