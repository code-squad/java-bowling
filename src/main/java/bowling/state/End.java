package bowling.state;

public abstract class End extends NomalUtil implements State {
	@Override
	public boolean isEnd() {
		return true;
	}

	@Override
	public State bowl(int score) {
		throw new IllegalArgumentException();
	}
}
