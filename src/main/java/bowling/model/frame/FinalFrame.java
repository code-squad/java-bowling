package bowling.model.frame;

import bowling.model.score.Score;

public class FinalFrame extends Frame {

	public FinalFrame() {
		super(10);
	}

	@Override
	public Frame bowl(int intScore) {
		temp.add(intScore);

		if (temp.size() < 2 && intScore < 10)
			return this;

		if (temp.size() == 2 && temp.get(0) + temp.get(1) >= 10) {
			return this;
		}

		score = Score.of(temp);
		return null;
	}

}
