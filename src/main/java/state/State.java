package state;

import bowling.Pins;

public interface State {
	public static final int ALLDOWN = 10;

	public abstract State update(int pinsDown);
	
	public abstract boolean isFinish();
	
	public abstract boolean isStrike();
	
	public abstract boolean canRollBonusBowl();
	
	public abstract int needHowManyRoll();
	
	public abstract int suplyHowManyRoll();
}
