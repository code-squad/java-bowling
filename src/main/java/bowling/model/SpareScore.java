package bowling.model;

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
	public String toString() {
		return String.format(" %s|/ ", this.score == 0 ? "-" : this.score);
	}

}
