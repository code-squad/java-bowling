package model;

import exception.InvalidFrameScoreException;

public class Frame {

	private int shotCount = 0;
	private Pins pins;
	private FrameScoreBoard frameScoreBoard = new FrameScoreBoard();
	private int bonusScoreAddCount = 0;

	public Frame() {
		pins = new Pins();
	}

	public void shot(int score) throws InvalidFrameScoreException {
		checkInvalidException(score);
		addScore(score);
		shotCount++;
		if (isEndFrame()) {
			bonusScoreCount();
		}
	}
	
	private boolean isBonusAddCount() {
		return !(bonusScoreAddCount == 0 || bonusScoreAddCount > 3);
	}
	
	private void bonusScoreCount() {
		if (isStrike()) {
			bonusScoreAddCount = 2;
		}
		if (isSpare()) {
			bonusScoreAddCount = 1;
		}
	}
	
	private boolean isStrike() {
		return "X".equals(frameScoreBoard.getCurrentScoreValue());
	}
	
	private boolean isSpare() {
		return "/".equals(frameScoreBoard.getCurrentScoreValue());
	}

	public void addScore(int score) {
		frameScoreBoard.addScore(pins.fallPins(score));
	}

	private void checkInvalidException(int score) {
		if (score > 10)
			throw new InvalidFrameScoreException("점수 입력이 잘 못 되었습니다.");
		if (isEndFrame())
			throw new InvalidFrameScoreException("점수 입력을 초과하였습니다.");
	}

	public void addBonusScore(int bonusScore) {
		if (isBonusAddCount()) {
			frameScoreBoard.addBonusScore(bonusScore);
			bonusScoreAddCount--;
		}
	}
	
	public boolean isEndFrame() {
		if (shotCount > 1 || isStrike())
			return true;
		return false;
	}

	public String getCurrentScoreBoard() {
		return frameScoreBoard.currentScoreValue();
	}

	public int getFrameScore() {
		return frameScoreBoard.getSumScore();
	}
}