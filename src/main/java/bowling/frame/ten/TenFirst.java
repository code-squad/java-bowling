package bowling.frame.ten;

import bowling.frame.state.State;

public class TenFirst implements State {
	private int first;

	public TenFirst(int countOfPin) {
		this.first = countOfPin;
	}

	@Override
	public State bowl(int countOfPin) {
		return new TenSecond(this.first, countOfPin);
	}

	@Override
	public boolean isEnd() {
		return false;
	}

}
