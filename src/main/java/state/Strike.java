package state;

import bowling.Pins;

public class Strike extends FrameDone {
	@Override
	public State update(int pinsDown) {
		return null;
	}

	@Override
	public Pins getSecondRoll() {
		return null;
	}
	
	 @Override
	public boolean isStrike() {
		return true;
	}
}
