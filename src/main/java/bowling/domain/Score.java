package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Score {
	private static final int STRIKE = 10;
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
			if (!(scores.get(0) == STRIKE || isSpare(scores.get(0), scores.get(1)))) {
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
			return checkFirstPin(scores.get(0)) + "  ";
		}
		return checkFirstPin(scores.get(0)) + "|" + checkSecondThirdPin(scores.get(0), scores.get(1));
	}

	public String checkLastScore() {
		if (scores.size() == 1) {
			return checkFirstPin(scores.get(0)) + "|";
		}

		if (scores.size() == 2) {
			return checkFirstPin(scores.get(0)) + "|" + checkSecondThirdPin(scores.get(0), scores.get(1));
		}

		return checkFirstPin(scores.get(0)) + "|" + checkSecondThirdPin(scores.get(0), scores.get(1)) + "|"
				+ checkSecondThirdPin(scores.get(1), scores.get(2));
	}

	public static boolean isSpare(int first, int second) {
		return second == STRIKE - first;
	}

	public static String checkFirstPin(int pin) {
		if (pin == STRIKE) {
			return "X";
		}
		return String.valueOf(pin);
	}

	public static String checkSecondThirdPin(int first, int second) {
		if (second == STRIKE - first) {
			return "/";
		}
		if (second == STRIKE) {
			return "X";
		}
		return String.valueOf(second);
	}

}
