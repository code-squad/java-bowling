package bowling.frame;

import bowling.frame.state.End;
import bowling.frame.state.State;
import bowling.frame.state.normalframe.NormalFrameReady;

public class NormalFrame extends Frame {

	private State state;
	private Frame next;

	public NormalFrame(int no) {
		super(no);
		state = new NormalFrameReady();
	}

	public static Frame create(int no) {
		return new NormalFrame(no);
	}

	@Override
	public Frame bowl(int score) {
		state = this.state.bowl(score);
		if (state instanceof End) {
			next = nextFrame();
			return next;
		}
		return this;
	}

	@Override
	public State getState() {
		return state;
	}

	@Override
	public Frame getNext() {
		return next;
	}
}
