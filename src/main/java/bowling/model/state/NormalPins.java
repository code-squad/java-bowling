package bowling.model.state;

import bowling.model.Score;
import exception.InvalidPinNumberException;

public class NormalPins {
	public static final int MAX_PINS = 10;
	protected int pin1 = -1;
	protected int pin2 = -1;
	
	public NormalPins() {}
	
	public NormalPins(int pin1) {
		this.pin1 = pin1;
	}
	
	public void addPin(int pin) {
		checkPinsExceedCount(pin);
		this.pin2 = pin;
	}
	
	protected boolean isSpare(int previousPin, int pin) {
		return previousPin + pin == MAX_PINS;
	}
	
	protected boolean isMiss(int previousPin, int pin) {
		return previousPin + pin < MAX_PINS;
	}
	
	protected boolean isStrike(int pin) {
		return pin == MAX_PINS;
	}

	private String makeSpare() {
		return makeStatus(pin1) + "|/";
	}

	private String makeMiss() {
		return makeStatus(pin1) + "|" + makeStatus(pin2);
	}
	
	protected String makeStatus(int pin) {
		if (isStrike(pin)) {
			return "X";
		}
		return pinToStatus(pin);
	}

	private String pinToStatus(int pin) {
		if (pin == 0) {
			return "-";
		}
		return String.valueOf(pin);
	}

	public String getStatus() {
		if (!hasSecondPin()) {
			return makeFirstPinStatus();
		}
		return makeSecondPinStatus();
	}
	
	protected String makeFirstPinStatus() {
		return makeStatus(pin1);
	}
	
	protected String makeSecondPinStatus() {
		if (isSpare(pin1, pin2)) {
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
		if (!isStrike(pin1) && pin1 + pin2 > MAX_PINS) {
			throw new InvalidPinNumberException("투구의 합이 10을 초과할 수 없습니다.");
		}
	}
	
	public Score calculate(Score score) {
		score = score.addScore(pin1);
		if(!score.isFinish() && hasSecondPin()) {
			score = score.addScore(pin2);
		}
		return score;
	}
	
	public Score getScore() {
//이런 분기문을 다형성으로 없앨 수 있음
		if(isStrike(pin1)) {
			return new Score(MAX_PINS, 2);
		}
		if(hasSecondPin() && isSpare(pin1, pin2)) {
			return new Score(MAX_PINS, 1);
		}
		if(hasSecondPin() && isMiss(pin1, pin2)) {
			return new Score(pin1 + pin2, 0);
		}
		return new Score(pin1, 1);
	}
	
	public boolean isEnd() {
		return isStrike(pin1) || hasSecondPin();
	}

	@Override
	public String toString() {
		return "NormalPins [pin1=" + pin1 + ", pin2=" + pin2 + "]";
	}
}