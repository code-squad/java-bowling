package model;

public class Score {
	
	private int score;
	private boolean isNextBall;

	public Score(int score, boolean isNextBall) {
		this.score = score;
		this.isNextBall = isNextBall;
	}

	public int getScore() {
		return score;
	}

	public boolean isNextBall() {
		return isNextBall;
	}
}
