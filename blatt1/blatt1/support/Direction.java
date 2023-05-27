package blatt1.support;

import java.util.Random;

public enum Direction {
	UP, DOWN, LEFT, RIGHT;

	private static Random rand = new Random();
	
	public static Direction getRandomDirection() {
		return Direction.values()[rand.nextInt(Direction.values().length)];
	}
}
