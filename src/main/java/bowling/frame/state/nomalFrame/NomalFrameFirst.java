package bowling.frame.state.nomalFrame;

import bowling.frame.state.Running;
import bowling.frame.state.State;

public class NomalFrameFirst extends Running {

	private int firstScore;

	public NomalFrameFirst(int score) {
		this.firstScore = score;
	}

	@Override
	public State bowl(int score) {
		if (firstScore + score == 10) {
			return new NomalFrameSpare(firstScore, score);
		}
		return new NomalFrameSecond(firstScore, score);
	}

	@Override
	public String getPresentScore() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(firstScore);
		return stringBuilder.toString();
	}
}
