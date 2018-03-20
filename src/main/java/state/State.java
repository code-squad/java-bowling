package state;

import bowling.Pins;

public abstract class State {
	protected Pins firstRoll;
	protected Pins secondRoll;

//	public abstract boolean isFinish();
	
	public int getFirstRoll() {
		return firstRoll.getPinsDown();
	}

	public int getSecondRoll() {
		return secondRoll.getPinsDown();
	}
}
