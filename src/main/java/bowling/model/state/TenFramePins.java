package bowling.model.state;

import bowling.model.Score;
import exception.InvalidPinNumberException;

public class TenFramePins extends NormalPins {
	private int pin3 = -1;
	
	public TenFramePins(int pin1) {
		super(pin1);
	}
	
	public void addPin(int pin) {
		if(!hasSecondPin()) {
			checkPinsExceedCount(pin);
			pin2 = pin;
			return;
		}
		checkPinsExceedCountThreeTry(pin);
		pin3 = pin;
	}

	protected boolean hasThirdPin() {
		return isNotBlank(pin3);
	}

	protected void checkPinsExceedCountThreeTry(int pin3) {
		if (isStrike(pin1) && !isStrike(pin2) && pin2 + pin3 > 10) {
			throw new InvalidPinNumberException("투구의 합이 10을 초과할 수 없습니다.");
		}
	}
	
	protected String makeThirdStatus(String status) {
		if (isStrike(pin1) && isSpare(pin2, pin3)) {
			return status + "|/";
		}
		return status + "|" + makeStatus(pin3);
	}

	private int totalScore() {
		return pin1 + pin2 + pin3;
	}

	public boolean isEnd() {
		return hasThirdPin() || (hasSecondPin() && isMiss(pin1, pin2));
	}
	
	protected Score getTenScore() {
		if (hasSecondPin() && isMiss(pin1, pin2)) {
			return getScore();
		}
		return new Score(totalScore(), 0);
	}
}