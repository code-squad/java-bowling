package model;

import java.util.ArrayList;
import java.util.List;

import view.InputView;
import view.ResultView;

public class Bowling {
	private List<Frame> frames = new ArrayList<>();
	private int frameCount = 1;
	public Frame currentFrame = new NormalFrame(frameCount);
	
	public void addFirstFrame() {
		frames.add(currentFrame);
	}
	
	public void bowl(int falledPin) {
		if(frames.size() == 0) {
			addFirstFrame();
		}
		currentFrame.addPins(falledPin);
		// 기존 혹은 새 프레임 반환.
		Frame frame = currentFrame.returnFrame();
		if(frame != currentFrame && this.currentFrame.frameNum != 11) {// 새 프레임이 반환되었으면,
			frames.add(frame);
			currentFrame = frame;
		}
	}

	public List<Frame> getFrames() {
		return frames;
	}
	
}
