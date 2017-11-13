package bowling.frame.state.nomalFrame;

import bowling.frame.state.State;

public class NomalFrameReady implements State {

	@Override
	public State bowl(int score) {
		if (score == 10) {
			return new NomalFrameStrike();
		}
		return new NomalFrameFirst(score);
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
