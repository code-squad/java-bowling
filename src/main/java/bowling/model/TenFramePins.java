package bowling.model;

import exception.InvalidPinNumberException;

public class TenFramePins extends Pins {
	private int pin3 = -1;
	
	public TenFramePins(int pin1) {
		super(pin1);
	}
	
	protected void addThirdPin(int pin) {
		pin3 = pin;
	}
	
	protected boolean hasThirdPin() {
		return isNotBlank(pin3);
	}
	
	protected void checkPinsExceedCountThreeTry(int pin3) {
		if (isStrike() && !isStrike(pin2) && pin2 + pin3 > 10) {
			throw new InvalidPinNumberException("투구의 합이 10을 초과할 수 없습니다.");
		}
	}
	
	protected String addStatus(String status) {
		if (isStrike() && isSpare(pin3)) {
			return status + "|/";
		}
		return status + "|" + makeStatus(pin3);
	}

	protected String makeSecondPinStatus() {
		if (isSpare()) {
			return makeSpare();
		}
		return makeMiss();
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

	public String pinToStatus(int pin) {
		if (pin == 0) {
			return "-";
		}
		return String.valueOf(pin);
	}
	
	public Score calculate(Score score) {
		score = score.addScore(pin1);
		if(!score.isFinish() && hasSecondPin()) {
			score = score.addScore(pin2);
		}
		return score;
	}

	public int totalScore() {
		return pin1 + pin2 + pin3;
	}
}