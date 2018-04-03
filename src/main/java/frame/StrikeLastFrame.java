package frame;

import bowling.EndGameException;
import bowling.Pins;
import state.Ready;
import state.State;

public class StrikeLastFrame implements Frame {
	private Pins firstRoll;
	private Pins secondRoll;

	@Override
	public void roll(int pinsDown) {
		if (isEndGame()) {
			throw new EndGameException();
		}

		if (firstRoll == null) {
			firstRoll = new Pins(pinsDown);
			return;
		}
		secondRoll = new Pins(pinsDown);
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
		return firstRoll != null && secondRoll != null;
	}

	@Override
	public Pins getFirstRoll() {
		return firstRoll;
	}

	@Override
	public Pins getSecondRoll() {
		return secondRoll;
	}
}
