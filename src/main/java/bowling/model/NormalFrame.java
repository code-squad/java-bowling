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
		//pin이 -1이니까 if문 분기가 됨...
		/*
		if(isNotBlank(pin2)) {
			if(isMiss(pin1, pin2)) {
				return pin1 + pin2;
			} 
		}
		if(isSpare() && nextFrame != null) {
			return 10 + nextFrame.getSum(); //pin1만 받을 수 있게
		}
		if(isStrike() && nextFrame != null) {
			return 10 + nextFrame.getSum(); //nextFrame이 strike면 nextFrame의 getSum();
		} */
		return -1;
	}
	@Override
	public String toString() {
		return "NormalFrame [pin1=" + pin1 + ", pin2=" + pin2 + "]";
	}
}