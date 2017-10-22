package bowling.model.state.last;

import bowling.model.state.State;

public class LastReady implements State {

	@Override
	public State bowl(int knockedPins) {
		return new LastFirst(knockedPins);
	}

	@Override
	public boolean isEnd() {
		return false;
	}
}
