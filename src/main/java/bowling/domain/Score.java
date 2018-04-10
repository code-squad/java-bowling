package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Score {
	public static final int STRIKE = 10;
	private List<Integer> scores;

	public Score(List<Integer> scores) {
		this.scores = scores;
	}

	public static Score of() {
		List<Integer> scores = new ArrayList<>();
		return new Score(scores);
	}

	public void addScore(int score) {
		scores.add(score);
	}

	public boolean checkNotThird() {
		if (scores.size() == 2) {
			if (!(isStrike(scores.get(0)) || isSpare(scores.get(0), scores.get(1)))) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		return scores.size();
	}

	public int getScore(int i) {
		return scores.get(i);
	}

	public String checkScore() {

		if (scores.size() == 1) {
			return checkFirstPin() + "  ";
		}
		return checkFirstPin() + "|" + checkSecondPin();
	}

	public String checkLastScore() {
		if (scores.size() == 1) {
			return checkFirstPin() + "|"+" ";
		}

		if (scores.size() == 2) {
			return checkFirstPin() + "|" + checkSecondPin();
		}

		return checkFirstPin() + "|" + checkSecondPin() + "|" + checkThirdPin();
	}

	
	public static boolean isStrike(int pin) {
		return pin == STRIKE;
	}
	
	public static boolean isSpare(int first, int second) {
		return second == STRIKE - first;
	}

	public String checkFirstPin() {
		if (isStrike(scores.get(0))) {
			return "X";
		}
		return String.valueOf(scores.get(0));
	}

	public String checkSecondPin() {
		if (isSpare(scores.get(0), scores.get(1))) {
			return "/";
		}
		if (isStrike(scores.get(1))) {
			return "X";
		}
		return String.valueOf(scores.get(1));
	}

	public String checkThirdPin() {
		if (isSpare(scores.get(0), scores.get(1))) {
			return String.valueOf(scores.get(2));
		}
		if (isSpare(scores.get(1), scores.get(2))) {
			return "/";
		}
		if (isStrike(scores.get(2))) {
			return "X";
		}
		return String.valueOf(scores.get(2));
	}

}
