package bowling.frame.state.lastFrame;

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

}
