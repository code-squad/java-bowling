package bowling.frame.state.normalframe;

import bowling.frame.state.Running;
import bowling.frame.state.State;

public class NormalFrameFirst extends Running {

	private int firstScore;

	public NormalFrameFirst(int score) {
		this.firstScore = score;
	}

	@Override
	public State bowl(int score) {
		if (firstScore + score == 10) {
			return new NormalFrameSpare(firstScore, score);
		}
		return new NormalFrameSecond(firstScore, score);
	}

	@Override
	public String getPresentScore() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(firstScore);
		return stringBuilder.toString();
	}

	@Override
	public int getFirstScore() {
		return firstScore;
	}

	@Override
	public int getSecondScore() {
		return 0;
	}
}
