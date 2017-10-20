package bowling.frame.state;

public class Ready implements State {
	public State bowl(int countOfPin) {
		if (countOfPin == 10) {
			return new Strike();
		}
		
		return new FirstBowl(countOfPin);
	}

	@Override
	public boolean isEnd() {
		return false;
	}
}
