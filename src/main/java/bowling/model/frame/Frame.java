package bowling.model.frame;

import bowling.model.state.State;

public abstract class Frame {
	int no;
	boolean isDone;

	public int getNo() {
		return no;
	}

	public boolean isDone() {
		return isDone;
	}

	abstract public Frame bowl(int knockedPins);

	abstract public int getScore();

	abstract public String getKnockedPins();

	abstract public int getFirstScore();

	abstract public String getSumScore();

	abstract public boolean calculate(int beforeSum);

	abstract boolean calSpare(State beforeState, int beforeSum);

	abstract boolean calStrike(State beforeState, int beforeSum);

	abstract public boolean isEndState();

}
