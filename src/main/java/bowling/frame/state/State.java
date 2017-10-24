package bowling.frame.state;

public interface State {
	boolean isEnd();

	int getFristScore();

	int getSecondScore();

	State bowl(int score);

	String getChar();
}
