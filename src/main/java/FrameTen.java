
public class FrameTen extends Frame{
	
	@Override
	protected String makeSecondScoreMark(String firstValue) {
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
	
	@Override
	boolean isEnded(Player player) {
		if (player.getFrameNum() == 10) {
			return true;
		}
		if (pinsPerFrame.isEmpty()) {
			return false;
		}
		if (pinsPerFrame.size() == 3) {
			return true;
		}
		return pinsPerFrame.size() == 2 && pinsPerFrame.get(0) + pinsPerFrame.get(1) < 10;
	}
}
