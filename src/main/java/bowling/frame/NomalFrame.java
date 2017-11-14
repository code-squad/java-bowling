package bowling.frame;

import bowling.frame.state.End;
import bowling.frame.state.State;
import bowling.frame.state.nomalFrame.NomalFrameReady;
import bowling.frame.state.nomalFrame.NomalFrameSpare;
import bowling.frame.state.nomalFrame.NomalFrameStrike;

public class NomalFrame extends Frame {

	private NomalFrame(int no) {
		this.no = no;
		this.state = new NomalFrameReady();
	}

	public static Frame create(int no) {
		return new NomalFrame(no);
	}

	@Override
	public Frame bowl(int score) {
		this.state = this.state.bowl(score);
		if (this.state instanceof End) {
			this.frameEndScore += calculateScore(this, state);
			this.next = Frame.createFrame(no + 1);
			this.next.frameEndScore = this.frameEndScore;
			return next;
		}
		return this;
	}

	private int calculateScore(NomalFrame nomalFrame, State state) {
		if (state instanceof NomalFrameStrike) {
			return spetialCalculateScore(nomalFrame, 2);
		}
		if (state instanceof NomalFrameSpare) {
			return spetialCalculateScore(nomalFrame, 1);
		}
		return state.getFinalScore();
	}

	private int spetialCalculateScore(NomalFrame nomalFrame, int count) {
		state = nomalFrame.getState();
		if (count == 0) {
			return state.getFinalScore();
		}
		return state.getFinalScore() + spetialCalculateScore(nomalFrame, count - 1);
	}
}
