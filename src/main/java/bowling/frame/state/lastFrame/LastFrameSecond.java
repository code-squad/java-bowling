package bowling.frame.state.lastFrame;

import bowling.frame.state.BowlingEnd;

public class LastFrameSecond extends BowlingEnd {

	private int firstScore;
	private int secondScore;

	public LastFrameSecond(int firstScore, int secondScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}

	@Override
	public String getPresentScore() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(firstScore);
		stringBuilder.append("|");
		stringBuilder.append(secondScore);
		return stringBuilder.toString();
	}

}
