package state;

import bowling.Pins;
import bowling.RollForTotal;

public class Strike implements State {
	@Override
	public State update(int pinsDown) {
		return this;
	}

	@Override
	public boolean isFinish() {
		return true;
	}
	
	@Override
	public boolean isStrike() {
		return true;
	}

	@Override
	public boolean canRollBonusBowl() {
		return true;
	}

	@Override
	public RollForTotal needHowManyRoll() {
		return RollForTotal.TWOROLL;
	}

	@Override
	public RollForTotal suplyHowManyRoll() {
		return RollForTotal.ONEROLL;
	}
}
