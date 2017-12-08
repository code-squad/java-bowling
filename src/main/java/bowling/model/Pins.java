package bowling.model;

import exception.InvalidPinNumberException;

public class Pins {
	public static final int MAX_PINS = 10;
	protected int pin1 = -1;
	protected int pin2 = -1;
	
	public Pins(int pin1) {
		this.pin1 = pin1;
	}
	
	public void addPin(int pin) {
		this.pin2 = pin;
	}
	
	protected  boolean isSpare() {
		return pin1 + pin2 == MAX_PINS;
	}
	
	protected boolean isSpare(int pin3) {
		return pin2 + pin3 == MAX_PINS;
	}

	protected boolean isMiss(int pin3) {
		return pin2 + pin3 < MAX_PINS;
	}
	
	protected boolean isMiss() {
		return pin1 + pin2 < MAX_PINS;
	}

	protected boolean isStrike() {
		return pin1 == MAX_PINS;
	}

	protected static boolean isStrike(int pin) {
		return pin == MAX_PINS;
	}

	private String makeSpare() {
		return pinToStatus(pin1) + "|/";
	}

	private String makeMiss() {
		return pinToStatus(pin1) + "|" + pinToStatus(pin2);
	}
	
	protected String makeFirstPinStatus() {
		if (isStrike()) {
			return "X";
		}
		return pinToStatus(pin1);
	}

	public String pinToStatus(int pin) {
		if (pin == 0) {
			return "-";
		}
		return String.valueOf(pin);
	}

	protected String makeSecondPinStatus() {
		if (isSpare()) {
			return makeSpare();
		}
		return makeMiss();
	}

	protected static boolean isNotBlank(int pin) {
		return pin >= 0;
	}
	
	protected boolean hasSecondPin() {
		return isNotBlank(pin2);
	}
	
	protected void checkPinsExceedCount(int pin2) {
		if (!isStrike() && pin1 + pin2 > MAX_PINS) {
			throw new InvalidPinNumberException("투구의 합이 10을 초과할 수 없습니다.");
		}
	}
	
	public Score getScore() {
		if(isStrike()) {
			return new Score(MAX_PINS, 2);
		}
		if(hasSecondPin() && isSpare()) {
			return new Score(MAX_PINS, 1);
		}
		if(hasSecondPin() && isMiss()) {
			return new Score(pin1 + pin2, 0);
		}
		return new Score(pin1, 1);
	}
	
	public Score calculate(Score score) {
		score = score.addScore(pin1);
		if(!score.isFinish() && hasSecondPin()) {
			score = score.addScore(pin2);
		}
		return score;
	}
}