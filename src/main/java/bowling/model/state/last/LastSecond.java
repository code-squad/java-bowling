package bowling.model.state.last;

import bowling.model.state.State;

public class LastSecond implements State {
	private int firstScore;
	private int secondScore;

	public LastSecond(int firstScore, int secondScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}

	@Override
	public State bowl(int knockedPins) {
		if (isEnd()) {
			throw new UnsupportedOperationException();
		}
		return new LastThird(firstScore, secondScore, knockedPins);
	}

	@Override
	public boolean isEnd() {
		return firstScore + secondScore < 10;
	}
}
