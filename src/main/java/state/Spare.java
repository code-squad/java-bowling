package state;

import bowling.Pins;
import bowling.RollForTotal;

public class Spare implements State {
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
		return false;
	}

	@Override
	public boolean canRollBonusBowl() {
		return true;
	}

	@Override
	public RollForTotal needHowManyRoll() {
		return RollForTotal.ONEROLL;
	}

	@Override
	public RollForTotal suplyHowManyRoll() {
		return RollForTotal.TWOROLL;
	}
}
