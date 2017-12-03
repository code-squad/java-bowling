package model;

import Exception.InvalidFalledPinInputException;

public class Pin {
	int pin;
	
	public Pin(int pin) throws InvalidFalledPinInputException {
		if(pin < 0 || pin > 10) {
			throw new InvalidFalledPinInputException();
		}
		this.pin = pin;
	}

	public int getPin() {
		return pin;
	}
	
	
}
