package domain.status;

import domain.pin.Pin;

public class Gutter extends Status {
	@Override
	public String display() {
		return "G";
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
		if(pin == Pin.DEFAULT_START_PIN_COUNT) {
			return new Spare();
		}
		
		if(pin == 0) {
			return new Miss(pin);
		}
		
		return new Open(pin);
	}
	
	@Override
	public int getLeftPin() {
		return Pin.DEFAULT_START_PIN_COUNT;
	}
}
