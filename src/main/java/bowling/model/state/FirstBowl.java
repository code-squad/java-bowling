package bowling.model.state;

public class FirstBowl implements State {
	private int score;

	public FirstBowl(int knockedPins) {
		score = knockedPins;
	}

	@Override
	public State bowl(int knockedPins) {
		if (score + knockedPins == 10) {
			return new Spare(score, knockedPins);
		}
		return new Normal(score, knockedPins);
	}

	@Override
	public boolean isEnd() {
		return false;
	}

	@Override
	public String getScore() {
		return Integer.toString(score);
	}
}
