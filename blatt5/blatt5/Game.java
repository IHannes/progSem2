package blatt5;

public interface Game {
public boolean hasMoreQuestions();
public String nextQuestion();
public boolean recordAnswer(String answer);
public int getPoints();
}
