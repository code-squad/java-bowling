package bowling.model.state;

public class EndState implements State {

	@Override
	public State bowl(int knockedPins) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEnd() {
		return true;
	}
}
