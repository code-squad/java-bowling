package bowling.frame;

import bowling.frame.state.End;
import bowling.frame.state.State;
import bowling.frame.state.normalframe.NormalFrameReady;
import bowling.frame.state.normalframe.NormalFrameSpare;
import bowling.frame.state.normalframe.NormalFrameStrike;

public class NormalFrame extends Frame {

	private State state;
	private Frame next;
	private int frameEndScore;

	private NormalFrame(int no) {
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
			frameEndScore += calculateScore(this, state);
			next = nextFrame();
			// next.frameEndScore = this.frameEndScore;
			return next;
		}
		return this;
	}

	private int calculateScore(NormalFrame nomalFrame, State state) {
		if (state instanceof NormalFrameStrike) {
			return spetialCalculateScore(nomalFrame, 2);
		}
		if (state instanceof NormalFrameSpare) {
			return spetialCalculateScore(nomalFrame, 1);
		}
		return state.getFinalScore();
	}

	private int spetialCalculateScore(NormalFrame nomalFrame, int count) {
		state = nomalFrame.getState();
		if (count == 0) {
			return state.getFinalScore();
		}
		return state.getFinalScore() + spetialCalculateScore(nomalFrame, count - 1);
	}

	@Override
	public State getState() {
		return state;
	}

	@Override
	public Frame getNext() {
		return next;
	}

	@Override
	public int getFrameEndScore() {
		return frameEndScore;
	}
}
