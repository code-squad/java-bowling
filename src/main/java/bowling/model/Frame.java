package bowling.model;

import bowling.model.state.State;

public abstract class Frame {
	State state;
	int no;

	abstract public Frame bowl(int knockedPins);

	abstract public int getScore();

	abstract public int getNo();

	abstract public String getKnockedPins();

	abstract public int getFirstScore();
}
