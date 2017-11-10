package model;

import exception.InvalidFrameScoreException;

public class Frame {
	
	protected int shotCount = 0;

	protected Pins pins;
	protected FrameScoreBoard frameScoreBoard = new FrameScoreBoard();

	public Frame() {
		pins = new Pins();
	}

	public void shot(int score) throws InvalidFrameScoreException {
		if (score > 10)
			throw new InvalidFrameScoreException("점수 입력이 잘 못 되었습니다.");
		if (shotCount > 1)
			throw new InvalidFrameScoreException("점수 입력을 초과하였습니다.");
		Score shotScore = pins.fallPins(score);
		frameScoreBoard.addScore(shotScore);
		shotCount++;
	}

	public int totalScore() {
		return frameScoreBoard.currentScore();
	}

	public String getCurrentScoreBoard() {
		return frameScoreBoard.currentScoreValue();
	}
}