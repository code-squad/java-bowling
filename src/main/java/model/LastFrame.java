package model;

import exception.InvalidFrameScoreException;

public class LastFrame extends Frame {

	public LastFrame() {
		pins = new Pins();
	}

	@Override
	public void shot(int score) {
		if (score > 10)
			throw new InvalidFrameScoreException("점수 입력이 잘 못 되었습니다.");
		if (shotCount > 2)
			throw new InvalidFrameScoreException("점수 입력을 초과하였습니다.");
		checkNewPins();
		Score shotScore = pins.fallPins(score);
		frameScoreBoard.addScore(shotScore);
		shotCount++;
	}

	private void checkNewPins() {
		if (pins.checkInvalidFalled() && shotCount < 3)
			pins = new Pins();
	}
}