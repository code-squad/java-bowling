package state;

import bowling.Pins;

public class Nomal extends State implements Finish {

	public Nomal(Pins firstRoll, Pins secondRoll) {
		super.firstRoll = firstRoll;
		super.secondRoll = secondRoll;
	}
}
