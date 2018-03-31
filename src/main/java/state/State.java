package state;

import bowling.Pins;

public abstract class State {
	public static final int ALLDOWN = 10;

	public abstract State update(int pinsDown);
	
	public abstract boolean isFinish();
	
	public abstract boolean canRollBonusBowl();
	
	public abstract Pins getSecondRoll();
	
	public abstract boolean isStrike();
}
