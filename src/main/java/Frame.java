import java.util.ArrayList;
import java.util.List;

public class Frame {

	private List<Integer> pinsPerFrame = new ArrayList<>();
	
	List<Integer> getPinsPerFrame () {
		return this.pinsPerFrame;
	}
		
	String makeFristScoreMark() {
		int firstPins = getPinsPerFrame().get(0);
		String firstValue = Integer.toString(firstPins);
		if (firstPins == 10) {
			firstValue = "X";
		}
		if (firstPins == 0) {
			firstValue = "-"; 
		}
		String oneFrame = "  " + firstValue + "   |";
		if (getPinsPerFrame().size() == 2) {
			oneFrame = makeSecondScroeMark(firstValue);
		}
		return oneFrame;
	}

	private String makeSecondScroeMark(String firstValue) {
		int firstPins = getPinsPerFrame().get(0);
		int secondPins = getPinsPerFrame().get(1);
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
}
