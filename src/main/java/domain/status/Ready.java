package domain.status;

import domain.pin.Pins;

public class Ready implements Status{
	@Override
	public String display() {
		return "";
	}
	
	@Override
	public boolean isClear() {
		return false;
	}
	
	@Override
	public Status next(int pin) {
		if(pin == Pins.DEFAULT_START_PIN_COUNT) {
			return new Strike();
		}
		
		if(pin == 0) {
			return new Gutter();
		}
		
		return new None(pin);
	}
	
	@Override
	public int getLeftPin() {
		return Pins.DEFAULT_START_PIN_COUNT;
	}
}
