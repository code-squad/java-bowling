package bowling.frame.state.lastframe;

import bowling.frame.state.BowlingEnd;

public class LastBonuce extends BowlingEnd {

	private int firstScore;
	private int secondScore;
	private int thirdScore;

	public LastBonuce(int firstScore, int secondScore, int thirdScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
		this.thirdScore = thirdScore;
	}

	@Override
	public String getPresentScore() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(firstScore);
		stringBuilder.append("|");
		stringBuilder.append(secondScore);
		stringBuilder.append("|");
		stringBuilder.append(thirdScore);
		return stringBuilder.toString();
	}

	@Override
	public int getFinalScore() {
		return firstScore + secondScore + thirdScore;
	}

	@Override
	public int getFirstScore() {
		return firstScore;
	}

	@Override
	public int getSecondScore() {
		return secondScore;
	}

}
