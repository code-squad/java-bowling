package state;

import bowling.Pins;

public abstract class FrameDone extends State {
	
	@Override
	public boolean isFinish() {
		return true;
	}
	
	@Override
	public boolean canRollBonusBowl() {
		return true;
	}
	
	@Override
	public boolean isStrike() {
		return false;
	}
}
