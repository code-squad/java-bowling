package bowling.model.state.last;

import bowling.model.state.EndState;

public class LastThird extends EndState {
	private int firstScore;
	private int secondScore;
	private int thirdScore;
	private int sumScore;

	public LastThird(int firstScore, int secondScore, int thirdScore) {
		if (firstScore + secondScore < 10) {
			throw new IllegalArgumentException();
		}
		this.firstScore = firstScore;
		this.secondScore = secondScore;
		this.thirdScore = thirdScore;
		this.sumScore = firstScore + secondScore + thirdScore;
	}

	@Override
	public String getKnockedPins() {
		return checkStrike(firstScore) + "|" + checkSecond() + "|" + checkThird();
	}

	private String checkSecond() {
		if (firstScore + secondScore == 10) {
			return "/";
		}
		return checkStrike(secondScore);
	}

	private String checkThird() {
		if (firstScore + secondScore != 10 && secondScore + thirdScore== 10) {
			return "/";
		}
		return checkStrike(thirdScore);
	}

	private String checkStrike(int score) {
		if (score == 10) {
			return "X";
		}
		return Integer.toString(score);
	}
	
	@Override
	public int getScore() {
		return firstScore + secondScore + thirdScore;
	}

	@Override
	public int getFirstScore() {
		return firstScore;
	}

	@Override
	public boolean calculateSumScore(int beforeSum) {
		sumScore += beforeSum;
		return true;
	}

	@Override
	public int getSumScore() {
		return sumScore;
	}
}
