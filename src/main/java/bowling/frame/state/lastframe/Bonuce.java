package bowling.frame.state.lastframe;

import bowling.frame.state.Running;
import bowling.frame.state.State;

public class Bonuce extends Running {

	private int firstScore;
	private int secondScore;

	public Bonuce(int firstScore, int secondScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}

	@Override
	public State bowl(int score) {
		return new LastBonuce(firstScore, secondScore, score);
	}

	@Override
	public String getPresentScore() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("X|");
		if (secondScore == 10) {
			stringBuilder.append("X");
			return stringBuilder.toString();
		}
		if (secondScore == 0) {
			stringBuilder.append("-");
			return stringBuilder.toString();
		}
		stringBuilder.append(secondScore);
		return stringBuilder.toString();
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
