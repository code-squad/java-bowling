public class FrameTen extends Frame{
	FrameTen(int frameNum) {
		super(frameNum);
	}

	@Override
	String makeScoreMark() {
		if (pinsPerFrame.isEmpty() && getFrameNum() == 9) {
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
	Score getScore() {
		Score score = getScoreDepdingOnPins();
		if (score == null) {
			return null;
		}
		if (score.isEnded()) {
			return score;
		}
		return getScore(score);	
	}
	
	@Override
	Score getScoreDepdingOnPins() {
		int sum = getSumOfFrame();
		if (sum >= 10) {
			return new Score(0, 3);
		}
		if (pinsPerFrame.size() == 2) {
			return new Score(sum, 0);				
		}
		return null;
	}
	
	@Override
	boolean isEnded() {
		if (getFrameNum() == 10) {
			return true;
		}
		if (pinsPerFrame.size() == 3) {
			return true;
		}
		return pinsPerFrame.size() == 2 && pinsPerFrame.get(0) + pinsPerFrame.get(1) < 10;
	}
}
