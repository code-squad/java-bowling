package bowling.frame.ten;

import bowling.frame.state.State;

public class TenReady implements State {

	@Override
	public State bowl(int countOfPin) {
		return new TenFirst(countOfPin);
	}

	@Override
	public boolean isEnd() {
		return false;
	}

}
