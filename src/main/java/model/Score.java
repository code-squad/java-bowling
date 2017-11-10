package model;

public class Score {
	private int score;
	private boolean isSecondBall;

	public Score(int score, boolean isSecondBall) {
		this.score = score;
		this.isSecondBall = isSecondBall;
	}

	public int getScore() {
		return score;
	}

	public boolean isSecondBall() {
		return isSecondBall;
	}
}
