package bowling.domain;

import java.util.ArrayList;
import java.util.List;

import bowling.view.Print;

public class Pin {
	public static final int STRIKE = 10;
	private List<Integer> pins;

	private Pin(List<Integer> pins) {
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
			return !(isStrike(pins.get(0)) || isSpare());
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

	public static boolean isStrike(int pin) {
		return pin == STRIKE;
	}

	public boolean isSpare() {
		return isSpare(pins.get(0), pins.get(1));
	}

	public static boolean isSpare(int first, int second) {
		return second == STRIKE - first;
	}

	public String checkPin() {
		if(pins.size()==0) {
			Print.printEmptyFrame();
			return "";
		}
		if (pins.size() == 1) {
			return checkFirstPin() + "  ";
		}
		if (pins.size() == 2) {
			return checkFirstPin() + "|" + checkSecondPin(0);
		}
		return checkFirstPin() + "|" + checkSecondPin(0) + "|" + checkSecondPin(1);
	}

	public String checkFirstPin() {
		if (isStrike(pins.get(0))) {
			return "X";
		}
		return String.valueOf(pins.get(0));
	}

	public String checkSecondPin(int i) {
		if (i == 1 && isSpare(pins.get(i - 1), pins.get(i))) {
			return String.valueOf(pins.get(i + 1));
		}
		if (isSpare(pins.get(i), pins.get(i + 1))) {
			return "/";
		}
		if (isStrike(pins.get(i + 1))) {
			return "X";
		}
		return String.valueOf(pins.get(i + 1));
	}

}