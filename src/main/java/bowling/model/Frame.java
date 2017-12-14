package bowling.model;

public interface Frame {

	String getStatus();

	Frame play(int pin);

	boolean isEnd();

	int getScore();
	
	int calculate(Score score); 
	
	void addResult(PlayerResult result);
}