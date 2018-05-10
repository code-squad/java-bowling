package domain.status;

import domain.pin.Pins;

public class Gutter implements Status {
	@Override
	public String display() {
		return "G";
	}
	
	@Override
	public boolean isClear() {
		return false;
	}
	
	@Override
	public Status next(int pin) {
		if(pin == Pins.DEFAULT_START_PIN_COUNT) {
			return new Spare();
		}
		
		if(pin == 0) {
			return new Miss(pin);
		}
		
		return new Open(pin);
	}
	
	@Override
	public int getLeftPin() {
		return Pins.DEFAULT_START_PIN_COUNT;
	}
}
