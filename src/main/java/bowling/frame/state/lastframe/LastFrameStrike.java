package bowling.frame.state.lastframe;

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

	@Override
	public int getFirstScore() {
		return 10;
	}

	@Override
	public int getSecondScore() {
		return 0;
	}

}
