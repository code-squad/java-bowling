package bowling.frame.state.lastFrame;

import bowling.frame.state.Running;
import bowling.frame.state.State;

public class LastFrameStrike extends Running {

	private final int STRIKE_SCORE = 10;

	@Override
	public State bowl(int score) {
		return new Bonuce(STRIKE_SCORE, score);
	}

	@Override
	public String getPresentScore() {
		return "X";
	}

}
