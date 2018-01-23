package bowling.model.score;

public class SpareScore implements Score {

	private final int score;

	public SpareScore(int score) {
		this.score = score;
	}

	@Override
	public int currentScore() {
		return 10;
	}

}
