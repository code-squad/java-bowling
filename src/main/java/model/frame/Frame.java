package model.frame;

import model.FrameScoreBoard;
import model.Pins;

public abstract class Frame {
	
	protected FrameScoreBoard frameScoreBoard = new FrameScoreBoard();
	protected int shotCount = 0;
	protected Pins pins = new Pins();
	
	//LastFrame에서는 사용되지 않음.
	protected int bonusScoreAddCount = 0;

	public abstract void shot(int score);
	public abstract boolean isEndFrame();
	
	public int getFrameScore() {
		return frameScoreBoard.getSumScore();
	}

	public String getCurrentScoreBoard() {
		return frameScoreBoard.currentScoreValue();
	}
	
	//LastFrame에서는 사용되지 않음
	public boolean isBonusAddCount() {
		return !(bonusScoreAddCount == 0 || bonusScoreAddCount > 3);
	}

	//LastFrame에서는 사용되지 않음
	public void addBonusScore(int bonusScore) {
		if (isBonusAddCount()) {
			frameScoreBoard.addBonusScore(bonusScore);
			bonusScoreAddCount--;
		}
	}
}