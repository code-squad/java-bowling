
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
		if (currentFrame.isEnded(this)) {
			if (frameNum >= 8) {
				frames.add(new FrameTen());
				frameNum++;
				return;
			}
			frames.add(new Frame());
			frameNum++;
		}
	}
	
	boolean isFinished() {
		return frames.get(frameNum).isEnded(this);
	}
}
