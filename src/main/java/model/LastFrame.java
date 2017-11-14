package model;

import exception.InvalidFrameScoreException;

public class LastFrame extends Frame {
	
	private boolean isNewPins = false;

	public LastFrame() {
		pins = new Pins();
	}

	@Override
	public void shot(int score) {
		if (score > 10)
			throw new InvalidFrameScoreException("점수 입력이 잘 못 되었습니다.");
		if (isEndFrame())
			throw new InvalidFrameScoreException("프레임이 종료 되었습니다.");
		Score shotScore = pins.fallPins(score);
		frameScoreBoard.addScore(shotScore);
		frameScore.addScore(score);
		shotCount++;
		checkNewPins();
	}

	@Override
	public boolean isEndFrame() {
		return endSetScore() || shotCount > 2;
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