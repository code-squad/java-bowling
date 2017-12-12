package bowling.model;

public abstract class Frame {
	private int tryNo = 1;
	
	protected boolean checkTryNo(int no) {
		return tryNo == no;
	}
	
	protected void addTryNo() {
		tryNo++;
	}

	abstract public String getStatus();

	abstract public Frame play(int pin);

	abstract public boolean isEnd();

	abstract public int getScore();
	
	abstract public Frame makeNextFrame();

	abstract protected int calculate(Score score); 
}