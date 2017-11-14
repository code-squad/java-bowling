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

	public NormalFrame(int no, int frameScore) {
		super(no, frameScore);
		state = new NormalFrameReady();
	}

	public static Frame create(int no, int frameScore) {
		return new NormalFrame(no, frameScore);
	}

	@Override
	public Frame bowl(int score) {
		state = this.state.bowl(score);
		if (state instanceof End) {
			frameEndScore = getBeforeFrameScore() + calculateScore(this, state);
			next = nextFrame(frameEndScore);
			return next;
		}
		return this;
	}

	private int calculateScore(NormalFrame nowFrame, State state) {
		try {
			if (state instanceof NormalFrameStrike) {
				return spetialCalculateScore(nowFrame, 2);
			}
			if (state instanceof NormalFrameSpare) {
				return spetialCalculateScore(nowFrame, 1);
			}
		} catch (NullPointerException e) {
			return 0;
		}
		return state.getFinalScore();
	}

	private int spetialCalculateScore(NormalFrame nowFrame, int count) throws NullPointerException {
		state = nowFrame.getState();
		if (count == 0) {
			return state.getFinalScore();
		}
		nowFrame = (NormalFrame) nowFrame.getNext();
		return state.getFinalScore() + spetialCalculateScore(nowFrame, count - 1);
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
