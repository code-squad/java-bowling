package domain.status;

import domain.pin.Pin;

public class Open extends Status {
	private int startPin;
	private int pin;
	
	public Open(int pin) {
		this.startPin = Pin.DEFAULT_START_PIN_COUNT;
		this.pin = pin;
	}
	
	public Open(int startPin, int pin) {
		this.startPin = startPin;
		this.pin = pin;
	}
	
	@Override
	public String display() {
		return Integer.toString(pin);
	}
	
	@Override
	public boolean isClear() {
		return false;
	}
	
	@Override
	public boolean isComplete() {
		return true;
	}
	
	@Override
	public Status next(int pin) {
		throw new RuntimeException("다음 상태를 가질 수 없습니다.");
	}
	
	@Override
	public int getLeftPin() {
		return startPin - pin;
	}
}
