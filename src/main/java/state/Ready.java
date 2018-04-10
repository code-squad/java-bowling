package state;

import bowling.Frame;
import bowling.FrameScore;
import bowling.Pins;

public class Ready implements State {

	@Override
	public State update(int pinsDown) {
		if (pinsDown == Pins.MAX) {
			return new Strike();
		}
		return new NormalRoll(pinsDown);
	}

	@Override
	public FrameScore getFrameScore() {
		return null;
	}

	@Override
	public boolean isFrameEnd() {
		return false;
	}

}
