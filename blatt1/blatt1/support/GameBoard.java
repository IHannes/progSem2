package blatt1.support;

import blatt1.Point;

public interface GameBoard {

	/**
	 * Es gibt eine Stelle auf dem Spielfeld, auf dem das Futter der
	 * Schlage zu finden ist. Diese Methode sucht eine zufällige Leere
	 * Stelle an der das Futter zu finden ist und merkt sich diese. (Hinweis: 
	 * das Interface bietet weiter unten die Methode getFieldContent, mit
	 * der zu einer Position identifiziert werden kann ob sie leer ist
	 */
	void setRandomFoodPosition();

	/**
	 * Gibt Anzahl von Zeilen auf Spielfeld zurück 
	 * 
	 * @return Anzahl Zeilen im Spielfeld
	 */
	int getRows();

	/**
	 * Gibt Anzahl von Spalten auf Spielfeld zurück 
	 * 
	 * @return Anzahl Spalten im Spielfeld
	 */
	int getCols();

	/**
	 * Anzahl der Punkte die der Spieler gerade hat
	 * 
	 * @return
	 */
	int getCurrentPoints();

	/**
	 * Maximale Anzahl von Punkten, die der Spiel jemals hatte
	 * @return
	 */
	int getMaxPoints();

	/**
	 * Bewegt die Schlage um eine Position auf dem Spielfeld weiter. 
	 * Diese Methode führt folgende Aktionen durch:
	 * 
	 * 1.) Wenn eine neue Richtung mit newDirection übergeben wurde
	 *     (ansonsten ist der übergebene Wert null), dann wird diese
	 *     mittels der Methode "setDirection()" an die Schlage weitergegeben
	 * 2.) Es wird bestimmt welches die neue Position der Schlange nach 
	 *     der Bewegung sein soll
	 * 3.) Prüfen Sie ob die Schlange über die Spielfeldgrenze laufen würde. 
	 *     Falls ja: ersetzen Sie das Schlangen-Objekt mit einer neuen Instanz
	 *     die auf der alten Position ist (die Schlage ist dadurch automatisch
	 *     wieder nur ein Feld lang). Setzen Sie die Punkte des Spielers auf 
	 *     0 (speichern sie davor ggf. einen neuen Höchststand
	 * 4.) Prüfen Sie ob die Schlange sich selbst gebissen hat. Falls ja: 
	 *     ersetzen Sie das Schlangen-Objekt mit einer neuen Instanz, die auf 
	 *     der alten Position ist (die Schlage ist dadurch automatisch wieder 
	 *     nur ein Feld lang). Setzen Sie die Punkte des Spielers auf 
	 *     0 (speichern sie davor ggf. einen neuen Höchststand
	 * 5.) Prüfen Sie, ob die Schlage Nahrung gefunden hat. Falls ja, dann 
	 *     verlängern Sie die Schlange durch den Aufruf Ihrer extendBody()-Methode
	 *     und erhöhen Sie den Punktestand um einen Punkt
	 * 6.) Bewegen Sie die Schlange mittels ihrer moveSnake()-Methode weiter 
	 * 
	 * @param newDirection Neue Bewegungsrichtung für Schlage; null wenn die bisherige Richtung beibehalten werden soll.
	 */
	void moveSnake(Direction newDirection);

	/**
	 * Gibt an welche Spielfigur (FOOD, SNAKEHEAD, SNAKEBODY, EMPTY) auf dem 
	 * Spielfeld an der übergebenen Position zu finden ist.
	 * 
	 * @param location Position auf dem Spielfeld
	 * @return Spielfigur an der Stelle des Spielfelds
	 */
	FieldType getFieldContent(Point location);

	/**
	 * Gibt die aktuelle Bewegungsrichtung der Schlange zurück 
	 * @return Aktuelle Bewegungsrichtung
	 */
	Direction getCurrentSnakeDirection();

}