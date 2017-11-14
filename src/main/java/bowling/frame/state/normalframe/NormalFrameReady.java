package bowling.frame.state.normalframe;

import bowling.frame.state.State;

public class NormalFrameReady implements State {

	@Override
	public State bowl(int score) {
		if (score == 10) {
			return new NormalFrameStrike();
		}
		return new NormalFrameFirst(score);
	}

	@Override
	public String getPresentScore() {
		return "     | ";
	}

	@Override
	public int getFinalScore() {
		return 0;
	}
}
