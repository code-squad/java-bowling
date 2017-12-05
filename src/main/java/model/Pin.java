package model;

import Exception.InvalidFalledPinInputException;

public class Pin {
	int pin;

	public Pin(int pin) throws InvalidFalledPinInputException {
		if (pin < 0 || pin > 10) {
			throw new InvalidFalledPinInputException();
		}
		this.pin = pin;
	}

	public boolean isStrike() {
		if (this.pin == 10) {
			return true;
		}
		return false;
	}

	public boolean isSpare(Pin secondPin) {
		if (this.pin + secondPin.pin == 10) {
			return true;
		}
		return false;
	}

	public int getPin() {
		return pin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pin;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pin other = (Pin) obj;
		if (pin != other.pin)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pin [pin=" + pin + "]";
	}
}
