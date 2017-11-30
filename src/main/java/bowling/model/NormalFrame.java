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
	public void play(int pin, Frame previousFrame) {
		if (checkTryNo(1)) {
			tryOne(pin, previousFrame);
			return;
		}
		tryTwo(pin, previousFrame);
	}

	private void tryOne(int pin) {
		pin1 = pin;
		if (!isStrike(pin1)) {
			addTryNo();
		}
	}

	private void tryOne(int pin, Frame previousFrame) {
		tryOne(pin);
		if(previousFrame.isSpare()) {
			previousFrame.setSum(10+pin1);
		}
	}

	private void tryTwo(int pin) {
		checkSumOfPinsExceedTen(pin1, pin);// exception나면 어차피 아래코드 실행 안 됨
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
	
	@Override
	public String toString() {
		return "NormalFrame [pin1=" + pin1 + ", pin2=" + pin2 + "]";
	}
}