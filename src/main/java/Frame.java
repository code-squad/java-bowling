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
	
	String changeToString() {
		String oneFrame, firstValue;
		firstValue = Integer.toString(getPinsPerFrame().get(0));
		if (getPinsPerFrame().get(0) == 10) {
			firstValue = "X";
		}
		if (getPinsPerFrame().get(0) == 0) {
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
		secondValue = Integer.toString(getPinsPerFrame().get(1));
		if (getPinsPerFrame().get(0) + getPinsPerFrame().get(1) == 10) {
			secondValue = "/";
		}
		if (getPinsPerFrame().get(1) == 0) {
			secondValue = "-";
		}
		oneFrame = "  " + firstValue + "|" + secondValue + " |";
		return oneFrame;
	}
}
