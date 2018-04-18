package bowling.domain;

public class Score {

	private int score;
	private int left;

	private Score(int score, int left) {
		this.score = score;
		this.left = left;
	}

	public static Score ofStrike(int score) {
		return new Score(score, 2);
	}

	public static Score ofSpare(int score) {
		return new Score(score, 1);
	}

	public static Score of(int score) {
		return new Score(score, 0);
	}

	public int getScore() {
		return score;
	}

	public boolean canCalculateScore() {
		return left != 0;
	}

	public boolean canOneMoreCalculate() {
		return left == 1;
	}

	public Score bowl(int inputScore) {
		return new Score(score += inputScore, left - 1);
	}
}
