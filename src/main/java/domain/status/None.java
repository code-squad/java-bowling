package domain.status;

import domain.pin.Pin;

public class None extends Status {
	private int pin;
	
	public None(int pin) {
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
		return false;
	}
	
	@Override
	public Status next(int pin) {
		validNext(pin);
		if(this.pin + pin == Pin.DEFAULT_START_PIN_COUNT) {
			return new Spare();
		}
		
		if(pin == 0) {
			return new Miss(pin);
		}
		
		return new Open(this.pin, pin);
	}
	
	@Override
	public int getLeftPin() {
		return Pin.DEFAULT_START_PIN_COUNT - pin;
	}
}
