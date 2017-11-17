package model;

import exception.InvalidFrameScoreException;
import model.frame.Frame;

public class LastFrame extends Frame {

	private int shotCount = 0;
	private Pins pins = new Pins();
	private boolean isNewPins = false;

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
	public boolean isBonusAddCount() {
		//보너스점수가 들어갈리 없음 무조건 false
		return false;
	}

	@Override
	public void addBonusScore(int bonusScore) {
		//없어도 됨 NormalFrame에만 쓰지만 SetOfFrame에서 사용하는 List<Frame>에 사용하기 위해서 존재.
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