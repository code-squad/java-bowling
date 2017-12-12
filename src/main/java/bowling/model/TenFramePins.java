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
//부모 클래스랑 비슷한 메소드가 많음. 파라미터 있고 없고 차이.. 이렇게 분리하는 게 의미가 있나?
//포비: 메소드 이름을 바꾸거나 클래스 구조를 바꾸세요
//클래스 설계가 잘 안되면 코드가 계속 지저분해짐
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

	public int totalScore() {
		return pin1 + pin2 + pin3;
	}
	@Override
	protected boolean isEnd() {
		return hasThirdPin() || (hasSecondPin() && isMiss(pin1, pin2));
	}
	
	protected int getTenScore() {
		if (isMiss(pin1, pin2)) {
			return getScore().getScore();
		}
		return totalScore();
	}
}