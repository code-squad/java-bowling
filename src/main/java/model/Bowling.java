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

	public void bowl(int falledPin) {
		if (frames.size() == 0) {
			addFirstFrame();
		}
		Frame frame = currentFrame.addAfterDecide(falledPin);
		if (ifIsNewFrameAndNot11th(frame)) {// 새 프레임이 반환되었으면,
			frames.add(frame);
			currentFrame = frame;
		}
	}

	private boolean ifIsNewFrameAndNot11th(Frame frame) {
		return frame != currentFrame && this.currentFrame.getFrameNum() != 11;
	}

	public List<Frame> getFrames() {
		return frames;
	}

}
