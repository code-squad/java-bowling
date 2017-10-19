package jjak.model;

public abstract class Frame {
	protected int firstScore;
	protected int secondScore;
	protected State state;
	
	abstract public void setFirstScore(int score);

	abstract public void setSecondScore(int secondScore);

	abstract public int getFirstScore();

	abstract public int getSecondScore();

}
