package state;

import bowling.FrameScore;
import bowling.Pins;

public class Strike implements State {

	@Override
	public State update(int pinsDown) {
		return this;
	}

	@Override
	public FrameScore getFrameScore() {
		return new FrameScore(new Pins(10));
	}

	@Override
	public boolean isFrameEnd() {
		return true;
	}

}
