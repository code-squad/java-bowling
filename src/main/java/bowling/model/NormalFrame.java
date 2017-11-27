package bowling.model;

public class NormalFrame extends Frame {
	private int pin1 = -1;
	private int pin2 = -1;

	public void play(int pin) {
		if (checkTryNo(1)) {
			tryOne(pin);
			return;
		}
		tryTwo(pin);
	}

	private void tryOne(int pin) {
		pin1 = pin;
		if (!isStrike(pin1)) {
			addTryNo();
		}
	}

	private void tryTwo(int pin) {
		checkSumOfPinsExceedTen(pin1, pin);// exception나면 어차피 아래코드 실행 안 됨
		pin2 = pin;
	}

	public String getStatus() {
		if (!isNotBlank(pin2)) {
			return makeStatus(pin1);
		}
		return makeStatus(pin1, pin2);
	}

	public boolean isEnd() {
		if (isStrike(pin1) || (isNotBlank(pin1) && isNotBlank(pin2))) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "NormalFrame [pin1=" + pin1 + ", pin2=" + pin2 + "]";
	}
}