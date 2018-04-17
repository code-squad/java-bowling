package state;

import bowling.FrameInfo;
import bowling.TotalScore;
import frame.Frame;

public interface State {

	State update(int pinsDown);

	TotalScore getTotalScore();
	
	TotalScore addNextFrameScore(TotalScore totalScore);

	FrameInfo setPinsDown(FrameInfo frameInfo);
	
	boolean isFrameEnd();
	
	Frame generateLastFrame();

}
