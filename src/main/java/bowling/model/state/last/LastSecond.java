package bowling.model.state.last;

import bowling.model.state.EndState;
import bowling.model.state.State;

public class LastSecond extends EndState {
	private int firstScore;
	private int secondScore;
	private int sumScore;

	public LastSecond(int firstScore, int secondScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
		this.sumScore = firstScore + secondScore;
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
	
	@Override
	public String getKnockedPins() {
		return Integer.toString(firstScore) + "|" + Integer.toString(secondScore);
	}

	@Override
	public int getScore() {
		return firstScore + secondScore;
	}

	@Override
	public int getFirstScore() {
		return firstScore;
	}

	@Override
	public boolean calculateSumScore(int beforeSum) {
		sumScore += beforeSum;
		return true;
	}

	@Override
	public int getSumScore() {
		return sumScore;
	}
}
