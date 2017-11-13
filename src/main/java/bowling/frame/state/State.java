package bowling.frame.state;

public interface State {
	public State bowl(int score);

	public String getPresentScore();
}
