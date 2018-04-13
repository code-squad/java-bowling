package state;

import bowling.FrameInfo;
import bowling.TotalScore;

public interface State {

	State update(int pinsDown);

	FrameInfo setPinsDown(FrameInfo frameInfo);
	
	TotalScore getTotalScore();
	
	TotalScore addNextFrameScore(TotalScore totalScore);

	boolean isFrameEnd();

}
