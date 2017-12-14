import java.util.ArrayList;
import java.util.List;

public class Frame {

	List<Integer> pinsPerFrame = new ArrayList<>();
	
	List<Integer> getPinsPerFrame () {
		return this.pinsPerFrame;
	}
	
	String makeScoreMark(Player player) {
		if (pinsPerFrame.isEmpty()) {
			return "      |";
		}
		String scoreMark = makeScoreMarkWhenSizeOneOrTwo();
		return scoreMark;
	}

	String makeScoreMarkWhenSizeOneOrTwo() {
		String scoreMark = "";
		if (pinsPerFrame.size() == 1) {
			scoreMark =  makeFirstScoreMark();
		}
		if (pinsPerFrame.size() == 2) {
			scoreMark =  makeSecondScoreMark();
		}
		return scoreMark;
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
	
	boolean isEnded(Player player) {
		if (pinsPerFrame.isEmpty()) {
			return false;
		}
		if (pinsPerFrame.size() == 2) {
			return true;
		}
		return pinsPerFrame.get(0) == 10;
	}
}
