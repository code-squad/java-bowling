import java.util.ArrayList;
import java.util.List;

public class Frame {
	List<Integer> pinsPerFrame = new ArrayList<>();
	private int frameNum = 0;
	private Frame nextFrame;

	Frame(int frameNum) {
		this.frameNum = frameNum;
	}

	int getFrameNum() {
		return this.frameNum;
	}

	String makeScoreMark() {
		int sum = getSumOfFrame();
		if (pinsPerFrame.size() == 1) {
			return makeFirstScoreMark();
		}
		if (sum > 10) {
			throw new InputException("투구의 합은 10 이하여야 합니다");
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

	Frame bowl(int pinsPerTry) {
		this.pinsPerFrame.add(pinsPerTry);
		return this;
	}

	Frame makeNewFrame() {
		if (frameNum >= 8) {
			nextFrame = new FrameTen(++frameNum);
			return nextFrame;
		}
		nextFrame = new Frame(++frameNum);
		return nextFrame;
	}

	Score getScore() {
		Score score = getScoreDepdingOnPins();
		if (score == null) {
			return null;
		}
		if (score.isEnded()) {
			return score;
		}
		return nextFrame.getScore(score);
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

	Score getScoreDepdingOnPins() {
		int sum = getSumOfFrame();
		if (sum == 10 && pinsPerFrame.size() == 1) {
			return new Score(sum, 2);
		}
		if (sum == 10 && pinsPerFrame.size() == 2) {
			return new Score(sum, 1);
		}
		if (pinsPerFrame.size() == 2) {
			return new Score(sum, 0);			
		}
		return null;
	}

	int getSumOfFrame() {
		int sum = 0;
		for (int pinsPerTry : pinsPerFrame) {
			sum += pinsPerTry;
		}
		return sum;
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
