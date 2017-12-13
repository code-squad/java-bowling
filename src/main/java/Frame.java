import java.util.ArrayList;
import java.util.List;

public class Frame {

	private List<Integer> pinsPerFrame = new ArrayList<>();
	
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
	
	private String makeSecondScoreMark(String firstValue) {
		int firstPins = pinsPerFrame.get(0);
		int secondPins = pinsPerFrame.get(1);
		String secondValue = Integer.toString(secondPins);
		secondValue = makeLastScoreMark(firstPins, secondPins, secondValue);
		String oneFrame = "  " + firstValue + "|" + secondValue + " |";
		if (pinsPerFrame.size() == 3) {
			oneFrame = makeThirdScoreMark(firstValue, secondValue);
		}
		return oneFrame;
	}
	
	private String makeThirdScoreMark(String firstValue, String secondValue) {
		int secondPins = pinsPerFrame.get(1);
		int thirdPins = pinsPerFrame.get(2);
		String thirdValue = Integer.toString(thirdPins);
		thirdValue = makeLastScoreMark(secondPins, thirdPins, thirdValue);
		String oneFrame = " " + firstValue + "|" + secondValue + "|" + thirdValue + "|";
		return oneFrame;
	}
	
	private String makeLastScoreMark(int firstPins, int secondPins, String secondValue) {
		if (firstPins + secondPins == 10) {
			secondValue = "/";
		}
		if (secondPins == 0) {
			secondValue = "-";
		}
		if (secondPins == 10) {
			secondValue = "X";
		}
		return secondValue;
	}
	
	void bowl(int pinsPerTry) {
		this.pinsPerFrame.add(pinsPerTry);
	}
	
	boolean isEnded(Player player) {
		if (pinsPerFrame.isEmpty()) {
			return true;
		}
		if (player.getFrameNum() == 9) {
			if (pinsPerFrame.size() == 3) {
				return true;
			}
			return pinsPerFrame.size() == 2 && pinsPerFrame.get(0) + pinsPerFrame.get(1) < 10;
		}
		if (pinsPerFrame.size() == 2) {
			return true;
		}
		return pinsPerFrame.get(0) == 10;
	}
}
