package bowling.frame;

public abstract class EndState implements State {
	@Override
	public State bowl(int countOfPin) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEnd() {
		return true;
	}
}
