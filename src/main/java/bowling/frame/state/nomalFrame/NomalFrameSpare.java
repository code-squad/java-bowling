package bowling.frame.state.nomalFrame;

import bowling.frame.state.End;

public class NomalFrameSpare extends End {

	private int firstScore;
	private int secondScore;

	public NomalFrameSpare(int firstScore, int secondScore) {
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

}
