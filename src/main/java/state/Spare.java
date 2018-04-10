package state;

import bowling.FrameScore;
import bowling.Pins;

public class Spare implements State {

	Pins firstRoll;

	public Spare(Pins firstRoll) {
		this.firstRoll = firstRoll;
	}

	@Override
	public State update(int pinsDown) {
		return this;
	}

	@Override
	public FrameScore getFrameScore() {
		return new FrameScore(firstRoll, firstRoll.getRestPins());
	}

	@Override
	public boolean isFrameEnd() {
		return true;
	}

}
