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

		if (score instanceof StrikeScore || score instanceof SpareScore) {
			return bonusBowl(intScore);
		}

		return null;
	}

	public Frame normalBowl(int intScore) {
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

	public Frame bonusBowl(int intScore) {
		if (intScore == 10 && bonusScores.size() < 1) {
			bonusScores.add(new StrikeScore());
			return this;
		}

		if (intScore == 10 && bonusScores.size() == 1) {
			bonusScores.add(new StrikeScore());
			return null;
		}

		if (temp < 0 && intScore < 10) {
			temp = intScore;
			return this;
		}

		if (temp >= 0 && temp + intScore == 10) {
			score = new SpareScore(temp);
		}

		if (temp >= 0 && temp + intScore < 10) {
			score = new MissScore(temp, intScore);
		}

		return null;
	}

}
