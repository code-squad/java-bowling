package frame;

import java.util.List;

import bowling.FrameInfo;
import bowling.TotalScore;

public interface Frame {
	
	Frame roll(int pinsDown);

	boolean isGameEnd();

	List<FrameInfo> getFrameInfo(List<FrameInfo> frameInfoList);
	
	TotalScore addBeforeTotal(TotalScore beforeTotal);

}
