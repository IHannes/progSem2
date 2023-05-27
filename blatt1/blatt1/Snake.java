package blatt1;

import blatt1.support.Direction;

public class Snake {
	private List snake;
	private Direction direction;
	private boolean extendBody = false;
	
	public Snake(Point location, Direction direction) {
			snake = new List();
			snake.pushFront(new SnakePart(location));
			this.direction = direction;
	}
	
	public void extendBody() {
		extendBody = true;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Direction getDirection() { return this.direction; }
	
	public void moveSnake() {
		SnakePart newHead = new SnakePart(getNextHeadLocation());
		snake.pushFront(newHead);
		if(!extendBody) {
		snake.popBack();
		}
		extendBody = false;
	}

	public Point getHeadLocation() {
		return ((SnakePart)snake.getFront()).location;
	}
	
	public Point getNextHeadLocation() {
		return ((SnakePart)snake.getFront()).location.move(direction);
	}
	
	public boolean hasBody(Point loc) {
		for(int i = 1; i < snake.length(); ++i) {
			if(((SnakePart)snake.get(i)).location.equals(loc))
				return true;
		}
		return false;
	}
}

class SnakePart {
	public SnakePart(Point location) { this.location = location;}
	Point location;
	
}