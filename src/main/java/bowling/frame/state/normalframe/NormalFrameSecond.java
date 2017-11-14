package bowling.frame.state.normalframe;

import bowling.frame.state.End;

public class NormalFrameSecond extends End {

	private int firstScore;
	private int secondScore;

	public NormalFrameSecond(int firstScore, int secondScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}

	@Override
	public String getPresentScore() {
		StringBuilder stringBuilder = new StringBuilder();
		if (secondScore == 0) {
			stringBuilder.append(firstScore);
			stringBuilder.append("|-");
			return stringBuilder.toString();
		}
		stringBuilder.append(firstScore);
		stringBuilder.append("|");
		stringBuilder.append(secondScore);
		return stringBuilder.toString();
	}

	@Override
	public int getFinalScore() {
		return firstScore + secondScore;
	}

}
