package bowling.model;

import exception.InvalidPinNumberException;

public abstract class Frame {
	private int tryNo = 1;
	
	abstract public String getStatus();

	protected boolean checkTryNo(int no) {
		return tryNo == no;
	}

	abstract public void play(int pin);

	protected static boolean isSpare(int previousPin, int pin) {
		return previousPin + pin == 10;
	}

	protected static boolean isMiss(int previousPin, int pin) {
		return previousPin + pin < 10;
	}

	protected static boolean isStrike(int pin) {
		return pin == 10;
	}

	private String makeSpare(int pin) {
		return makeStatus(pin) + "|/";
	}

	private String makeMiss(int previousPin, int pin) {
		return makeStatus(previousPin) + "|" + makeStatus(pin);
	}

	protected void addTryNo() {
		tryNo++;
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

	protected String makeStatus(int previousPin, int pin) {
		if (isSpare(previousPin, pin)) {
			return makeSpare(previousPin);
		}
		return makeMiss(previousPin, pin);
	}

	protected boolean isNotBlank(int pin) {
		return pin >= 0;
	}

	public abstract boolean isEnd();

	protected void checkSumOfPinsExceedTen(int previousPin, int pin) {
		if (previousPin != 10 && previousPin + pin > 10) {
			throw new InvalidPinNumberException("투구의 합이 10을 초과할 수 없습니다.");
		}
	}
	
	/************************ 합계용 **************************/	
	abstract public boolean isSpare();

	abstract public boolean isStrike();
	
	abstract public int getSum();
	
	abstract public Frame makeNextFrame(int frameNum);
}