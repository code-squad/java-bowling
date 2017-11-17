package model;

public interface Frame {
	
	public void shot(int score);
	public boolean isEndFrame();	
	public int getFrameScore();	
	public String getCurrentScoreBoard();	
	public boolean isBonusAddCount();	
	public void addBonusScore(int bonusScore);
}
