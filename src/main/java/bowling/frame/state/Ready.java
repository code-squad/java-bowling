package bowling.frame.state;

import bowling.frame.CannotCalculateException;

public class Ready extends Running {
	public State bowl(int countOfPin) {
		if (countOfPin == 10) {
			return new Strike();
		}
		
		return new FirstBowl(countOfPin);
	}
	
	public Score cacluateAdditionalScore(Score score) {
		throw new CannotCalculateException();
	}
}
