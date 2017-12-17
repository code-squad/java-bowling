package sangco.bowling.model;

import java.util.HashMap;

public class TotalScore {
	public Frame getFrameData(int frame, Frame frameObject) {
		
		switch(frame) {
			case 1: 
				frameObject = setFirstFrameTotal(frame, frameObject);
				break;
			case 2:
				break;
			case 10:
				break;
			default:
				break;	
		}
		return frameObject;
	}
	
	private Frame setFirstFrameTotal(int frame, Frame frameObject) {
		if(frameObject instanceof NormalFrame) {
			frameObject.setGameTotalScore(0); // 1프레임이라서 인자값으로 넣어주는 total이 0
		}
		return frameObject;
	}
	
	public Frame getFrameData(Frame frame) {
		FrameType frameType = FrameType.getFrameType(frame);
		switch(frameType) {
			case NOMALFRAME:
				break;
			case STRIKEFRAME:
				break;
			case SPAREFRAME:
				break;
			default :	
				
		}
		return frame;
	}
}
