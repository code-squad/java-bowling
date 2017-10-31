package bowling.frame;

import bowling.score.Score;
import bowling.state.End;
import bowling.state.Ready;
import bowling.state.Spare;
import bowling.state.State;
import bowling.state.Strike;

public class Frame {

	private int no;
	private State state;
	private Frame next;
	private int continueScore;

	public Frame(int no) {
		this.no = no;
		state = new Ready();
	}

	public int getNo() {
		return no;
	}

	public Frame bowl(int score) {
		this.state = state.bowl(score);
		if (state instanceof End) {
			no += 1;
			if (no < 10) {
				return next = new NomalFrame(no);
			}
			return next = new LastFrame(no);
		}
		return this;
	}

	public Frame getNext() {
		return next;
	}

	public int getScore() {
		return state.getScore();
	}

	public int getFirstScore() {
		return state.getFirstBowlScore();
	}

	public int getSecondScore() {
		return state.getSecondBowlScore();
	}

	public State getState() {
		return state;
	}

	public Frame getFrame() {
		return this;
	}

	public String getChar() {
		return state.getChar();
	}

	// public List<FrameResult> createFrameResults() {
	// List<FrameResult> result = new ArrayList<>();
	// return result.add(FrameResult.add(calc()));
	// }

	public int calc() {
		Score scores = new Score();
		if (state instanceof Strike) {
			return scores.calc(continueScore, this, 2);
		}
		if (state instanceof Spare) {
			return scores.calc(continueScore, this, 1);
		}
		return scores.calc(continueScore, this, 0);
	}
}
