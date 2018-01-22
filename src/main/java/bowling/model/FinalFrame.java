package bowling.model;

import java.util.ArrayList;
import java.util.List;

public class FinalFrame extends Frame {

	List<Score> bonusScores;

	public FinalFrame() {
		super(10);
		bonusScores = new ArrayList<>();
	}

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

	private Frame normalBowl(int intScore) {
		if (temp < 0 && intScore < 10) {
			temp = intScore;
			return this;
		}

		if (temp >= 0 && temp + intScore < 10) {
			score = new MissScore(temp, intScore);
			return null;
		}

		if (temp < 0 && intScore == 10) {
			score = new StrikeScore();
		}

		if (temp >= 0 && temp + intScore == 10) {
			score = new SpareScore(temp);
		}

		temp = -1;
		return this;
	}

	private Frame afterStrike(int intScore) {
		if (intScore < 10 && bonusScores.isEmpty()) {
			temp = intScore;
			return this;
		}

		if (intScore < 10 && !bonusScores.isEmpty()) {
			bonusScores.add(new MissScore(intScore, 0));
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
			bonusScores.add(new MissScore(intScore, 0));
		}

		return null;
	}

}
