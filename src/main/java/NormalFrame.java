public class NormalFrame extends Frame{
	NormalFrame(int frameNum) {
		super(frameNum);
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
		return getNextFrame().getScore(score);
	}

	@Override
	Score getScoreDepdingOnPins() {
		int sum = getSumOfFrame();
		if (sum == 10 && getSize() == 1) {
			return new Score(sum, 2);
		}
		if (sum == 10 && getSize() == 2) {
			return new Score(sum, 1);
		}
		if (getSize() == 2) {
			return new Score(sum, 0);			
		}
		return null;
	}

	@Override
	boolean isEnded() {
		if (isEmpty()) {
			return false;
		}
		if (getSize() == 2) {
			return true;
		}
		return get(0) == 10;
	}

	@Override
	String makeScoreMark() {
		if (getSize() == 1) {
			return makeFirstScoreMark();
		}
		if (getSize() == 2) {
			if (get(0) + get(1) > 10) {
				throw new InputException("투구의 합은 10 이하여야 합니다");
			}
			return makeSecondScoreMark();
		}
		return "      |";
	}
}
