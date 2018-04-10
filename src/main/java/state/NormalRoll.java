package state;

import bowling.Frame;
import bowling.FrameScore;
import bowling.Pins;

public class NormalRoll implements State {

	Pins firstRoll;

	public NormalRoll(int pinsDown) {
		this.firstRoll = new Pins(pinsDown);
	}

	@Override
	public State update(int pinsDown) {
		if (getPinsDown() + pinsDown == Pins.MAX) {
			return new Spare(firstRoll);
		}
		return new NormalFrame(firstRoll, pinsDown);
	}

	@Override
	public FrameScore getFrameScore() {
		return new FrameScore(firstRoll);
	}

	@Override
	public boolean isFrameEnd() {
		return false;
	}

	public int getPinsDown() {
		return firstRoll.getPinsDown();
	}

}
