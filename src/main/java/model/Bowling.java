package model;

import java.util.ArrayList;
import java.util.List;

public class Bowling {
	private List<Frame> frames = new ArrayList<>();
	private static final int FRAME_START_NO = 1;
	public Frame currentFrame = new NormalFrame(FRAME_START_NO);

	private void addFirstFrame() {
		frames.add(currentFrame);
	}

	public void bowl(Pin pin) {
		if (frames.size() == 0) {
			addFirstFrame();
		}
		Frame frame = currentFrame.addAfterDecide(pin);
		if (isNewFrame(frame) && !isFinished()) {// 새 프레임이 반환되었으면,
			frames.add(frame);
			currentFrame = frame;
		}
	}
	
	public boolean isFinished() {
		if(this.currentFrame.getFrameNum() >= 11) {
			return true;
		}
		return false;
	}
	
	private boolean isNewFrame(Frame frame) {	
		return frame != currentFrame;
	}

	public List<Frame> getFrames() {
		return frames;
	}
}
