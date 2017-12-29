import java.util.ArrayList;
import java.util.List;

public abstract class Frame {
	private List<Integer> pinsPerFrame = new ArrayList<>();
	private int frameNum = 0;
	private Frame nextFrame;
	
	Frame(int frameNum) {
		this.frameNum = frameNum;
	}
	
	List<Integer> getPinsPerFrame () {
		return this.pinsPerFrame;
	}
	
	boolean isEmpty() {
		return pinsPerFrame.isEmpty();
	}
	
	int get(int index) {
		return pinsPerFrame.get(index);
	}
	
	int getSize() {
		return pinsPerFrame.size();
	}
	
	Frame getNextFrame() {
		return this.nextFrame;
	}

	int getFrameNum() {
		return this.frameNum;
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
			nextFrame = new FrameTen(++frameNum);
			return nextFrame;
		}
		nextFrame = new NormalFrame(++frameNum);
		return nextFrame;
	}

	int getSumOfFrame() {
		int sum = 0;
		for (int pinsPerTry : pinsPerFrame) {
			sum += pinsPerTry;
		}
		return sum;
	}
	
	Score getScore(Score score) {
		for (int pinsPerTry : pinsPerFrame) {
			score.bowl(pinsPerTry);
			if (score.isEnded()) {
				return score;
			}
		}
		if(this.isEnded()) {
			return nextFrame.getScore(score);			
		}
		return null;
	}
	
	abstract String makeScoreMark();
	
	abstract Score getScore();
	
	abstract Score getScoreDepdingOnPins();
	
	abstract boolean isEnded();
}