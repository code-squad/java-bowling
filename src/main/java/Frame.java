import java.util.ArrayList;
import java.util.List;

public class Frame {

	List<Integer> pinsPerFrame = new ArrayList<>();
	
	List<Integer> getPinsPerFrame () {
		return this.pinsPerFrame;
	}
	
	String changeScoreToMark(int score) {
		if (score == 10) {
			return "X";
		}
		if (score == 0) {
			return "-";
		}
		return Integer.toString(score);
	}
	
	String makeFristScoreMark(Player player) {
		if (pinsPerFrame.isEmpty()) {
			if (player.getFrameNum() == 10) {
				return "";
			}
			return "      |";
		}
		int firstPins = pinsPerFrame.get(0);
		String firstValue = firstPins + "";
		if (firstPins == 10) {
			firstValue = "X";
		}
		if (firstPins == 0) {
			firstValue = "-"; 
		}
		String oneFrame = "  " + firstValue + "   |";
		if (pinsPerFrame.size() >= 2) {
			return makeSecondScoreMark(firstValue);
		}
		return oneFrame;
	}
	
	String makeSecondScoreMark(String firstValue) {
		String oneFrame = makeOneFrame(firstValue);
		return oneFrame;
	}

	String makeOneFrame(String firstValue) {
		int firstPins = pinsPerFrame.get(0);
		int secondPins = pinsPerFrame.get(1);
		String secondValue = Integer.toString(secondPins);
		secondValue = makeLastScoreMark(firstPins, secondPins, secondValue);
		String oneFrame = "  " + firstValue + "|" + secondValue + " |";
		return oneFrame;
	}
	
	String makeLastScoreMark(int beforePins, int afterPins, String value) {
		if (beforePins + afterPins == 10) {
			value = "/";
		}
		if (afterPins == 0) {
			value = "-";
		}
		if (afterPins == 10) {
			value = "X";
		}
		return value;
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
