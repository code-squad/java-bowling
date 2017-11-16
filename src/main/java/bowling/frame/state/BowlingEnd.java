package bowling.frame.state;

public abstract class BowlingEnd implements State {
	@Override
	public State bowl(int score) {
		throw new IllegalArgumentException("");
	}
}
