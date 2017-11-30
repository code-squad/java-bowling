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
	
	public void play(int pin, Frame previousFrame) {
		if (checkTryNo(1)) {
			tryOne(pin, previousFrame);
			return;
		} else if (checkTryNo(2)) {
			tryTwo(pin, previousFrame);
			return;
		}
		tryThree(pin);
	}

	private void tryOne(int pin) {
		addTryNo();
		pin1 = pin;
	}

	private void tryOne(int pin, Frame previousFrame) {
		tryOne(pin);
		if(previousFrame.isSpare()) {
			previousFrame.setSum(10+pin1);
		}
	}
	
	private void tryTwo(int pin) {
		checkSumOfPinsExceedTen(pin1, pin);
		addTryNo();
		pin2 = pin;
		if(isMiss(pin1, pin2)) {
			setSum(pin1 + pin2);
		}
	}
	private void tryTwo(int pin, Frame previousFrame) {
		tryTwo(pin);
		if(previousFrame.isStrike()) {
			previousFrame.setSum(10+pin1+pin2);
		}
	}

	private void tryThree(int pin) {
		checkSumOfPinsExceedTen(pin1, pin2, pin);
		pin3 = pin;
		setSum(pin1 + pin2 + pin3);
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

	public void sumTwoStrike(Frame beforePreviousFrame) {
		beforePreviousFrame.setSum(20+pin1);
	}
}