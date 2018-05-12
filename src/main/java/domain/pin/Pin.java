package domain.pin;

import domain.status.Ready;
import domain.status.Status;

public class Pin {
	public static final int DEFAULT_START_PIN_COUNT = 10;
	
	private int pin;
	private Status status;
	
	public Pin(int pin) {
		this.pin = pin;
		this.status = new Ready().next(pin);
	}
	
	public Pin(int pin, Status status) {
		this.pin = pin;
		this.status = status;
	}
	
	public int getPin() {
		return pin;
	}
	
	public Status getStatus() {
		return status;
	}
}
