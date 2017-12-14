import java.util.ArrayList;
import java.util.List;

public class Frame {

	List<Integer> pinsPerFrame = new ArrayList<>();
	
	List<Integer> getPinsPerFrame () {
		return this.pinsPerFrame;
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
			oneFrame = makeSecondScoreMark(firstValue);
		}
		return oneFrame;
	}
	
	protected String makeSecondScoreMark(String firstValue) {
		int firstPins = pinsPerFrame.get(0);
		int secondPins = pinsPerFrame.get(1);
		String secondValue = Integer.toString(secondPins);
		secondValue = makeLastScoreMark(firstPins, secondPins, secondValue);
		String oneFrame = "  " + firstValue + "|" + secondValue + " |";
		return oneFrame;
	}
	
	protected String makeLastScoreMark(int beforePins, int afterPins, String Value) {
		if (beforePins + afterPins == 10) {
			Value = "/";
		}
		if (afterPins == 0) {
			Value = "-";
		}
		if (afterPins == 10) {
			Value = "X";
		}
		return Value;
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
