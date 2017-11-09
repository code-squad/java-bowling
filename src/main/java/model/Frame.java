package model;

import exception.InvalidFrameScoreException;

public abstract class Frame {
	private FrameScore frameScore;

	public Frame(FrameScore frameScore) {
		this.frameScore = frameScore;
	}

	public String getCurrentScoreBoard() {
		return frameScore.getCurrentScoreBoard();
	}

	protected int totalScore() {
		return frameScore.totalScore();
	}

	public void shot(int score) throws InvalidFrameScoreException {
		frameScore.shot(score);
	}
}