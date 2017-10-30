package bowling.frame;

import bowling.state.End;
import bowling.state.Ready;
import bowling.state.State;

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
}
