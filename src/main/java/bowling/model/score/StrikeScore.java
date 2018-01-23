package bowling.model.score;

public class StrikeScore implements Score {

	public StrikeScore() {
	}

	@Override
	public int currentScore() {
		return 10;
	}

}
