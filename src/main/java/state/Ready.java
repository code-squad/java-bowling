package state;

import bowling.Pins;

public class Ready extends State implements Running {

	public Ready(Pins firstRoll) {
		super.firstRoll = firstRoll;
	}

	@Override
	public State saveBowl(Pins secondRoll) {
		if (secondRoll.getPinsDown() + firstRoll.getPinsDown() == 10) {
			return new Spare(firstRoll, secondRoll);
		}
		return new Nomal(firstRoll, secondRoll);
	}
}
