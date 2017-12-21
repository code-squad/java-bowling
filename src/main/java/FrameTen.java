


public class FrameTen extends Frame{
	
	FrameTen(int frameNum) {
		super(frameNum);
	}

	@Override
	String makeScoreMark() {
		if (pinsPerFrame.isEmpty() && frameNum == 9) {
			return "      |";			
		}
		if (pinsPerFrame.size() == 1) {
			return makeFirstScoreMark();
		}
		if (pinsPerFrame.size() == 2) {
			return makeSecondScoreMark();
		}
		if (pinsPerFrame.size() == 3) {
			return makeThirdScoreMark();
		}
		return "";		
	}
	
	String makeThirdScoreMark() {
		if (pinsPerFrame.get(0) + pinsPerFrame.get(1) == 10) {
			return " " + changeScoreToMark(pinsPerFrame.get(0)) +
					"|/|" + changeScoreToMark(pinsPerFrame.get(2)) + "|";
		}
		if (pinsPerFrame.get(1) + pinsPerFrame.get(2) == 10) {
			return " X|" + changeScoreToMark(pinsPerFrame.get(1)) + "|/|";
		}
		String oneFrame = " ";
		return makeOneFrame(oneFrame, 3);
	}
	
	@Override
	boolean isEnded() {
		if (frameNum == 10) {
			return true;
		}
		if (pinsPerFrame.size() == 3) {
			return true;
		}
		return pinsPerFrame.size() == 2 && pinsPerFrame.get(0) + pinsPerFrame.get(1) < 10;
	}
}
