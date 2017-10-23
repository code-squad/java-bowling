package bowling.frame.state;

public class Ready extends Running {
	public State bowl(int countOfPin) {
		if (countOfPin == 10) {
			return new Strike();
		}
		
		return new FirstBowl(countOfPin);
	}
}
