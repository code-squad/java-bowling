package state;

import bowling.Pins;

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
	public int needHowManyRoll() {
		return 2;
	}

	@Override
	public int suplyHowManyRoll() {
		return 1;
	}
}
