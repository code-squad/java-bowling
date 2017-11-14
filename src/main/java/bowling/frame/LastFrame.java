package bowling.frame;

import bowling.frame.state.BowlingEnd;
import bowling.frame.state.State;
import bowling.frame.state.lastframe.LastFrameReady;

public class LastFrame extends Frame {

	private State state;
	private int frameEndScore;

	public LastFrame(int no, int frameScore) {
		super(no, frameScore);
		state = new LastFrameReady();
	}

	public static Frame create(int no, int frameScore) {
		return new LastFrame(no, frameScore);
	}

	@Override
	public Frame bowl(int score) {
		this.state = this.state.bowl(score);
		if (state instanceof BowlingEnd) {
			frameEndScore = getBeforeFrameScore() + state.getFinalScore();
		}
		return this;
	}

	@Override
	public State getState() {
		return state;
	}

	@Override
	public Frame getNext() {
		return null;
	}

	@Override
	public int getFrameEndScore() {
		return frameEndScore;
	}
}
