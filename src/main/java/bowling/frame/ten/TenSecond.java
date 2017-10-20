package bowling.frame.ten;

import bowling.frame.state.State;

public class TenSecond implements State {
	private int first;
	private int second;

	public TenSecond(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public State bowl(int countOfPin) {
		if (isEnd()) {
			throw new UnsupportedOperationException();
		}
		return new TenThird(this.first, this.second, countOfPin);
	}

	@Override
	public boolean isEnd() {
		return first + second < 10;
	}
}
