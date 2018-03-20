package state;

import bowling.Pins;

public class Nomal extends Finish {

	public Nomal(Pins firstRoll, Pins secondRoll) {
		super.firstRoll = firstRoll;
		super.secondRoll = secondRoll;
	}

	@Override
	public State saveBowl(Pins pins) {
		return null;
	}

}
