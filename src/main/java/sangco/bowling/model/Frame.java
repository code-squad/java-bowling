package sangco.bowling.model;

import sangco.bowling.model.state.BowlingState;

public interface Frame {
	void setNextRoll(int SecondRoll);

	int setGameTotalScore(int totalScore);

	int getScoreFirstRoll();

	int getFrameScore();

	int getTotalScore();
	
	boolean getTotalSetOrNot();
}
