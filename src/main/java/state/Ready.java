package state;

import bowling.RollForTotal;

public class Ready implements State {
	@Override
	public State update(int pinsDown) {
		if (pinsDown == State.ALLDOWN) {
			return new Strike();
		}
		return new FirstBowl();
	}

	@Override
	public boolean isFinish() {
		return false;
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
		return RollForTotal.ZEROROLL;
	}
}
