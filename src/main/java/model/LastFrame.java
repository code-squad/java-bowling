package model;

import exception.InvalidFrameScoreException;

public class LastFrame extends Frame {

	private int shotCount = 0;
	private Pins pins = new Pins();
	private boolean isNewPins = false;
	private FrameScoreBoard frameScoreBoard = new FrameScoreBoard();
	private int bonusScoreAddCount = 0;

	@Override
	public void shot(int score) {
		if (score > 10)
			throw new InvalidFrameScoreException("점수 입력이 잘 못 되었습니다.");
		if (isEndFrame())
			throw new InvalidFrameScoreException("프레임이 종료 되었습니다.");
		Score shotScore = pins.fallPins(score);
		frameScoreBoard.addScore(shotScore);
		shotCount++;
		checkNewPins();
	}

	@Override
	public boolean isEndFrame() {
		return endSetScore() || shotCount > 2;
	}

	@Override
	public int getFrameScore() {
		return frameScoreBoard.getSumScore();
	}

	@Override
	public String getCurrentScoreBoard() {
		return frameScoreBoard.currentScoreValue();
	}

	@Override
	public boolean isBonusAddCount() {
		return !(bonusScoreAddCount == 0 || bonusScoreAddCount > 3);
	}

	@Override
	public void addBonusScore(int bonusScore) {
		if (isBonusAddCount()) {
			frameScoreBoard.addBonusScore(bonusScore);
			bonusScoreAddCount--;
		}
	}

	private boolean endSetScore() {
		return shotCount > 1 && !isNewPins;
	}

	private void checkNewPins() {
		if (pins.checkInvalidFalled() && shotCount < 4) {
			pins = new Pins();
			isNewPins = true;
		}
	}
}