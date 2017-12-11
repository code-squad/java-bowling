
import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String name;
	private List<Frame> frames = new ArrayList<>();
	private int frameNum = 0;

	Player(String name) {
		this.name = name;
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
		if (frames.size() == frameNum) {
			frames.add(new Frame());
		}
		List<Integer> pinsPerFrame = frames.get(frameNum).getPinsPerFrame();
		pinsPerFrame.add(pinsPerTry);
		if (pinsPerFrame.get(0) == 10 || pinsPerFrame.size() == 2) {
			frameNum++;
		}
	}
	
	boolean isFinished() {
		if (frameNum == 10) {
			return false;
		}
		return true;
	}
}
