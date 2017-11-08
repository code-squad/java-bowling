package model;

public abstract class Frame {
	FrameScore frameScore;

	public Frame() {
		frameScore = new NomalFrameScore();
	}
	
	public String getCurrentScoreBoard() {
		return frameScore.getCurrentScoreBoard();
	}

	protected int totalScore() {
		return frameScore.totalScore();
	}

	abstract void shot(int score);
}