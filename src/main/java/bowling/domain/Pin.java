package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Pin {
	public static final int STRIKE = 10;
	private List<Integer> pins;

	public Pin(List<Integer> pins) {
		this.pins = pins;
	}

	public static Pin of() {
		List<Integer> pins = new ArrayList<>();
		return new Pin(pins);
	}

	public void addScore(int score) {
		pins.add(score);
	}

	public boolean checkNotThird() {
		if (pins.size() == 2) {
			if (!(isStrike(pins.get(0)) || isSpare())) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		return pins.size();
	}

	public int getPin(int i) {
		return pins.get(i);
	}

	public int totalScore() {
		int total = 0;
		for (Integer integer : pins) {
			total += integer;
		}
		return total;
	}

	public int beforePlusNow(int beforeScore) {
		return totalScore() + beforeScore;
	}

	public String checkScore() {

		if (pins.size() == 1) {
			return checkFirstPin() + "  ";
		}
		return checkFirstPin() + "|" + checkSecondPin();
	}

	public String checkLastScore() {
		if (pins.size() == 1) {
			return checkFirstPin() + "|" + " ";
		}

		if (pins.size() == 2) {
			return checkFirstPin() + "|" + checkSecondPin();
		}

		return checkFirstPin() + "|" + checkSecondPin() + "|" + checkThirdPin();
	}

	public static boolean isStrike(int pin) {
		return pin == STRIKE;
	}

	public boolean isStrike() {
		return isStrike(pins.get(0));
	}

	public boolean isSpare() {
		return isSpare(pins.get(0), pins.get(1));
	}

	public static boolean isSpare(int first, int second) {
		return second == STRIKE - first;
	}

	public String checkFirstPin() {
		if (isStrike()) {
			return "X";
		}
		return String.valueOf(pins.get(0));
	}

	public String checkSecondPin() {
		if (isSpare()) {
			return "/";
		}
		if (isStrike(pins.get(1))) {
			return "X";
		}
		return String.valueOf(pins.get(1));
	}

	public String checkThirdPin() {
		if (isSpare()) {
			return String.valueOf(pins.get(2));
		}
		if (isSpare(pins.get(1), pins.get(2))) {
			return "/";
		}
		if (isStrike(pins.get(2))) {
			return "X";
		}
		return String.valueOf(pins.get(2));
	}

}
