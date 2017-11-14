package bowling.frame.state.lastframe;

import bowling.frame.state.Running;
import bowling.frame.state.State;

public class LastFrameSpare extends Running {

	private int firstScore;
	private int secondScore;

	public LastFrameSpare(int firstScore, int secondScore) {
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
		stringBuilder.append(firstScore);
		stringBuilder.append("|/");
		return stringBuilder.toString();
	}

}
