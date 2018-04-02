package state;

import bowling.Pins;

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
	public int needHowManyRoll() {
		return 1;
	}

	@Override
	public int suplyHowManyRoll() {
		return 2;
	}
}
