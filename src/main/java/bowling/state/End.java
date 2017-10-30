package bowling.state;

public abstract class End extends 아뭘로하지 implements State {
	@Override
	public boolean isEnd() {
		return true;
	}

	@Override
	public State bowl(int score) {
		throw new IllegalArgumentException();
	}
}
