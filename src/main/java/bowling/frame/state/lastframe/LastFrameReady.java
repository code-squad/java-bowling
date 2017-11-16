package bowling.frame.state.lastframe;

import bowling.frame.state.State;

public class LastFrameReady implements State {

	@Override
	public State bowl(int score) {
		if (score == 10) {
			return new LastFrameStrike();
		}
		return new LastFrameFirst(score);
	}

	@Override
	public String getPresentScore() {
		return "      |";
	}

	@Override
	public int getFinalScore() {
		return 0;
	}

	@Override
	public int getFirstScore() {
		return 0;
	}

	@Override
	public int getSecondScore() {
		return 0;
	}

}
