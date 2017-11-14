package model;

import exception.InvalidFrameScoreException;

public class Frame {

	protected int shotCount = 0;

	protected Pins pins;
	protected FrameScoreBoard frameScoreBoard = new FrameScoreBoard();

	protected FrameScore frameScore = new FrameScore();

	private int scoreAddCount = 0;
	protected boolean isEndFrame = false;

	public Frame() {
		pins = new Pins();
	}

	public void shot(int score) throws InvalidFrameScoreException {
		checkInvalidException(score);
		addScore(score);
		shotCount++;
		isEndFrame();
		if (isEndFrame) {
			bonusScoreCount();
		}
	}

	public void addScore(int score) {
		Score shotScore = pins.fallPins(score);
		frameScoreBoard.addScore(shotScore);
		frameScore.addScore(score);
		if (score == 10) {
			isEndFrame = true;
		}
	}

	public void checkInvalidException(int score) {
		if (score > 10)
			throw new InvalidFrameScoreException("점수 입력이 잘 못 되었습니다.");
		if (isEndFrame())
			throw new InvalidFrameScoreException("점수 입력을 초과하였습니다.");
	}

	public void addBonusScore(int bonusScore) {
		if (isAddCount()) {
			frameScore.addScore(bonusScore);
			scoreAddCount--;
		}
	}

	private boolean isAddCount() {
		return !(scoreAddCount == 0 || scoreAddCount > 3);
	}

	public boolean isEndFrame() {
		if (shotCount > 1)
			isEndFrame = true;
		return isEndFrame;
	}

	public int getSumScore() {
		return frameScoreBoard.getSumScore();
	}

	public String getCurrentScoreBoard() {
		return frameScoreBoard.currentScoreValue();
	}

	private void bonusScoreCount() {
		if ("X".equals(frameScoreBoard.getCurrentScoreValue())) {
			scoreAddCount = 2;
		}
		if ("/".equals(frameScoreBoard.getCurrentScoreValue())) {
			scoreAddCount = 1;
		}
	}

	public int getFrameScore() {
		return frameScore.get();
	}
}