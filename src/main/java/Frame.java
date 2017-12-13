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
			return "  X   |";
		}
		
		if (firstPins == 0) {
			firstValue = "-"; 
		}
		String oneFrame = "  " + firstValue + "   |";
		if (pinsPerFrame.size() == 2) {
			oneFrame = makeSecondScroeMark(firstValue);
		}
		return oneFrame;
	}
	
	private String makeSecondScroeMark(String firstValue) {
		int firstPins = pinsPerFrame.get(0);
		int secondPins = pinsPerFrame.get(1);
		String secondValue = Integer.toString(secondPins);
		if (firstPins + secondPins == 10) {
			secondValue = "/";
		}
		if (secondPins == 0) {
			secondValue = "-";
		}
		String oneFrame = "  " + firstValue + "|" + secondValue + " |";
		return oneFrame;
	}
	
	void bowl(int pinsPerTry) {
		this.pinsPerFrame.add(pinsPerTry);
	}
	
	boolean isEnded() {
		if (pinsPerFrame.isEmpty()) {
			return true;
		}
		if (pinsPerFrame.size() == 2) {
			return true;
		}
		return pinsPerFrame.get(0) == 10;
	}
}
