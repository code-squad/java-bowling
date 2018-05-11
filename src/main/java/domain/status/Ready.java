package domain.status;

import domain.pin.Pin;

public class Ready extends Status{
	@Override
	public String display() {
		return "";
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
			return new Strike();
		}
		
		if(pin == 0) {
			return new Gutter();
		}
		
		return new None(pin);
	}
	
	@Override
	public int getLeftPin() {
		return Pin.DEFAULT_START_PIN_COUNT;
	}
}
