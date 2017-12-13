

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String name;
	private List<Frame> frames = new ArrayList<>();
	private int frameNum = 0;

	Player(String name) {
		this.name = name;
		frames.add(new Frame());
	}
	
	int getFrameNum() {
		return this.frameNum;
	}
	
	String getName() {
		return this.name;
	}
	
	List<Frame> getFrames() {
		return this.frames;
	}
	
	void play(int pinsPerTry) {
		Frame currentFrame = frames.get(frameNum);
		currentFrame.bowl(pinsPerTry);
		checkPinsRight(currentFrame);
		if (currentFrame.isEnded(this)) {
			frames.add(new Frame());
			frameNum++;
		}
	}
	
	private void checkPinsRight(Frame currentFrame) {
		int sum = 0;
		if (frameNum == 9) {
			return;
		}
		
		for (int pinsPerTry : currentFrame.getPinsPerFrame()) {
			sum += pinsPerTry;
			if (sum > 10) {
				throw new InputException("투구의 합은 10 이하여야 합니다");
			}
		}
	}
	
	boolean isFinished() {
		if (frameNum < 10) {
			return false;
		}
		return frames.get(frameNum).isEnded(this);
	}
}
