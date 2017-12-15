import java.util.ArrayList;
import java.util.List;

public class Frame {

	List<Integer> pinsPerFrame = new ArrayList<>();
	int frameNum = 0;
	
	Frame (int frameNum) {
		this.frameNum = frameNum;
	}
	
	int getFrameNum() {
		return this.frameNum;
	}
	
	List<Integer> getPinsPerFrame () {
		return this.pinsPerFrame;
	}
	
	String makeScoreMark() {
		if (pinsPerFrame.size() == 1) {
			return makeFirstScoreMark();
		}
		if (pinsPerFrame.size() == 2) {
			return makeSecondScoreMark();
		}
		return "      |";
	}
	
	String makeFirstScoreMark() {
		String oneFrame = "     ";
		return makeOneFrame(oneFrame, 1);
	}
	
	String makeSecondScoreMark() {
		if (pinsPerFrame.get(0) + pinsPerFrame.get(1) == 10) {
			return "   " + changeScoreToMark(pinsPerFrame.get(0)) + "|/|";
		}
		String oneFrame = "   ";
		return makeOneFrame(oneFrame, 2);
	}
	
	String makeOneFrame(String oneFrame, int j) {
		for (int i = 0; i < j; i++) {
			oneFrame += getValueFromPin(i) + "|";
		}
		return oneFrame;
	}

	private String getValueFromPin(int i) {
		int pins = pinsPerFrame.get(i);
		String value = changeScoreToMark(pins);
		return value;
	}
	
	static String changeScoreToMark(int score) {
		if (score == 10) {
			return "X";
		}
		if (score == 0) {
			return "-";
		}
		return score + "";
	}
	
	void bowl(int pinsPerTry) {
		this.pinsPerFrame.add(pinsPerTry);
	}
	
	Frame makeNewFrame() {
		if (frameNum >= 8) {
			return new FrameTen(++frameNum);
		}
		return new Frame(++frameNum);
	}
	
	boolean isEnded() {
		if (pinsPerFrame.isEmpty()) {
			return false;
		}
		if (pinsPerFrame.size() == 2) {
			return true;
		}
		return pinsPerFrame.get(0) == 10;
	}
}
