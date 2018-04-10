package state;

import bowling.FrameScore;
import bowling.Pins;

public class NormalFrame implements State {
	
	Pins firstRoll;
	Pins secondRoll;

	public NormalFrame(Pins firstRoll, int pinsDown) {
		this.firstRoll = firstRoll;
		this.secondRoll = new Pins(pinsDown);
	}

	@Override
	public State update(int pinsDown) {
		return this;
	}

	@Override
	public FrameScore getFrameScore() {
		return new FrameScore(firstRoll, secondRoll);
	}

	@Override
	public boolean isFrameEnd() {
		return true;
	}

}
