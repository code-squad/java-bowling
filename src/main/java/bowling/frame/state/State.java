package bowling.frame.state;

public interface State {

	State bowl(int bowls);

	boolean isEnd();

	String getChar();

	int getEachFinalFrameScore();

	int getFirstScore();
}
