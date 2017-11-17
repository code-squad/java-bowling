package model;

import exception.InvalidFrameScoreException;
import model.frame.Frame;

public class NormalFrame extends Frame{

	@Override
	public void shot(int score) throws InvalidFrameScoreException {
		checkInvalidException(score);
		addScore(score);
		shotCount++;
		if (isEndFrame()) {
			bonusScoreCount();
		}
	}
	
	@Override
	public boolean isEndFrame() {
		return shotCount > 1 || isStrike();
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
}