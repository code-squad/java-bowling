package state;

import bowling.Pins;

public class Spare extends State implements Finish {

	public Spare(Pins firstRoll, Pins secondRoll) {
		super.firstRoll = firstRoll;
		super.secondRoll = secondRoll;
	}
}
