package bowling.model.state;

import bowling.model.Score;

public interface State {
	
	State play(int pin);
	
	String getStatus();
	
	Score getScore();
	
	Score calculate(Score beforeScore);
	
	boolean isEnd();
}
