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

	@Override
	public int firstScore() {
		return score;
	}

	public int getScore(Score next, Score nextNext) {
		return this.currentScore() + next.firstScore();
	}

}
