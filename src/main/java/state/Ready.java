package state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.Pins;

public class Ready extends State {
	@Override
	public State update(int pinsDown) {
		if (pinsDown == State.ALLDOWN) {
			return new Strike();
		}
		return new FirstBowl();
	}

	@Override
	public Pins getSecondRoll() {
		return null;
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
	public boolean isStrike() {
		return false;
	}
}
