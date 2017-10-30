package bowling.state;

public interface State {

	boolean isEnd();

	int getFirstBowlScore();

	int getSecondBowlScore();

	State bowl(int score);

	int getScore();

	String getChar();
}
