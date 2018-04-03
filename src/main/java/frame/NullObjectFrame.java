package frame;

import java.util.Arrays;

import bowling.EndGameException;
import bowling.Pins;

public class NullObjectFrame implements Frame {

	@Override
	public void roll(int pinsDown) {
		throw new EndGameException();
		Arrays.asList(a)
	}

	@Override
	public Frame getCurrentFrame() {
		return null;
	}

	@Override
	public Frame getNextFrame() {
		return null;
	}

	@Override
	public boolean isEndGame() {
		return true;
	}

	@Override
	public Pins getFirstRoll() {
		return null;
	}

	@Override
	public Pins getSecondRoll() {
		return null;
	}
}
