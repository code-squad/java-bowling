package frame;

import bowling.FrameInfo;
import bowling.TotalScore;
import state.State;

public interface Frame {
	
	Frame roll(int pinsDown);

	boolean isGameEnd();

	FrameInfo getFrameInfo();
	
	TotalScore addBeforeTotal(TotalScore beforeTotal);

}
