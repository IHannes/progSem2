package blatt1;


import java.util.Random;

import blatt1.support.Direction;
import blatt1.support.FieldType;
import blatt1.support.GameBoard;

public class GameBoardImpl implements GameBoard{
	private int coloms;
	private int rows;
	private Point foodPosition;
	Snake snake;
	private int currentPoints;
	private int maxPoints;
	
//	public static void main(String[] args) {
//		System.out.println(generateRandom(1,20));
//	}
	public GameBoardImpl(int coloms, int rows) {
		int a = generateRandom(0, rows);
		int b = generateRandom(0, coloms);
		this.coloms = coloms;
		this.rows = rows;
		this.snake = new Snake(new Point(a, b), Direction.getRandomDirection());
		setRandomFoodPosition();
	}
	
	@Override
	public void setRandomFoodPosition() {
		int a = generateRandom(0, coloms);
		int b = generateRandom(0, rows);
		if(a!=snake.getHeadLocation().getY() || b!=snake.getHeadLocation().getX()) {
			foodPosition = new Point(a,b);
		}
		
	}
	
	private static int generateRandom(int min, int max) {
		Random rand = new Random();
		int i = min+rand.nextInt(max-min);
		return i;
	}
	
//	public void moveToFood() {
//		Point p = snake.getHeadLocation();
//		Direction d = Direction.getRandomDirection();
//		
//		if(foodPosition.getX() == p.getX()) {
//			if(foodPosition.getY() >= p.getY()) { 
//				d = Direction.DOWN;
//			} else { 
//				d = Direction.UP;
//			}
//		}
//		else {
//			if(foodPosition.getX() > p.getX()) {
//				d = Direction.RIGHT;
//			} else { 
//				d = Direction.LEFT;
//			}
//		}
//		snake.setDirection(d);
//		
//		int i = 0;
//		while( i< Direction.values().length && getFieldContent(snake.getNextHeadLocation()) == FieldType.SNAKEBODY) {
//			snake.setDirection(Direction.values()[i++]);
//		}
//	}

	@Override
	public int getRows() {
		return rows;
	}

	@Override
	public int getCols() {
		return coloms;
	}

	@Override
	public int getCurrentPoints() {
		return currentPoints;
	}

	@Override
	public int getMaxPoints() {
		return maxPoints;
	}

	@Override
	public void moveSnake(Direction newDirection) {
//		switch(newDirection) {
		if(newDirection != null) 
			snake.setDirection(newDirection);
	
//		case UP :  snake. = new Point(this.currentPosition.getX(), this.currentPosition.getY()+1);
//		case DOWN : currentPosition = new Point(this.currentPosition.getX(), this.currentPosition.getY()-1);
//		case RIGHT : currentPosition = new Point(this.currentPosition.getX()+1, this.currentPosition.getY());
//		case LEFT : currentPosition = new Point(this.currentPosition.getX()-1, this.currentPosition.getY());
//		}
		
		//moveToFood();
		
		Point curLocation = snake.getHeadLocation();
		Point nextLocation = snake.getNextHeadLocation();
		
		if(nextLocation.getX() < 0 || nextLocation.getX() >=coloms || nextLocation.getY() < 0 || nextLocation.getY() >= rows) {
			int a = generateRandom(0, rows);
			int b = generateRandom(0, coloms);
			snake = new Snake(new Point(a, b), Direction.getRandomDirection());
			if(maxPoints < currentPoints)
				maxPoints = currentPoints;
			currentPoints = 0;
			return;
		}

		FieldType targetFieldContent = getFieldContent(nextLocation);
		switch (targetFieldContent) {
		case FOOD:
			snake.extendBody();
			snake.moveSnake();
			setRandomFoodPosition();
			currentPoints++;
			break;
		case SNAKEHEAD :
		case SNAKEBODY : 
			snake = new Snake(nextLocation, snake.getDirection());
			break;
		case EMPTY:
			snake.moveSnake();
			break;
		}
	}
	
	
	public FieldType getFieldContent(Point location) {
		if (location.equals(snake.getHeadLocation()))
			return FieldType.SNAKEHEAD;
		if (location.equals(foodPosition))
			return FieldType.FOOD;
		if (snake.hasBody(location))
			return FieldType.SNAKEBODY;
		return FieldType.EMPTY;
	}

	@Override
	public Direction getCurrentSnakeDirection() {
		return snake.getDirection();
	}
}
