package model;

import java.util.ArrayList;
import java.util.List;

import Exception.InvalidFrameNumberException;

public class Bowling {
	private List<Frame> frames = new ArrayList<>();
	private static final int FRAME_START_NO = 1;
	public Frame currentFrame = new NormalFrame(FRAME_START_NO);

	private void addFirstFrame() {
		frames.add(currentFrame);
	}

	public void bowl(Pin pin) throws InvalidFrameNumberException {
		if (frames.size() == 0) {
			addFirstFrame();
		}
		Frame frame = currentFrame.addAfterDecide(pin);
		if (currentFrame.isNewFrame(frame)) {// 새 프레임이 반환되었으면,
			frames.add(frame);
			currentFrame = frame;
		}
	}

	public List<Frame> getFrames() {
		return frames;
	}
}
