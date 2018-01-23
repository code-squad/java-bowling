package bowling.model.frame;

import bowling.model.score.*;

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
	public boolean isStrike() throws IndexOutOfBoundsException {
		return temp.get(0) == 10;
	}

	@Override
	public boolean isNextStrike() throws IndexOutOfBoundsException {
		return temp.get(1) == 10;
	}

	@Override
	public int getScore() throws Exception {
		if (score instanceof FinalScore) {
			return ((FinalScore) score).finalScore();
		}
		return score.currentScore();
	}

}
