package state;

import bowling.Pins;

public class FirstBowl extends Running {

	@Override
	public State saveBowl(Pins firstRoll) {
		return new Ready(firstRoll);
	}
	
}
