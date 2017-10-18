package bowling.model;

public class LastFrame extends Frame {
	@Override
	public int setScore(String knockedPins) {
		score.setScore(knockedPins);
		checkStrikeOrSpare(knockedPins);
		return checkEndFrame();
	}

	private void checkStrikeOrSpare(String knockedPins) {
		if (score.getScore() == 10) {
			round--;
		}
	}

	@Override
	public String getSumScore() {
		return score.getSumScore();
	}

	@Override
	protected int getScore() {
		return score.firstRoundScore() + score.secondRoundScore();
	}

	@Override
	protected void calculateSumScore(String sumScore) {
		if (isEndFrame()) {
			score.calculateSumScore(sumScore);
			return;
		}
	}
}
