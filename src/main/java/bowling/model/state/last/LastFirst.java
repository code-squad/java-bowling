package bowling.model.state.last;

import bowling.model.state.State;

public class LastFirst implements State {

	private int score;

	public LastFirst(int score) {
		this.score = score;
	}

	@Override
	public State bowl(int knockedPins) {
		return new LastSecond(this.score, knockedPins);
	}

	@Override
	public boolean isEnd() {
		return false;
	}
	
	@Override
	public String getKnockedPins() {
		return Integer.toString(score);
	}

	@Override
	public int getFirstScore() {
		return score;
	}
}
