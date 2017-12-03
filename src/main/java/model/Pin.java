package model;

import Exception.InvalidFalledPinInputException;

public class Pin {
	private static final int PIN_MIN_VALUE = 0;
	private static final int PIN_MAX_VALUE = 10;

	private int pin;
	
	public Pin(int pin) throws InvalidFalledPinInputException {
		if(pin < PIN_MIN_VALUE || pin > PIN_MAX_VALUE) {
			throw new InvalidFalledPinInputException();
		}
		this.pin = pin;
	}

	public int getPin() {
		return pin;
	}
	
	
}
