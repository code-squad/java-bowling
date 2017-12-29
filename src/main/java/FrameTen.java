public class FrameTen extends Frame{
	FrameTen(int frameNum) {
		super(frameNum);
	}
	
	@Override
	String makeScoreMark() {
		if (isEmpty() && getFrameNum() == 9) {
			return "      |";			
		}
		if (getSize() == 1) {
			return makeFirstScoreMark();
		}
		if (getSize() == 2) {
			return makeSecondScoreMark();
		}
		if (getSize() == 3) {
			return makeThirdScoreMark();
		}
		return "";		
	}
	
	String makeThirdScoreMark() {
		if (get(0) + get(1) == 10) {
			return " " + changeScoreToMark(get(0)) +
					"|/|" + changeScoreToMark(get(2)) + "|";
		}
		if (get(1) + get(2) == 10) {
			return " X|" + changeScoreToMark(get(1)) + "|/|";
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
		if (getSize() == 2) {
			return new Score(sum, 0);				
		}
		return null;
	}
	
	@Override
	boolean isEnded() {
		if (getFrameNum() == 10) {
			return true;
		}
		if (getSize() == 3) {
			return true;
		}
		return getSize() == 2 && get(0) + get(1) < 10;
	}
}
