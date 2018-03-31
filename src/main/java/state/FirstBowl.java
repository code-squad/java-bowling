package state;

import bowling.Pins;

public class FirstBowl extends State {
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
	public boolean canRollBonusBowl() {
		return false;
	}

	@Override
	public Pins getSecondRoll() {
		return null;
	}

	@Override
	public boolean isStrike() {
		return false;
	}
}
