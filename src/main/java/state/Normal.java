package state;

import bowling.Pins;

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
	public int needHowManyRoll() {
		return 0;
	}

	@Override
	public int suplyHowManyRoll() {
		return 2;
	}
}
