package bowling.model;

import exception.InvalidPinNumberException;

public class TenFrame extends Frame {
	private int pin1 = -1;
	private int pin2 = -1;
	private int pin3 = -1;

	public void play(int pin) {
		if (checkTryNo(1)) {
			tryOne(pin);
			return;
		} else if (checkTryNo(2)) {
			tryTwo(pin);
			return;
		}
		tryThree(pin);
	}

	private void tryOne(int pin) {
		addTryNo();
		pin1 = pin;
	}

	private void tryTwo(int pin) {
		checkSumOfPinsExceedTen(pin1, pin);
		addTryNo();
		pin2 = pin;
		}
	
	private void tryThree(int pin) {
		checkSumOfPinsExceedTen(pin1, pin2, pin);
		pin3 = pin;
	}

	public boolean isEnd() {
		if (isNotBlank(pin2) && !isNotBlank(pin3)) {
			return pin1 + pin2 < 10;
		} else if (isNotBlank(pin3)) {
			return true;
		}
		return false;
	}

	private String addStatus(String status) {
		if (isStrike(pin1) && isSpare(pin2, pin3)) {
			return status + "|/";
		}
		return status + "|" + makeStatus(pin3);
	}

	public String getStatus() {
		if (isNotBlank(pin2) && !isNotBlank(pin3)) {
			return makeStatus(pin1, pin2);
		} else if (isNotBlank(pin3)) {
			return addStatus(makeStatus(pin1, pin2));
		}
		return makeStatus(pin1);
	}

	protected void checkSumOfPinsExceedTen(int pin1, int pin2, int pin3) {
		if (pin1 == 10 && pin2 != 10 && pin2 + pin3 > 10) {
			throw new InvalidPinNumberException("투구의 합이 10을 초과할 수 없습니다.");
		}
	}
	/************************ 합계용 **************************/	
	public boolean isSpare() {
		return pin1 + pin2 == 10;
	}

	public boolean isStrike() {
		return pin1 == 10;
	}
	
	public int getSum() {
		if(isNotBlank(pin3)) {
			return pin1 + pin2 + pin3;
		} else if(isNotBlank(pin2)) {
			if(isMiss(pin1, pin2)) {
				return pin1 + pin2;
			} 
		}
		return -1;
	}
	
	public Frame makeNextFrame(int frameNum) {
		return null;
	}
}