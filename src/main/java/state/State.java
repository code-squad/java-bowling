package state;

import bowling.RollForTotal;

public interface State {
	public static final int ALLDOWN = 10;

	public abstract State update(int pinsDown);
	
	public abstract boolean isFinish();
	
	public abstract boolean isStrike();
	
	public abstract boolean canRollBonusBowl();
	
	public abstract RollForTotal needHowManyRoll();
	
	public abstract RollForTotal suplyHowManyRoll();
}
