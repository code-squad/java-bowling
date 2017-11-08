package model;

import Exception.FrameScoreException;

public class TenFrame extends Frame{
	
	public TenFrame() {
		frameScore = new TenFrameScore();
	}
	
	public void shot(int score) throws FrameScoreException {
		frameScore.shot(score);
	}
	
	@Override
	public String getCurrentScoreBoard() {
		return frameScore.getCurrentScoreBoard();
	}
}