package state;

import bowling.Pins;

public class FirstBowl implements State {
	@Override
	public State update(int pinsDown) {
		if (pinsDown == State.ALLDOWN) {
			return new Spare();
		}
		return new Normal();
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
	public int needHowManyRoll() {
		return 0;
	}

	@Override
	public int suplyHowManyRoll() {
		return 1;
	}
}
