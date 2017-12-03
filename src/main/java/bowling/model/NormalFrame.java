package bowling.model;

public class NormalFrame extends Frame {
	private int pin1 = -1;
	private int pin2 = -1;
	private Frame nextFrame = null;

	public Frame makeNextFrame(int frameNum) {
		if(frameNum == 9) {
			nextFrame = new TenFrame();
		}
		nextFrame = new NormalFrame();
		return nextFrame;
	}
	
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
/************************ 합계용 **************************/	
	public boolean isSpare() {
		return pin1 + pin2 == 10;
	}

	public boolean isStrike() {
		return pin1 == 10;
	}
	
	public int getSum() {
		//재귀...하려면 pin 기본값이 0이어야 pin1 + pin2 + nextFrame.getSum() 이렇게 할 텐데
		//재귀하면 pin1만 있을 때도 return되야 됨.근데 출력 하면 안 됨..
		if(!isNotBlank(pin2)&&!isStrike()) {
			return -1;
		}
		return calculate();
	}
	
	public int calculate() {
		if(nextFrame != null) {
			return calculate(nextFrame);
		}
		if(isNotBlank(pin2)){
			return pin1 + pin2;
		}
		return pin1; //문제: 10이 안 나와야 되는데 나옴. 근데 또 (ifStrike())로 막으면 2스트라이크/스트라이크+스페어 합계가 안 됨
	}
	
	public int calculate(Frame nextFrame) {
		if(isSpare()) {
			return 10 + nextFrame.calculate();
		} else if(isStrike()) {
			return 10 + nextFrame.calculate();
		}
		return pin1;
	}
	
	@Override
	public String toString() {
		return "NormalFrame [pin1=" + pin1 + ", pin2=" + pin2 + "]";
	}
}