package model;

public class FrameScore {
	private int score;

	public FrameScore() {
		score = 0;
	}

	public int get() {
		return score;
	}

	public void addScore(int addScore) {
		score += addScore;
	}
}
