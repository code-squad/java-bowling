package bowling.frame;

import bowling.exception.BowlingException;
import bowling.frame.state.State;

public abstract class Frame {

	protected int no;
	protected State state;
	private int firstScore;
	private int secondScore;

	public State bowl(int score) {
		if (score > 10) {
			throw new BowlingException();
		}
		state = state.bowl(score);
		this.firstScore = state.getFristScore();
		this.secondScore = state.getSecondScore();
		return state;
	}

	public State getState() {
		return state;
	}

	public int getFirstScore() {
		return firstScore;
	}

	public int getSecondScore() {
		return secondScore;
	}

	public int getEndScore() {
		return this.firstScore + this.secondScore;
	}

	public boolean isEnd() {
		return state.isEnd();
	}

	public static Frame create(int size) {
		return size != 9 ? new NomalFrame() : new LastFrame();
	}
}
