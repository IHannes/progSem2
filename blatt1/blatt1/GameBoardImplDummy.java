package blatt1;

import blatt1.support.Direction;
import blatt1.support.FieldType;
import blatt1.support.GameBoard;

public class GameBoardImplDummy implements GameBoard {

	@Override
	public void setRandomFoodPosition() {

	}

	@Override
	public int getRows() {
		return 10;
	}

	@Override
	public int getCols() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public int getCurrentPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void moveSnake(Direction newDirection) {

	}

	@Override
	public FieldType getFieldContent(Point location) {
		if (location.equals(new Point(0,0)))
			return FieldType.SNAKEHEAD;
		if (location.equals(new Point(3, 3)))
			return FieldType.FOOD;
		return FieldType.EMPTY;
	}

	@Override
	public Direction getCurrentSnakeDirection() {
		return Direction.getRandomDirection();
	}

}
