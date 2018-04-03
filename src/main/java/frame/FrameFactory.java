package frame;

import bowling.RollForTotal;

public class FrameFactory {
	public static Frame getLastFrame(RollForTotal needRoll) {
		Frame lastFrame = null;
		switch (needRoll) {
		case ZEROROLL:
			lastFrame = new NullObjectFrame();
			break;
		case ONEROLL:
			lastFrame = new SpareLastFrame();
			break;
		case TWOROLL:
			lastFrame = new StrikeLastFrame();
			break;
		}
		return lastFrame;
	}
}
