package state;

import bowling.Pins;

public class FirstBowl extends State implements Running {

	@Override
	public State saveBowl(Pins firstRoll) {
		if (firstRoll.getPinsDown() == 10) {
			return new Strike();
		}
		
		return new Ready(firstRoll);
	}

}
