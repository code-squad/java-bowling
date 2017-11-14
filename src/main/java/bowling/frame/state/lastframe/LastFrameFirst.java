package bowling.frame.state.lastframe;

import bowling.frame.state.Running;
import bowling.frame.state.State;

public class LastFrameFirst extends Running {

	private int firstScore;

	public LastFrameFirst(int score) {
		this.firstScore = score;
	}

	@Override
	public State bowl(int score) {
		if (firstScore + score == 10) {
			return new LastFrameSpare(firstScore, score);
		}
		return new LastFrameSecond(firstScore, score);
	}

	@Override
	public String getPresentScore() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(firstScore);
		return stringBuilder.toString();
	}

}
