package bowling.frame;

import bowling.frame.state.State;
import bowling.frame.state.lastframe.LastFrameReady;
import bowling.score.Score;

public class LastFrame extends Frame {

	private State state;
	private int frameEndScore;

	public LastFrame(int no) {
		super(no);
		state = new LastFrameReady();
	}

	public static Frame create(int no) {
		return new LastFrame(no);
	}

	@Override
	public Frame bowl(int score) {
		this.state = this.state.bowl(score);
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
