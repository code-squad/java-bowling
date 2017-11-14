package bowling.frame.state.normalframe;

import bowling.frame.state.End;

public class NormalFrameSpare extends End {

	private int firstScore;
	private int secondScore;

	public NormalFrameSpare(int firstScore, int secondScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}

	@Override
	public String getPresentScore() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(firstScore);
		stringBuilder.append("|/");
		return stringBuilder.toString();
	}

	@Override
	public int getFinalScore() {
		return 10;
	}

}
