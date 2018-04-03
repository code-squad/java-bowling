package state;

import bowling.Pins;
import bowling.RollForTotal;

public class Normal implements State {
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
		return false;
	}

	@Override
	public RollForTotal needHowManyRoll() {
		return RollForTotal.ZEROROLL;
	}

	@Override
	public RollForTotal suplyHowManyRoll() {
		return RollForTotal.TWOROLL;
	}
}
