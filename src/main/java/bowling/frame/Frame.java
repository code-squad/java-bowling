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
			return next = new Frame(no + 1);
		}
		return this;
	}

	public Frame getNext() {
		return next;
	}

	public int calc(Frame frame, int count) {
		Score score = new Score();
		if (frame.getState() instanceof Strike) {
			return score.calc(frame, 2);
		}
		if (frame.getState() instanceof Spare) {
			return score.calc(frame, 1);
		}
		return score.calc(frame, 0);
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

	public int calc() {
		Score score = new Score();
		if (state instanceof Strike) {
			return score.calc(this, 2);
		}
		if (state instanceof Spare) {
			return score.calc(this, 1);
		}
		return score.calc(this, 0);
	}
}
