package bowling.frame.state;

public abstract class Running implements State {

	abstract public State bowl(int score);

	public abstract String getPresentScore();

}
