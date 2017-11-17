package model;

public abstract class Frame {
	
	abstract void shot(int score);
	abstract boolean isEndFrame();	
	abstract int getFrameScore();	
	abstract String getCurrentScoreBoard();	
	abstract boolean isBonusAddCount();	
	abstract void addBonusScore(int bonusScore);
}
