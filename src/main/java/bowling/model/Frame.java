package bowling.model;

public abstract class Frame {

	abstract public String getStatus();

	abstract public Frame play(int pin);

	abstract public boolean isEnd();

	abstract public int getScore();
	
	abstract protected int calculate(Score score); 
}