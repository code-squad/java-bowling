package bowling.model;

import java.util.ArrayList;
import java.util.List;

public class FinalFrame extends Frame {

	private List<Score> bonusScores;

	public FinalFrame() {
		super(10);
		bonusScores = new ArrayList<>();
	}

	@Override
	public Frame bowl(int intScore) {
		if (score == null) {
			return normalBowl(intScore);
		}

		if (temp == 10) {
			return afterStrike(intScore);
		}

		if (temp != -1 && temp < 10) {
			return afterNotStrike(intScore);
		}

		if (score instanceof StrikeScore) {
			return afterStrike(intScore);
		}

		if (score instanceof SpareScore) {
			return afterNotStrike(intScore);
		}

		return null;
	}

	private boolean isFinished() {
		int size = bonusScores.size();
		if (score == null)
			return false;
		if (size == 0 && score instanceof MissScore)
			return true;
		if (size == 1 &&
				(!(score instanceof StrikeScore) ||
						!(bonusScores.get(0) instanceof StrikeScore)))
			return true;

		return size == 2;
	}

	private Frame normalBowl(int intScore) {
		temp.add(intScore);

		if (temp.size() < 2 && intScore < 10)
			return this;

		score = Score.of(temp);

		if(score instanceof MissScore)
			return null;

		temp = new ArrayList<>();
		return this;
	}

	private Frame afterStrike(int intScore) {
		if (intScore < 10 && bonusScores.isEmpty()) {
			temp.add(intScore);
			return this;
		}

		if (intScore < 10) {
			bonusScores.add(new MissScore(intScore));
			return null;
		}

		bonusScores.add(new StrikeScore());
		if (bonusScores.size() == 1) {
			temp = intScore;
			return this;
		}

		return null;
	}

	private Frame afterNotStrike(int intScore) {
		if (intScore == 10) {
			bonusScores.add(new StrikeScore());
		}

		if (temp + intScore == 10) {
			bonusScores.add(new SpareScore(temp));
		}

		if (temp != -1 && temp + intScore < 10) {
			bonusScores.add(new MissScore(temp, intScore));
		}

		if (temp == -1 && intScore != 10) {
			bonusScores.add(new MissScore(intScore));
		}

		return null;
	}

	@Override
	public String toString() {
		String text = super.toString().trim();

		for (Score bonusScore : bonusScores) {
			text += "|" + bonusScore.toString().trim();
		}
		return text;
	}
}
