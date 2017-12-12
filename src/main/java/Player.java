
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
		int sum = 0;
		if (frames.size() == frameNum) {
			frames.add(new Frame());
		}
		List<Integer> pinsPerFrame = frames.get(frameNum).getPinsPerFrame();
		pinsPerFrame.add(pinsPerTry);
		sum = checkPinsRight(sum, pinsPerFrame);
		if (pinsPerFrame.get(0) == 10 || pinsPerFrame.size() == 2) {
			frameNum++;
		}
	}

	private int checkPinsRight(int sum, List<Integer> pinsPerFrame) {
		for (int pinsScore : pinsPerFrame) {
			sum += pinsScore;
			if (sum > 10) {
				throw new InputException("첫번째 투구와 두번째 투구의 합은 10 이하여야 합니다");
			}
		}
		return sum;
	}
	
	boolean isFinished() {
		if (frameNum == 10) {
			return false;
		}
		return true;
	}
}
