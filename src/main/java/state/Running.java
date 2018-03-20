package state;

import bowling.Pins;

public interface Running {
	public State saveBowl(Pins firstRoll);
}
