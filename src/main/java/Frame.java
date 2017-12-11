import java.util.ArrayList;
import java.util.List;

public class Frame {

	private List<Integer> pinsPerFrame = new ArrayList<>();
	
	List<Integer> getPinsPerFrame () {
		return this.pinsPerFrame;
	}
	
	Frame makePinsPerFrame(int pinsPerTry) {
		this.pinsPerFrame.add(pinsPerTry);
		return this;
	}
	
	String makeScoreMarkOnFrame() {
		String oneFrame, firstValue;
		int firstPins = getPinsPerFrame().get(0);
		firstValue = Integer.toString(firstPins);
		if (firstPins == 10) {
			firstValue = "X";
		}
		if (firstPins == 0) {
			firstValue = "-"; 
		}
		oneFrame = "  " + firstValue + "   |";
		if (getPinsPerFrame().size() == 2) {
			oneFrame = chageSecondValue(firstValue);
		}
		return oneFrame;
	}

	String chageSecondValue(String firstValue) {
		String oneFrame, secondValue;
		int firstPins = getPinsPerFrame().get(0);
		int secondPins = getPinsPerFrame().get(1);
		secondValue = Integer.toString(secondPins);
		if (firstPins + secondPins == 10) {
			secondValue = "/";
		}
		if (secondPins == 0) {
			secondValue = "-";
		}
		oneFrame = "  " + firstValue + "|" + secondValue + " |";
		return oneFrame;
	}
}
