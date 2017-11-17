package model.frame;

import model.FrameScoreBoard;

public abstract class Frame {
	
	protected FrameScoreBoard frameScoreBoard = new FrameScoreBoard();

	public abstract void shot(int score);
	public abstract boolean isEndFrame();
	public abstract boolean isBonusAddCount();
	public abstract void addBonusScore(int bonusScore);
	
	public int getFrameScore() {
		return frameScoreBoard.getSumScore();
	}

	public String getCurrentScoreBoard() {
		return frameScoreBoard.currentScoreValue();
	}
}