package state;

import bowling.Pins;

public class Ready extends Running {

	public Ready(Pins firstRoll) {
		super.firstRoll = firstRoll;
	}

	@Override
	public State saveBowl(Pins secondRoll) {
		return new Nomal(super.firstRoll, secondRoll);
	}

}
