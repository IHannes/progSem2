package blatt1;

import blatt1.support.Direction;

public class Point {
private int x;
private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Gibt X-Koordinate des Punktes zurück 
	 * @return X-Koordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gibt Y-Koordinate des Punktes zurück 
	 * @return Y-Koordinate
	 */
	public int getY() {
		// TODO
		return y;
	}

	/**
	 * Berechnet eine Verschiebung der aktuellen Position in die übergebene
	 * Bewegungsrichtung. Es wird eine neue Instanz von Point auf der neuen 
	 * Position zurück gegeben. Der neue Punkt ist genau ein Feld links
	 * 
	 * Die Koordinate (0, 0) stellt die linke obere Ecke des Spielfelds dar. 
	 * 
	 * @param d Bewegungsrichtung
	 * @return Neue berechnete Punkt- 
	 */
	public Point move(Direction d) {
		switch(d) {
		case UP : return new Point(x, y-1);
		case DOWN : return new Point(x, y+1);
		case LEFT : return new Point(x-1, y);
		case RIGHT : return new Point(x+1, y);
		}
		return null;
	}
	
	/**
	 * Prüft ob zwei Punkte gleich sind. Gleichheit besteht wenn X- und Y-Koordinate
	 * übereinstimmen.
	 */
	public boolean equals(Object o) {
		if(o instanceof Point) {
			Point point =(Point) o;
			if((point.getX() == x) && (point.getY() == y)) {
				return true;
			}
		}
		return false;
	}
}
