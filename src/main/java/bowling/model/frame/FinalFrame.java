package bowling.model.frame;

import bowling.model.score.*;

import java.util.Arrays;

public class FinalFrame extends Frame {

	public FinalFrame() {
		super(10);
	}

	@Override
	public Frame bowl(int intScore) {
		temp.add(intScore);

		if (temp.size() < 2)
			return this;

		if (temp.size() == 2 && temp.get(0) + temp.get(1) >= 10) {
			return this;
		}

		score = Score.of(temp);
		return null;
	}

	@Override
	public int getScore() throws Exception {
		if (score instanceof FinalScore) {
			return ((FinalScore) score).finalScore();
		}
		return score.currentScore();
	}

	@Override
	public Score getNextScore() throws Exception {
		if (temp.get(1) == 10)
			return Score.of(Arrays.asList(10));

		return null;
	}
}
