package bowling.frame.state;

public class Ready implements State {

	@Override
	public State bowl(int score) {
		if (score == 10) {
			return new Strike();
		}
		return new First(score);
	}

}
