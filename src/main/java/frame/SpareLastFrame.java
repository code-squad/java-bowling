package frame;

import bowling.EndGameException;
import bowling.Pins;
import state.Ready;
import state.State;

public class SpareLastFrame implements Frame {
	private Pins firstRoll;

	@Override
	public void roll(int pinsDown) {
		if (isEndGame()) {
			throw new EndGameException();
		}

		firstRoll = new Pins(pinsDown);
	}

	@Override
	public Frame getCurrentFrame() {
		return this;
	}

	@Override
	public Frame getNextFrame() {
		return this;
	}

	@Override
	public boolean isEndGame() {
		return firstRoll != null;
	}

	@Override
	public Pins getFirstRoll() {
		return firstRoll;
	}

	@Override
	public Pins getSecondRoll() {
		return null;
	}
}
