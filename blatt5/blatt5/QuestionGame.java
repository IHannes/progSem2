package blatt5;

import javax.swing.JOptionPane;
import java.lang.Class;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class QuestionGame{
protected Player player;
protected Game game;
protected GameDefinition gameDefinition;
private HighScore highScore;

public void gameLoop() throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
	while(true) {
		this.player = new Player(JOptionPane.showInputDialog("Geben Sie ihren Namen ein"));
		Class c = loadGameClass(JOptionPane.showInputDialog("Welches Spiel wollen Sie spielen?"));
		if(c.newInstance() instanceof Game) {
			game = (Game) c.newInstance();
		}
		else {
			continue;
		}
	}
}
public void createGameDefinition(String className) {
	
}

private static Class loadGameClass(String g) throws ClassNotFoundException {
	return Class.forName(g);
}
public static void main(String[] args) {
		QuestionGame qg = new QuestionGame();
		try {
			qg.gameLoop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
