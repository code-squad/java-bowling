
public class FrameTen extends Frame{
	
	@Override
	String makeSecondScoreMark(String firstValue) {
		String oneFrame = makeOneFrame(firstValue);
		if (pinsPerFrame.size() == 3) {
			return makeThirdScoreMark(firstValue);
		}
		return oneFrame;
	}

	private String makeThirdScoreMark(String firstValue) {
		int firstPins = pinsPerFrame.get(0);
		int secondPins = pinsPerFrame.get(1);
		int thirdPins = pinsPerFrame.get(2);
		String secondValue = Integer.toString(secondPins);
		String thirdValue = Integer.toString(thirdPins);
		secondValue = makeLastScoreMark(firstPins, secondPins, secondValue);
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
