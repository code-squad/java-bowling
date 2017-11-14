package bowling.frame;

import bowling.frame.state.BowlingEnd;
import bowling.frame.state.State;
import bowling.frame.state.lastframe.LastFrameReady;

public class LastFrame extends Frame {

	private State state;
	private int frameEndScore;

	private LastFrame(int no) {
		super(no);
		state = new LastFrameReady();

	}

	public static Frame create(int no) {
		return new LastFrame(no);
	}

	@Override
	public Frame bowl(int score) {
		this.state = this.state.bowl(score);
		if (state instanceof BowlingEnd) {
			frameEndScore += state.getFinalScore();
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
