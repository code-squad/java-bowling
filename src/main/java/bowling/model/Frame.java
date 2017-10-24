package bowling.model;

import bowling.model.state.State;

public abstract class Frame {

	abstract public Frame bowl(int knockedPins);

	abstract public int getScore();

	abstract public int getNo();

	abstract public String getKnockedPins();

	abstract public int getFirstScore();

	abstract public String getSumScore();

	abstract public boolean isDone();

	abstract public void calculate(int beforeSum);

	abstract boolean calSpare(State beforeState, int beforeSum);

	abstract boolean calStrike(State beforeState, int beforeSum);

}
